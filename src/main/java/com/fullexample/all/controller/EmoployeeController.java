package com.fullexample.all.controller;

import com.fullexample.all.Model.Employees;
import com.fullexample.all.services.EmployeeServices;
import com.fullexample.all.services.EmployeeServicesImpl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class EmoployeeController {
     @Autowired
  private  EmployeeServices employeeServices;
    private static final Logger Log = LoggerFactory.getLogger(EmoployeeController.class);
   // @GetMapping("getAllEmployee")
  // @GetMapping(value = "getAllEmployee",produces = "application/xml")
//{ "application/json", "application/xml" }
   @RequestMapping(value = "/employees", method = RequestMethod.GET,
           produces = { "application/json", "application/xml" })
    public ResponseEntity<List<Employees>> getAllEmployees()
    {
        List<Employees> EmployeeList=employeeServices.getEmployeesAllList();
        //ResponseEntity.ok().body(EmployeeList);
        //if()
        return ResponseEntity.ok().body(EmployeeList);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employees> getElementById(@PathVariable("id") String empid)
    {
       Employees emp= employeeServices.getElementByIdService(empid);
       
       return ResponseEntity.ok().body(emp);
    }

    @PostMapping("/employees/add")
    public ResponseEntity<String> addEmployees(@RequestBody Employees employees) {
       Employees savedUser=employeeServices.addEmployeeService(employees);

      //  ResponseEntity.created(URI.create(String.format("/persons/%s" ,employeeServices.addEmployeeService(employees).getName()))).build()
        return ResponseEntity.created(URI.create("/" + savedUser.getId())).body("created");
    }
    @PutMapping("/updateEmployee/{id}")
    public Employees updatingEmployee(@PathVariable String id, @RequestBody Employees employees) {
        employeeServices.updatingEmployeeService(id,employees);
        return employeeServices.updatingEmployeeService(id, employees);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable String id) {
       // employeeServices.deleteEmployeeService(id);
        return employeeServices.deleteEmployeeService(id);
    }









    @RequestMapping(value="/getAllEmployee", produces= MediaType.APPLICATION_XML_VALUE)
    public List<Employees> getAllEmployees1()
    {
        List<Employees> EmployeeList=employeeServices.getEmployeesAllList();
        return EmployeeList;
    }

}
