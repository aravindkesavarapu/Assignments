package com.capgemini.springmvc.service;

import java.util.List;

import com.capgemini.springmvc.beans.EmplooyeeInfoBean;

public interface EmployeeService {

	public EmplooyeeInfoBean getEmployee(int empId);
	public boolean addEmployee(EmplooyeeInfoBean emplooyeeInfoBean);
	public boolean deleteEmployee(int empId);
	public boolean updateEmployee(EmplooyeeInfoBean emplooyeeInfoBean);
	public List<EmplooyeeInfoBean> getAllEmployees();
	
}
