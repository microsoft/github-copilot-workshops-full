# Java Project Technical Documentation

## Project Overview

This project is a Spring Boot application that provides a RESTful API for managing employee records. It includes operations for listing, adding, updating, and deleting employee information.

## Project Structure

```
java/
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
├── .github/
├── .mvn/
├── jmeter/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── demo/
│   │   │               ├── controller/
│   │   │               │   └── EmployeeController.java
│   │   │               ├── model/
│   │   │               │   └── Employee.java
│   │   │               ├── service/
│   │   │               │   └── EmployeeService.java
│   │   │               └── DemoApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── demo/
│                       └── DemoApplicationTests.java
└── target/
```

## Dependencies

The project uses the following dependencies:

- Spring Boot Starter Actuator
- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- H2 Database
- Spring Boot Starter Test
- Jacoco Maven Plugin

## Configuration

### `application.properties`

```properties
spring.application.name=demo
```

## Source Code

### `DemoApplication.java`

```java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    /**
     * The main method which serves as the entry point for the Spring Boot
     * application.
     * 
     * @param args command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
```

### `Employee.java`

```java
package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;

    // Constructors
    public Employee() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
```

### `EmployeeService.java`

```java
package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee findEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email).orElse(null);
    }
}
```

### `EmployeeController.java`

```java
package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        logger.info("Entrada: GET /api/employees");
        List<Employee> employees = employeeService.getAllEmployees();
        logger.info("Salida: {}", employees);
        return employees;
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        logger.info("Entrada: GET /api/employees/{}", id);
        Employee employee = employeeService.getEmployeeById(id);
        logger.info("Salida: {}", employee);
        return employee;
    }

    // Get employee by email
    @GetMapping("/email/{email}")
    public Employee getEmployeeByEmail(@PathVariable String email) {
        logger.info("Entrada: GET /api/employees/email/{}", email);
        Employee employee = employeeService.findEmployeeByEmail(email);
        logger.info("Salida: {}", employee);
        return employee;
    }

    // Create a new employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        logger.info("Entrada: POST /api/employees");
        Employee createdEmployee = employeeService.saveEmployee(employee);
        logger.info("Salida: {}", createdEmployee);
        return createdEmployee;
    }

    // Update an existing employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        logger.info("Entrada: PUT /api/employees/{}", id);
        Employee existingEmployee = employeeService.getEmployeeById(id);
        if (existingEmployee != null) {
            existingEmployee.setName(employee.getName());
            existingEmployee.setSurname(employee.getSurname());
            existingEmployee.setEmail(employee.getEmail());
            Employee updatedEmployee = employeeService.saveEmployee(existingEmployee);
            logger.info("Salida: {}", updatedEmployee);
            return updatedEmployee;
        }
        logger.info("Salida: null");
        return null;
    }

    // Delete an employee
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        logger.info("Entrada: DELETE /api/employees/{}", id);
        employeeService.deleteEmployee(id);
        logger.info("Salida: void");
    }
}
```

### `DemoApplicationTests.java`

```java
package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

}
```

## Build and Run

To build and run the project, use the following commands:

```sh
./mvnw clean install
./mvnw spring-boot:run
```

## API Endpoints

- **Get All Employees**
  ```sh
  curl -X GET http://localhost:8080/api/employees
  ```

- **Get Employee by ID**
  ```sh
  curl -X GET http://localhost:8080/api/employees/{id}
  ```

- **Get Employee by Email**
  ```sh
  curl -X GET http://localhost:8080/api/employees/email/{email}
  ```

- **Create a New Employee**
  ```sh
  curl -X POST http://localhost:8080/api/employees -H "Content-Type: application/json" -d '{
    "name": "John",
    "surname": "Doe",
    "email": "john.doe@example.com"
  }'
  ```

- **Update an Existing Employee**
  ```sh
  curl -X PUT http://localhost:8080/api/employees/{id} -H "Content-Type: application/json" -d '{
    "name": "Jane",
    "surname": "Doe",
    "email": "jane.doe@example.com"
  }'
  ```

- **Delete an Employee**
  ```sh
  curl -X DELETE http://localhost:8080/api/employees/{id}
  ```

## License

This project is licensed under the Apache License, Version 2.0. See the [LICENSE](LICENSE) file for more details.