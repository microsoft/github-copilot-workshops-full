# Java Project Functional Documentation

## Overview

This project is a Spring Boot application that provides a RESTful API for managing employee records. It includes operations for listing, adding, updating, and deleting employee information.

## API Endpoints

### Get All Employees

- **URL:** `/api/employees`
- **Method:** `GET`
- **Description:** Retrieves a list of all employees.
- **Response:**
  - **Status:** `200 OK`
  - **Body:** A JSON array of employee objects.

#### Example Request

```sh
curl -X GET http://localhost:8080/api/employees
```

#### Example Response

```json
[
  {
    "id": 1,
    "name": "John",
    "surname": "Doe",
    "email": "john.doe@example.com"
  },
  {
    "id": 2,
    "name": "Jane",
    "surname": "Doe",
    "email": "jane.doe@example.com"
  }
]
```

### Get Employee by ID

- **URL:** `/api/employees/{id}`
- **Method:** `GET`
- **Description:** Retrieves an employee by their ID.
- **Path Parameters:**
  - `id` (Long): The ID of the employee.
- **Response:**
  - **Status:** `200 OK`
  - **Body:** A JSON object representing the employee.

#### Example Request

```sh
curl -X GET http://localhost:8080/api/employees/1
```

#### Example Response

```json
{
  "id": 1,
  "name": "John",
  "surname": "Doe",
  "email": "john.doe@example.com"
}
```

### Get Employee by Email

- **URL:** `/api/employees/email/{email}`
- **Method:** `GET`
- **Description:** Retrieves an employee by their email.
- **Path Parameters:**
  - `email` (String): The email of the employee.
- **Response:**
  - **Status:** `200 OK`
  - **Body:** A JSON object representing the employee.

#### Example Request

```sh
curl -X GET http://localhost:8080/api/employees/email/john.doe@example.com
```

#### Example Response

```json
{
  "id": 1,
  "name": "John",
  "surname": "Doe",
  "email": "john.doe@example.com"
}
```

### Create a New Employee

- **URL:** `/api/employees`
- **Method:** `POST`
- **Description:** Creates a new employee.
- **Request Body:**
  - A JSON object representing the employee to be created.
- **Response:**
  - **Status:** `201 Created`
  - **Body:** A JSON object representing the created employee.

#### Example Request

```sh
curl -X POST http://localhost:8080/api/employees -H "Content-Type: application/json" -d '{
  "name": "John",
  "surname": "Doe",
  "email": "john.doe@example.com"
}'
```

#### Example Response

```json
{
  "id": 1,
  "name": "John",
  "surname": "Doe",
  "email": "john.doe@example.com"
}
```

### Update an Existing Employee

- **URL:** `/api/employees/{id}`
- **Method:** `PUT`
- **Description:** Updates an existing employee.
- **Path Parameters:**
  - `id` (Long): The ID of the employee to be updated.
- **Request Body:**
  - A JSON object representing the updated employee data.
- **Response:**
  - **Status:** `200 OK`
  - **Body:** A JSON object representing the updated employee.

#### Example Request

```sh
curl -X PUT http://localhost:8080/api/employees/1 -H "Content-Type: application/json" -d '{
  "name": "Jane",
  "surname": "Doe",
  "email": "jane.doe@example.com"
}'
```

#### Example Response

```json
{
  "id": 1,
  "name": "Jane",
  "surname": "Doe",
  "email": "jane.doe@example.com"
}
```

### Delete an Employee

- **URL:** `/api/employees/{id}`
- **Method:** `DELETE`
- **Description:** Deletes an employee by their ID.
- **Path Parameters:**
  - `id` (Long): The ID of the employee to be deleted.
- **Response:**
  - **Status:** `204 No Content`

#### Example Request

```sh
curl -X DELETE http://localhost:8080/api/employees/1
```

## Models

### Employee

The `Employee` model represents an employee in the system.

#### Fields

- `id` (Long): The unique identifier of the employee.
- `name` (String): The name of the employee.
- `surname` (String): The surname of the employee.
- `email` (String): The email of the employee.

#### Example

```json
{
  "id": 1,
  "name": "John",
  "surname": "Doe",
  "email": "john.doe@example.com"
}
```

## Services

### EmployeeService

The `EmployeeService` class provides methods for managing employees.

#### Methods

- `List<Employee> getAllEmployees()`: Retrieves all employees.
- `Employee getEmployeeById(Long id)`: Retrieves an employee by their ID.
- `Employee saveEmployee(Employee employee)`: Saves an employee.
- `void deleteEmployee(Long id)`: Deletes an employee by their ID.
- `Employee findEmployeeByEmail(String email)`: Finds an employee by their email.

## Controllers

### EmployeeController

The `EmployeeController` class handles HTTP requests for managing employees.

#### Endpoints

- `GET /api/employees`: Retrieves all employees.
- `GET /api/employees/{id}`: Retrieves an employee by their ID.
- `GET /api/employees/email/{email}`: Retrieves an employee by their email.
- `POST /api/employees`: Creates a new employee.
- `PUT /api/employees/{id}`: Updates an existing employee.
- `DELETE /api/employees/{id}`: Deletes an employee by their ID.

## Logging

The application uses SLF4J for logging. Each controller method logs the entry and exit points, including relevant data.

## License

This project is licensed under the Apache License, Version 2.0. See the [LICENSE](LICENSE) file for more details.