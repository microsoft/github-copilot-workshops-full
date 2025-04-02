package com.demo.refactor.service;

import com.demo.refactor.model.Employee;
import com.demo.refactor.repository.EmployeeRepository;
import com.demo.refactor.exception.EmployeeNotFoundException;
import com.demo.refactor.exception.InvalidEmployeeDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private static final Map<String, String> EMPLOYEE_ROLES = Map.of(
            "Paco", "admin",
            "Monica", "developer",
            "Luis", "manager",
            "Ana", "tester",
            "Javier", "designer",
            "Laura", "analyst",
            "David", "support",
            "Sara", "intern",
            "Carlos", "consultant"
    );

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));
    }

    public Employee findEmployeeByEmail(String email) {
        Employee employee = employeeRepository.findByEmail(email);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with email " + email + " not found");
        }
        return employee;
    }

    public Employee saveEmployee(Employee employee) {
        validateEmployeeData(employee);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        validateEmployeeData(employee);
        return employeeRepository.findById(id)
                .map(existingEmployee -> updateExistingEmployee(existingEmployee, employee))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));
    }

    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
        employeeRepository.deleteById(id);
    }

    private Employee updateExistingEmployee(Employee existingEmployee, Employee newEmployeeData) {
        existingEmployee.setName(newEmployeeData.getName());
        existingEmployee.setSurname(newEmployeeData.getSurname());
        existingEmployee.setEmail(newEmployeeData.getEmail());
        existingEmployee.setSalary(newEmployeeData.getSalary());
        return employeeRepository.save(existingEmployee);
    }

    private void validateEmployeeData(Employee employee) {
        if (employee.getName() == null || employee.getName().isEmpty()) {
            throw new InvalidEmployeeDataException("Employee name cannot be null or empty");
        }
        if (employee.getEmail() == null || employee.getEmail().isEmpty()) {
            throw new InvalidEmployeeDataException("Employee email cannot be null or empty");
        }
        if (employee.getSalary() == null || employee.getSalary() <= 0) {
            throw new InvalidEmployeeDataException("Employee salary must be greater than 0");
        }
    }

    public String getRole(String empName) {
        return EMPLOYEE_ROLES.getOrDefault(empName, "unknown");
    }
}