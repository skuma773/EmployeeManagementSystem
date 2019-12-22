package com.test.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Employee;
import com.test.repository.EmployeeRepository;
import com.test.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public boolean saveEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		if(emp.getId() > 0) {
			return true;
		}else
			return false;
	}

	@Override
	public List<Employee> getAllEmployeeData() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public String deleteEmployeeData(Employee employee) {
		String msg="";
		try{
			employeeRepository.deleteById(employee.getId());
			msg = "success";
		}catch (Exception e) {
			// TODO: handle exception
			msg = "fail";
		}
		return msg;
	}

	@Override
	public String updateEmployee(Employee employee) {
		String msg="";
		try{
			Employee savedEmployee = employeeRepository.save(employee);
			if(savedEmployee.getId() > 0){
				msg = "success";
			}else{
				msg = "fail";
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			msg = "fail";
		}
		return msg;
	}

}
