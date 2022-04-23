package com.fullexample.all.services;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fullexample.all.Dao.EmployeeDAO;
import com.fullexample.all.Model.Employees;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//@ExtendWith(SpringRunner. class)
class EmployeeServicesTest {
    List<Employees> l1=new ArrayList<>();
    Employees employees1=new Employees();
    Employees employees2=new Employees();
    @BeforeEach
     void  setup(){
        employees1.setId(1l);
        employees1.setState("mh");
        employees1.setName("Nilam");

        employees2.setState("up");
        employees2.setName("Rashmi");
        employees2.setId(2l);
        l1.add(employees1);
        l1.add(employees2);
    }
    @MockBean
    EmployeeDAO employeedao;
    @Autowired
    EmployeeServices employeeServices;
    @Test
    void fetchAllEmployeeFromList() {
        Mockito.when(employeeServices.getEmployeesAllList()).thenReturn(l1);
        List<Employees> emp=employeeServices.getEmployeesAllList();
        assertEquals("Nilam",emp.get(0).getName());
    }
    @Test
    void whenValidIdEnterThenReturnEmployee() {
        System.out.println(employees1);
        Mockito.when(employeeServices.getElementByIdService("1")).thenReturn(employees1);
        Employees emp=employeeServices.getElementByIdService("1");
        System.out.println(emp);
        assertEquals(2,emp.getId());
    }
}