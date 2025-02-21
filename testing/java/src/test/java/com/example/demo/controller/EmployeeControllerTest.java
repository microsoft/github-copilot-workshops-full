package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmployeeService employeeService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testGetAllEmployees() throws Exception {
        Employee emp1 = new Employee();
        emp1.setId(1L);
        emp1.setName("John");
        emp1.setSurname("Doe");
        emp1.setEmail("john.doe@example.com");

        Employee emp2 = new Employee();
        emp2.setId(2L);
        emp2.setName("Jane");
        emp2.setSurname("Smith");
        emp2.setEmail("jane.smith@example.com");

        List<Employee> employees = Arrays.asList(emp1, emp2);
        when(employeeService.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(get("/api/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[1].name").value("Jane"));
    }

    @Test
    public void testGetEmployeeById() throws Exception {
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("John");
        emp.setSurname("Doe");
        emp.setEmail("john.doe@example.com");

        when(employeeService.getEmployeeById(1L)).thenReturn(emp);

        mockMvc.perform(get("/api/employees/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.surname").value("Doe"));
    }

    @Test
    public void testCreateEmployee() throws Exception {
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("John");
        emp.setSurname("Doe");
        emp.setEmail("john.doe@example.com");

        when(employeeService.saveEmployee(any(Employee.class))).thenReturn(emp);

        mockMvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(emp)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.surname").value("Doe"));
    }

    @Test
    public void testUpdateEmployee_Success() throws Exception {
        Employee existingEmp = new Employee();
        existingEmp.setId(1L);
        existingEmp.setName("John");
        existingEmp.setSurname("Doe");
        existingEmp.setEmail("john.doe@example.com");

        Employee updateRequest = new Employee();
        updateRequest.setName("Johnny");
        updateRequest.setSurname("Doe");
        updateRequest.setEmail("johnny.doe@example.com");

        Employee updatedEmp = new Employee();
        updatedEmp.setId(1L);
        updatedEmp.setName("Johnny");
        updatedEmp.setSurname("Doe");
        updatedEmp.setEmail("johnny.doe@example.com");

        when(employeeService.getEmployeeById(1L)).thenReturn(existingEmp);
        when(employeeService.saveEmployee(any(Employee.class))).thenReturn(updatedEmp);

        mockMvc.perform(put("/api/employees/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updateRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Johnny"))
                .andExpect(jsonPath("$.email").value("johnny.doe@example.com"));
    }

    @Test
    public void testUpdateEmployee_NotFound() throws Exception {
        Employee updateRequest = new Employee();
        updateRequest.setName("Johnny");
        updateRequest.setSurname("Doe");
        updateRequest.setEmail("johnny.doe@example.com");

        when(employeeService.getEmployeeById(1L)).thenReturn(null);

        mockMvc.perform(put("/api/employees/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updateRequest)))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testDeleteEmployee() throws Exception {
        doNothing().when(employeeService).deleteEmployee(1L);

        mockMvc.perform(delete("/api/employees/{id}", 1L))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetEmployeeByEmail() throws Exception {
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("John");
        emp.setSurname("Doe");
        emp.setEmail("john.doe@example.com");

        when(employeeService.findEmployeeByEmail("john.doe@example.com")).thenReturn(emp);

        mockMvc.perform(get("/api/employees/email/{email}", "john.doe@example.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("john.doe@example.com"));
    }
}