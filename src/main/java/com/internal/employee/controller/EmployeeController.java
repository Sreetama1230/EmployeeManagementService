package com.internal.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internal.employee.model.Employee;
import com.internal.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public Employee create(@RequestBody Employee employee) {
		return employeeService.create(employee);
	}

	@PutMapping("/{id}")
	public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
		return employeeService.update(id, employee);
	}

	@GetMapping("/{id}")
	public Employee getById(@PathVariable Long id) {
		return employeeService.getById(id);
	}

	@GetMapping()
	public List<Employee> getAll() {
		return employeeService.getAll();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		employeeService.delete(id);
	}
}
