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

    /**
     * Gets the ID of the employee.
     * 
     * @return the ID of the employee.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the employee.
     * 
     * @param id the ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the employee.
     * 
     * @return the name of the employee.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the employee.
     * 
     * @param name the name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the surname of the employee.
     * 
     * @return the surname of the employee.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the surname of the employee.
     * 
     * @param surname the surname to set.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets the email of the employee.
     * 
     * @return the email of the employee.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the employee.
     * 
     * @param email the email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}