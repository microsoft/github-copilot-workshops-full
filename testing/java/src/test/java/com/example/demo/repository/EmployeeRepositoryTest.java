package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    public void setUp() {
        employee = new Employee();
        employee.setName("John Doe");
        employee.setEmail("john.doe@example.com");
    }

    @Test
    public void testSaveEmployee() {
        Employee savedEmployee = employeeRepository.save(employee);
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isNotNull();
    }

    @Test
    public void testFindEmployeeById() {
        Employee savedEmployee = entityManager.persistAndFlush(employee);
        Optional<Employee> foundEmployee = employeeRepository.findById(savedEmployee.getId());
        assertThat(foundEmployee).isPresent();
        assertThat(foundEmployee.get().getName()).isEqualTo(savedEmployee.getName());
    }

    @Test
    public void testFindAllEmployees() {
        Employee savedEmployee1 = entityManager.persistAndFlush(employee);
        Employee employee2 = new Employee();
        employee2.setName("Jane Doe");
        employee2.setEmail("jane.doe@example.com");
        Employee savedEmployee2 = entityManager.persistAndFlush(employee2);

        List<Employee> employees = employeeRepository.findAll();
        assertThat(employees).hasSize(2).extracting(Employee::getName).contains(savedEmployee1.getName(),
                savedEmployee2.getName());
    }

    @Test
    public void testDeleteEmployee() {
        Employee savedEmployee = entityManager.persistAndFlush(employee);
        employeeRepository.deleteById(savedEmployee.getId());
        Optional<Employee> deletedEmployee = employeeRepository.findById(savedEmployee.getId());
        assertThat(deletedEmployee).isNotPresent();
    }

    @Test
    public void testFindEmployeeByEmail() {
        Employee savedEmployee = entityManager.persistAndFlush(employee);
        Optional<Employee> foundEmployee = employeeRepository.findByEmail(savedEmployee.getEmail());
        assertThat(foundEmployee).isPresent();
        assertThat(foundEmployee.get().getEmail()).isEqualTo(savedEmployee.getEmail());
    }
}