package com.fullexample.all.services;

import com.fullexample.all.Dao.EmployeeDAO;
import com.fullexample.all.Model.Employees;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServicesImpl implements EmployeeServices{
    @Autowired
    EmployeeDAO empdao;
    private static final Logger Log = LoggerFactory.getLogger(EmployeeServicesImpl.class);


    @Override
    public Employees getElementByIdService(String id) {
        Employees employees=null;
        Optional<Employees> optionalEmployees =empdao.findById(Long.valueOf(id));
        Log.info("inside method of getElementByIdService");
        if(optionalEmployees.isPresent())
            employees=   optionalEmployees.get();
        else {
            Log.info("error to get data");return null;
        }
        return employees;
    }
    @Override
    public List<Employees> getEmployeesAllList() {
       List<Employees> li= empdao.findAll();
        Log.info("inside methof of getEmployeesAllList");
        return li;
    }

    @Override
    public Employees addEmployeeService(Employees employees) {
      Employees e=  empdao.save(employees);
        Log.info("Respose is +"+e);
        Log.info("inside method addEmployeeService creation");
        return e;
    }

    @Override
    public Employees updatingEmployeeService(String id, Employees employees) {
        Employees emp=empdao.getById(Long.valueOf(id));
        emp.setName(employees.getName());
        emp.setState(employees.getState());
        Employees emp2= empdao.save(emp);
        return emp2;
    }

    @Override
    public String deleteEmployeeService(String id) {
        Log.info("Entred in delete functions.");
        empdao.deleteById(Long.valueOf(id));

        return "Deleted";
    }
}
