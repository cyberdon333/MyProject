package com.fullexample.all.Dao;

import com.fullexample.all.Model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO extends JpaRepository<Employees,Long> {
}
