package com.capgemini.springmvc.dao;

import java.util.List;

import com.capgemini.springmvc.beans.EmplooyeeInfoBean;

public interface EmployeeDAO {

	public EmplooyeeInfoBean getEmployee(int empId);
	public boolean addEmployee(EmplooyeeInfoBean emplooyeeInfoBean);
	public boolean deleteEmployee(int empId);
	public boolean updateEmployee(EmplooyeeInfoBean emplooyeeInfoBean);
	public List<EmplooyeeInfoBean> getAllEmployees();
	
	
	
}
