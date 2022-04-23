package com.fullexample.all.services;

import com.fullexample.all.Model.Employees;

import java.util.List;


public interface EmployeeServices  {
  
    

    public Employees getElementByIdService(String id);
    public List<Employees> getEmployeesAllList();//test

   public  Employees addEmployeeService(Employees employees);

    Employees updatingEmployeeService(String id,Employees employees);

    String deleteEmployeeService(String id);
}
