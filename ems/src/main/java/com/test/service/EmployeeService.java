/**
 * 
 */
package com.test.service;

import java.util.List;

import com.test.entity.Employee;

/**
 * @author Kabir
 *
 */
public interface EmployeeService {
	
	public boolean saveEmployee(Employee employee);

	List<Employee> getAllEmployeeData();
	
	String deleteEmployeeData(Employee employee);
	
	public String updateEmployee(Employee employee);
}
