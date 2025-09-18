

variable "resource_group_name" {
  description = "The name of the resource group"
  default = "rg-hackathon-team-1"
}

variable "app_service_plan_name" {
  default     = "plan-ghhackathon-ops"
}

variable "app_service_name" {
  default     = "app-ghhackathon-ops"
}

variable "log_analytics_name" {
  default     = "log-ghhackathon-ops"
}
 

variable "app_insights_name" {
  default     = "ai-ghhackathon-ops"
}
 
 

variable "sql_server_name" {
  description = "The name of the SQL Server"
  default     = "sqlsrv-hackathon-ops"
}

variable "sql_version" {
  description = "The version of the SQL Server"
  default     = "12.0"
}

variable "administrator_login" {
  description = "The login for the SQL Server administrator"
  default     = "4dm1n157r470r"
}

variable "administrator_login_password" {
  description = "The password for the SQL Server administrator"
  default     = "4-v3ry-53cr37-p455w0rd"
}

variable "sql_database_name" {
  description = "The name of the SQL Database"
  default     = "sqldb-hackathon-ops"
}

