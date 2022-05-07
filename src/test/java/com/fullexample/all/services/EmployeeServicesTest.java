package com.fullexample.all.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fullexample.all.Dao.EmployeeDAO;
import com.fullexample.all.Model.Employees;
//@SpringBootTest
@ExtendWith(MockitoExtension. class)
//@ExtendWith(SpringRunner. class)
//@WebMvcTest
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
    //@InjectMocks
    EmployeeDAO employeedao;
    @Autowired
    EmployeeServices employeeServices;
    @Test
    @DisplayName("Selecting List of all Employees")
    void fetchAllEmployeeFromList() {
    	List<Employees> emp= (List<Employees>) Mockito.when(employeeServices.getEmployeesAllList()).thenReturn(l1);
       // List<Employees> emp=employeeServices.getEmployeesAllList();
        assertEquals("Nilam",emp.get(0).getName());
    }
    @Test
    @DisplayName("Selecting Employee by id")
    void whenValidIdEnterThenReturnEmployee() {
        System.out.println(employees1);
        Employees emp= (Employees) Mockito.when(employeeServices.getElementByIdService("1")).thenReturn(employees1);
        //Employees emp=employeeServices.getElementByIdService("1");
        //System.out.println(emp);
        assertEquals(1,emp.getId());
    }
}