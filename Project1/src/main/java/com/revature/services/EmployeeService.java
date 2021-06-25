package com.revature.services;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Story;

public interface EmployeeService {

	public Employee getEmployee(String username, String password);

	public Employee getEmployee(Integer id);

	public Employee updateEmployee(Employee e);

	public List<Employee> getAllEmployees();

	public void addEmployeeToStory(Story addedStory);
}
