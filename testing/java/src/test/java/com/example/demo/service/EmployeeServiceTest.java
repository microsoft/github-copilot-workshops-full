package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    private Employee employee;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        employee = new Employee();
        employee.setId(1L);
        employee.setName("John Doe");
        employee.setEmail("john.doe@example.com");
    }

    @Test
    public void testGetAllEmployees() {
        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setName("Jane Doe");
        employee2.setEmail("jane.doe@example.com");

        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee, employee2));

        List<Employee> employees = employeeService.getAllEmployees();
        assertThat(employees).hasSize(2).extracting(Employee::getName).contains(employee.getName(),
                employee2.getName());
    }

    @Test
    public void testGetEmployeeById() {
        when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));

        Employee foundEmployee = employeeService.getEmployeeById(employee.getId());
        assertThat(foundEmployee).isNotNull();
        assertThat(foundEmployee.getName()).isEqualTo(employee.getName());
    }

    @Test
    public void testSaveEmployee() {
        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee savedEmployee = employeeService.saveEmployee(employee);
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isEqualTo(employee.getId());
    }

    @Test
    public void testDeleteEmployee() {
        doNothing().when(employeeRepository).deleteById(employee.getId());

        employeeService.deleteEmployee(employee.getId());
        verify(employeeRepository, times(1)).deleteById(employee.getId());
    }

    @Test
    public void testFindEmployeeByEmail() {
        when(employeeRepository.findByEmail(employee.getEmail())).thenReturn(Optional.of(employee));

        Employee foundEmployee = employeeService.findEmployeeByEmail(employee.getEmail());
        assertThat(foundEmployee).isNotNull();
        assertThat(foundEmployee.getEmail()).isEqualTo(employee.getEmail());
    }
}