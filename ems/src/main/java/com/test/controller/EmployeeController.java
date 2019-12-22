/**
 * 
 */
package com.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.auth.repository.RoleRepository;
import com.test.auth.repository.UserRepository;
import com.test.entity.Employee;
import com.test.entity.Role;
import com.test.entity.User;
import com.test.repository.EmployeeRepository;
import com.test.service.EmployeeService;

/**
 * @author Kabir
 *
 */
@Controller
public class EmployeeController {
	
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Value("${static.msg}")
	private String msg;
	
	
	@RequestMapping(value="/homePage",method = RequestMethod.GET)
	String homePage(Model model, Authentication authentication) {
		logger.debug("UserName:"+authentication.getName());
		Role userRole = roleRepository.findRoleByUserName(authentication.getName());
		logger.debug("User role:"+userRole.getName());
		if(authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ADMIN"))){
			return "redirect:/adminHome";
		}else{
			return "redirect:/userHome";
		}
		
	}
	
	@RequestMapping(value="/adminHome")
	public String adminHome(Model model) {
		List<Employee> list = employeeService.getAllEmployeeData();
		logger.debug("list size:"+list.size());
		model.addAttribute("list",list);
		return "adminHome";
	}
	
	@RequestMapping(value="/userHome")
	String userHome(Model model, Authentication auth) {
		logger.debug("Inside userHome");
		User user = userRepository.findByUsername(auth.getName());
		Employee employee = employeeRepository.findTop1ByUserId(user.getId());
		//model.addAttribute("msg","Welcome "+auth.getName());
		model.addAttribute("msg",msg);
		model.addAttribute("employee", employee);
		return "userHome";
	}
	
	@RequestMapping(value="/registerEmployee", method = RequestMethod.POST)
	@ResponseBody
	boolean registerEmployee(@RequestBody Employee employee, Authentication auth) {
		logger.debug("Inside add employee");
		User user = userRepository.findByUsername(auth.getName());
		employee.setUserId(user.getId());
		boolean res = employeeService.saveEmployee(employee);
		logger.debug("EmployeeData saved:"+res);
		return res;
	}
	
	//For delete
	
	@RequestMapping(value="/deleteEmpData")
	@ResponseBody
	String deleteEmployeeData(@RequestBody Employee employee){
		System.out.println("EmpId:"+employee.getId());
		String res = employeeService.deleteEmployeeData(employee);
		System.out.println("Res:"+res);
		return res;
	}
	
	@RequestMapping(value="/editEmployeeData")
	@ResponseBody
	String updateEmployeeData(@RequestBody Employee employee){
		System.out.println("EmpId:"+employee.getId());
		String res = employeeService.updateEmployee(employee);
		System.out.println("Res:"+res);
		return res;
	}
	
}
