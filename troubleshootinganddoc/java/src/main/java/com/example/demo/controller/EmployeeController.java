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