package com.example.demo.dao;

import com.example.demo.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDAOTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllEmployees() {
        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> list = dao.getAllEmployees();
        assertEquals(4,list.size());
    }

    @Test
    void getEmployee() {
    }

    @Test
    void addEmployee() {
    }

    @Test
    void getEmpEmailMap() {
    }

    @Test
    void getEmpWithHighestSalary() {
    }
}