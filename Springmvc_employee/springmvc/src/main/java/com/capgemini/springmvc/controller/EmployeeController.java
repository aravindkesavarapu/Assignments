package com.capgemini.springmvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.springmvc.beans.EmplooyeeInfoBean;
import com.capgemini.springmvc.service.EmployeeService;
import com.capgemini.springmvc.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {

	EmployeeService service = new EmployeeServiceImpl();
	
	@GetMapping("home")
	public String home() {
		return "home";
	}

	@GetMapping("/getEmployeeForm")
	public String getEmployeeForm() {
		return "searchEmployee";
	}
	@GetMapping("/getEmployee")
	public String getEmployee(int empId,ModelMap map) {
		EmplooyeeInfoBean emplooyeeInfoBean = service.getEmployee(empId);
		if(emplooyeeInfoBean != null) {
			map.addAttribute("employeeInfo", emplooyeeInfoBean);
		}else {
			map.addAttribute("errmsg","Employee Id Not Found");
		}
		
		return "searchEmployee";
	}

	@GetMapping("/addEmployeeForm")
	public String addEmployeeForm() {
		return "addEmployeeForm";
	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(EmplooyeeInfoBean emplooyeeInfoBean,ModelMap map) {
		boolean isAdded = service.addEmployee(emplooyeeInfoBean);
		if(isAdded) {
			map.addAttribute("done","SucessFully added to the table");
		}else {
			map.addAttribute("notDone", "Unscessfull add to the table");
		}
		return "sucess";
	}
	
	@GetMapping("/deleteEmployeeForm")
	public String deleteEmployeeForm() {
		return "deleteEmployeeForm";
	}
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(int empId,ModelMap map) {
		boolean isDeleted = service.deleteEmployee(empId);
		if(isDeleted) {
			map.addAttribute("done", "Successfully Deleted from the table");
		}else {
			map.addAttribute("Not Done", "Not Deleted");
		}
		return "sucess";
				
	}
	
	@GetMapping("/updateEmployeeForm")
	public String updateEmployeeForm() {
		return "updateEmployeeForm";
	}
	
	@PostMapping("/updateEmployee")
	public String updateEmployee(EmplooyeeInfoBean emplooyeeInfoBean,ModelMap map) {
		boolean isUpdated = service.updateEmployee(emplooyeeInfoBean);
		if(isUpdated) {
			map.addAttribute("done", "Successfully Updated from the table");
		}else {
			map.addAttribute("Not Done", "Not Deleted");
		}
		return "sucess";
	}
	
	@GetMapping("/allEmployeeDetails")
	public String allEmployeeDetails(ModelMap map) {
		List<EmplooyeeInfoBean> beanList = service.getAllEmployees();
		if(beanList.size()!=0) {
			map.addAttribute("beanList", beanList);
		}else {
			map.addAttribute("zero", "no employees");
		}
		return "allEmployeeDetails";
	}
	
}
