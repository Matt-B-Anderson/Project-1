package com.revature.services;

import java.util.List;

import com.revature.daos.EmployeeDAO;
import com.revature.models.Employee;
import com.revature.models.Story;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO edao = new EmployeeDAO();

	@Override
	public Employee getEmployee(String username, String password) {
		return edao.getEmployee(username, password);
	}

	@Override
	public Employee getEmployee(Integer id) {
		return edao.getById(id);
	}

	@Override
	public Employee updateEmployee(Employee e) {
		edao.uptate(e);
		return edao.getById(e.getId());
	}

	@Override
	public List<Employee> getAllEmployees() {
		return edao.getall();
	}

	public void addEmployeeToStory(Story s) {
		Employee george = getEmployee(5);
		Employee bob = getEmployee(1);
		Employee diane = getEmployee(4);
		Employee jimmy = getEmployee(2);
		Employee karen = getEmployee(3);

		george.setStory3(s);
		bob.setStory3(s);
		diane.setStory3(s);
		jimmy.setStory3(s);
		karen.setStory3(s);

		updateEmployee(george);
		updateEmployee(bob);
		updateEmployee(diane);
		updateEmployee(jimmy);
		updateEmployee(karen);

	}

}
