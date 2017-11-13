package com.intellect.intellectcurd.service;

import com.intellect.intellectcurd.model.Employee;
import com.intellect.intellectcurd.model.ResponseObj;

public interface EmployeeService {
	public ResponseObj addEmployee(Employee emp);

	public ResponseObj updEmployee(Employee emp);

	public ResponseObj delEmployee(long id);
}
