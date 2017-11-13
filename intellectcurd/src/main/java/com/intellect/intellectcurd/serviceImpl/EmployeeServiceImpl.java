package com.intellect.intellectcurd.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intellect.intellectcurd.model.Employee;
import com.intellect.intellectcurd.model.ResponseObj;
import com.intellect.intellectcurd.repo.EmployeeRepo;
import com.intellect.intellectcurd.service.EmployeeService;
import com.intellect.intellectcurd.util.IntellectConstants;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo empRepo;
	
	@Override
	public ResponseObj addEmployee(Employee emp) {
		ResponseObj resObj = new ResponseObj();
		boolean empExist = false;
		Employee existEmpObj = null;
		
		System.out.println("name :"+emp.getEmail());
		
		for (Employee employee : empRepo.findAll()) {
			if(employee.getEmail().equals(emp.getEmail())) {
				empExist = true;
				existEmpObj = new Employee();
				existEmpObj = employee;
			}
		}
		if(empExist) {
		//	resObj.setResMsg(IntellectConstants.EMP_EXIST);
			resObj.setResMsg(IntellectConstants.EMP_EXIST);
			resObj.setUserId(existEmpObj.getId().toString());
		} else {
			emp.setActive(true);
			empRepo.save(emp);
			
			resObj.setResMsg(IntellectConstants.INS_SUCCESS);
			resObj.setUserId(emp.getId().toString());
		}
		return resObj;
		
	}

	@Override
	public ResponseObj updEmployee(Employee emp) {
		// TODO Auto-generated method stub
		ResponseObj resObj = new ResponseObj();
		
		Employee employee = empRepo.findOne(emp.getId());
		if(null != employee) {
			employee.setBirthDate(emp.getBirthDate());
			employee.setPinCode(emp.getPinCode());
			
			empRepo.save(employee);
			resObj.setResMsg(IntellectConstants.UPD_SUCCESS);
		} else {
			resObj.setResMsg(IntellectConstants.EMP_NOT_FOUND);
		}
		
		return resObj;
	}

	@Override
	public ResponseObj delEmployee(long id) {
	ResponseObj resObj = new ResponseObj();
		
		Employee employee = empRepo.findOne(id);
		if(null != employee) {
			
			employee.setActive(false);
			
			empRepo.save(employee);
			resObj.setResMsg(IntellectConstants.DEL_SUCCESS);
		} else {
			resObj.setResMsg(IntellectConstants.EMP_NOT_FOUND);
		}
		
		return resObj;
	}

}
