package com.intellect.intellectcurd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intellect.intellectcurd.model.Employee;
import com.intellect.intellectcurd.model.ResponseObj;
import com.intellect.intellectcurd.service.EmployeeService;

@RestController
public class EmployeeController {
		
	@Autowired
	private EmployeeService empService;
	
	/**
	 * Add Employee
	 * 
	 */
	
	@RequestMapping(value="/add-employee",method = RequestMethod.POST)
	public ResponseObj addEmployee(@RequestBody Employee emp) {
		System.out.println("add-employee");
		ResponseObj responseObj= null;
		try {
			responseObj = empService.addEmployee(emp);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return responseObj;		
	}
	
	@RequestMapping(value="/upd-employee",method = RequestMethod.GET)
	public ResponseObj updEmployee(@RequestParam("userId")long id,
			@RequestParam("birthDate")String birthDate,
			@RequestParam("pinCode")long pinCode) {
		System.out.println("upd-employee");
		ResponseObj responseObj= null;
		try {
			Employee emp = new Employee();
			emp.setId(id);
			emp.setBirthDate(birthDate);
			emp.setPinCode(pinCode);
			responseObj = empService.updEmployee(emp);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return responseObj;		
	}
	
	@RequestMapping(value="/del-employee",method = RequestMethod.GET)
	public ResponseObj delEmployee(@RequestParam("userId")long id) {
		System.out.println("del-employee");
		ResponseObj responseObj= null;
		try {
			
			responseObj = empService.delEmployee(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return responseObj;		
	}
}
