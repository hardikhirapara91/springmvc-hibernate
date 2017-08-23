package com.hardik.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hardik.spring.model.Employee;
import com.hardik.spring.service.EmployeeService;

/**
 * Employee Controller
 * 
 * @author HARDIK HIRAPARA
 *
 */
@Controller
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * Show Employees View
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String showEmployees(ModelMap model) {
		model.addAttribute("employees", employeeService.getAll());
		return "employees";
	}

	/**
	 * Show add new employee form
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String showAddNewEmployeeForm(ModelMap model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("edit", false);
		return "registration";
	}

	/**
	 * Show add new employee form
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/registration" }, method = RequestMethod.POST)
	public String addNewEmployeeForm(Employee employee, ModelMap model) {
		employeeService.save(employee);
		return "success";
	}
}
