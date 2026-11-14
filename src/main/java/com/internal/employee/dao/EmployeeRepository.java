package com.internal.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internal.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
