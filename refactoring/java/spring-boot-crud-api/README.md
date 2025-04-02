# Java Project CRUD API Documentation

## Overview

This project is a Spring Boot application that provides a RESTful API for managing employee records. It includes operations for listing, adding, updating, and deleting employee information.

## Project Structure

```
spring-boot-crud-api
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── demo
│   │   │           └── refactor
│   │   │               ├── SpringBootCrudApiApplication.java
│   │   │               ├── controller
│   │   │               │   └── EmployeeController.java
│   │   │               ├── model
│   │   │               │   └── Employee.java
│   │   │               ├── repository
│   │   │               │   └── EmployeeRepository.java
│   │   │               └── service
│   │   │                   └── EmployeeService.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── data.sql
│   └── test
│       └── java
│           └── com
│               └── demo
│                   └── refactor
│                       └── SpringBootCrudApiApplicationTests.java
├── pom.xml
└── README.md
```

## Setup Instructions

1. **Clone the repository:**
   ```
   git clone <repository-url>
   cd spring-boot-crud-api
   ```

2. **Build the project:**
   ```
   mvn clean install
   ```

3. **Run the application:**
   ```
   mvn spring-boot:run
   ```

4. **Access the API:**
   The application will be running at `http://localhost:8080`.

## API Endpoints

### Get All Employees

- **URL:** `/api/employees`
- **Method:** `GET`
- **Description:** Retrieves a list of all employees.

### Get Employee by ID

- **URL:** `/api/employees/{id}`
- **Method:** `GET`
- **Description:** Retrieves an employee by their ID.

### Create a New Employee

- **URL:** `/api/employees`
- **Method:** `POST`
- **Description:** Creates a new employee.

### Update an Existing Employee

- **URL:** `/api/employees/{id}`
- **Method:** `PUT`
- **Description:** Updates an existing employee.

### Delete an Employee

- **URL:** `/api/employees/{id}`
- **Method:** `DELETE`
- **Description:** Deletes an employee by their ID.

## Models

### Employee

The `Employee` model represents an employee in the system with fields for ID, name, surname, and email.

## Services

### EmployeeService

The `EmployeeService` class provides methods for managing employees.

## Controllers

### EmployeeController

The `EmployeeController` class handles HTTP requests for managing employees.

## License

This project is licensed under the Apache License, Version 2.0. See the LICENSE file for more details.