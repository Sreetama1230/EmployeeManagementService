package com.internal.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internal.employee.dao.EmployeeRepository;
import com.internal.employee.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee create(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee update(Long id, Employee employee) {
		Optional<Employee> dbEmp = employeeRepository.findById(id);
		if (dbEmp.isPresent()) {
			Employee emp = dbEmp.get();
			emp.setDesignation(employee.getDesignation());
			emp.setName(employee.getName());

			return employeeRepository.save(emp);
		}

		return new Employee();
	}

	public Employee getById(Long id) {
		Optional<Employee> epEmp = employeeRepository.findById(id);
		if (epEmp.isPresent()) {
			return employeeRepository.findById(id).get();
		}

		return new Employee();
	}

	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	public void delete(Long id) {
		Optional<Employee> epEmp = employeeRepository.findById(id);
		if (epEmp.isPresent()) {
			 employeeRepository.deleteById(id);
		}
	}
}
