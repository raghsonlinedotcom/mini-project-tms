package com.tutorials.tms.dao;

import com.tutorials.tms.bo.EmployeeBO;

public interface EmployeeDAO {
	
	public abstract int createEmployee(EmployeeBO employeeBO) throws Exception;
	
	public abstract int getCount() throws Exception;
	
	public abstract EmployeeBO getEmployeeByEmpId(int empId) throws Exception;
	
	public abstract EmployeeBO verifyEmployee(int empId, String password) throws Exception;
	
	public abstract int updateEmployee(EmployeeBO employeeBO) throws Exception;
}