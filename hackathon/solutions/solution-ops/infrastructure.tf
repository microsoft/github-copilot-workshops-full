terraform {
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
    }
  }

  backend "azurerm" {
    resource_group_name  = "rg-hackathon-team-1"
    storage_account_name = "sahacktfstategh1"
    container_name       = "tfstate"
    key                  = "infrastructure.tfstate"
  }
}

provider "azurerm" {
  skip_provider_registration = true
  features {}
}

data "azurerm_resource_group" "existing" {
  name = var.resource_group_name
}

# Add your resources here
 resource "azurerm_log_analytics_workspace" "example" {
  name                = var.log_analytics_name
  location            = data.azurerm_resource_group.existing.location
  resource_group_name = data.azurerm_resource_group.existing.name
  sku                 = "PerGB2018"
  retention_in_days   = 30
}

resource "azurerm_application_insights" "example" {
  name                = var.app_insights_name
  location            = data.azurerm_resource_group.existing.location
  resource_group_name = data.azurerm_resource_group.existing.name
  application_type    = "web"
  workspace_id        = azurerm_log_analytics_workspace.example.id
}


resource "azurerm_app_service_plan" "appplan" {
  name                = var.app_service_plan_name
  location            = data.azurerm_resource_group.existing.location
  resource_group_name = data.azurerm_resource_group.existing.name

  sku {
    tier = "Standard"
    size = "S1"
  }
}

resource "azurerm_app_service" "example" {
  name                = var.app_service_name
  location            = data.azurerm_resource_group.existing.location
  resource_group_name = data.azurerm_resource_group.existing.name
  app_service_plan_id = azurerm_app_service_plan.appplan.id

   connection_string {
    name  = "DatabaseConnectionString"
    type  = "SQLServer"
    value = "Server=tcp:${azurerm_sql_server.sqlsrv.fully_qualified_domain_name},1433;Initial Catalog=${azurerm_sql_database.sqldb.name};Persist Security Info=False;User ID=${var.administrator_login};Password=${var.administrator_login_password};MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;"
  }

  app_settings = {
    "APPINSIGHTS_INSTRUMENTATIONKEY" = azurerm_application_insights.example.instrumentation_key
  }
}


resource "azurerm_sql_server" "sqlsrv" {
  name                         = var.sql_server_name
  resource_group_name          = data.azurerm_resource_group.existing.name
  location                     = data.azurerm_resource_group.existing.location
  version                      = var.sql_version
  administrator_login          = var.administrator_login
  administrator_login_password = var.administrator_login_password
}

resource "azurerm_sql_database" "sqldb" {
  name                = var.sql_database_name
  resource_group_name = data.azurerm_resource_group.existing.name
  location            = data.azurerm_resource_group.existing.location
  server_name         = azurerm_sql_server.sqlsrv.name

  requested_service_objective_name = "S0"
}

resource "azurerm_virtual_network" "vnet" {
  name                = "vnet-${var.resource_group_name}"
  location            = data.azurerm_resource_group.existing.location
  resource_group_name = data.azurerm_resource_group.existing.name
  address_space       = ["10.0.0.0/16"]
}

# Create a subnet in the virtual network
resource "azurerm_subnet" "subnetapp" {
  name                 = "subnet-app"
  resource_group_name  = data.azurerm_resource_group.existing.name
  virtual_network_name = azurerm_virtual_network.vnet.name
  address_prefixes     = ["10.0.1.0/24"]
  delegation {
    name = "delegation"

    service_delegation {
      name    = "Microsoft.Web/serverFarms"
      actions = ["Microsoft.Network/virtualNetworks/subnets/action"]
    }
  }
}

# Create a subnet in the virtual network
resource "azurerm_subnet" "subnetsql" {
  name                 = "subnet-sql"
  resource_group_name  = data.azurerm_resource_group.existing.name
  virtual_network_name = azurerm_virtual_network.vnet.name
  address_prefixes     = ["10.0.2.0/24"]
}


# Create a service plan with VNet integration enabled
resource "azurerm_app_service_virtual_network_swift_connection" "example" {
  app_service_id = azurerm_app_service.example.id
  subnet_id      = azurerm_subnet.subnetapp.id
}

# Create a private endpoint for the SQL Server in the subnet
resource "azurerm_private_endpoint" "private_endpoint" {
  name                = "pe-${var.resource_group_name}"
  location            = data.azurerm_resource_group.existing.location
  resource_group_name = data.azurerm_resource_group.existing.name
  subnet_id           = azurerm_subnet.subnetsql.id

  private_service_connection {
    name                           = "psc-${var.resource_group_name}"
    private_connection_resource_id = azurerm_sql_server.sqlsrv.id
    is_manual_connection           = false
    subresource_names =  ["sqlServer"]
  }
}


# Create a Private DNS Zone
resource "azurerm_private_dns_zone" "example" {
  name                = "privatelink.database.windows.net"
  resource_group_name = data.azurerm_resource_group.existing.name
}

resource "azurerm_private_dns_a_record" "example" {
  name                = var.sql_server_name
  zone_name           = azurerm_private_dns_zone.example.name
  resource_group_name = azurerm_private_dns_zone.example.resource_group_name
  ttl                 = 300
  records             = [azurerm_private_endpoint.private_endpoint.private_service_connection[0].private_ip_address]
}

# Link the Private DNS Zone to a Virtual Network
resource "azurerm_private_dns_zone_virtual_network_link" "example" {
  name                  = "example-link"
  resource_group_name   = data.azurerm_resource_group.existing.name
  private_dns_zone_name = azurerm_private_dns_zone.example.name
  virtual_network_id    = azurerm_virtual_network.vnet.id
}

# Create a Front Door
resource "azurerm_frontdoor" "afdapp" {
  name                                      = "afd-hackathon"
  resource_group_name                       = data.azurerm_resource_group.existing.name
  routing_rule {
    name               = "exampleRoutingRule"
    accepted_protocols = ["Http", "Https"]
    patterns_to_match  = ["/*"]
    frontend_endpoints = ["defaultFrontendEndpoint"]
    forwarding_configuration {
      forwarding_protocol = "MatchRequest"
      backend_pool_name   = "exampleBackendBing"
    }
  }

  backend_pool_load_balancing {
    name = "exampleLoadBalancingSettings"
  }

  backend_pool_health_probe {
    name = "exampleHealthProbeSetting"
  }

  backend_pool {
    name = "exampleBackendBing"
    backend {
      host_header = azurerm_app_service.example.default_site_hostname
      address     = azurerm_app_service.example.default_site_hostname
      http_port   = 80
      https_port  = 443
    }

    load_balancing_name = "exampleLoadBalancingSettings"
    health_probe_name   = "exampleHealthProbeSetting"
  }

  frontend_endpoint {
    name = "defaultFrontendEndpoint"
    host_name = "afd-hackathon.azurefd.net"
  }
}
