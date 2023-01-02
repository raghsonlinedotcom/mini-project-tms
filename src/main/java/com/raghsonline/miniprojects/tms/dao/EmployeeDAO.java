package com.raghsonline.miniprojects.tms.dao;

import java.util.List;

import com.raghsonline.miniprojects.tms.bo.EmployeeBO;

public interface EmployeeDAO {
	
	public abstract int createEmployee(EmployeeBO employeeBO) throws Exception;
	
	public abstract int getCount() throws Exception;
	
	public abstract EmployeeBO getEmployeeByEmpId(int empId) throws Exception;
	
	public abstract EmployeeBO verifyEmployee(int empId, String password) throws Exception;
	
	public abstract int updateEmployee(EmployeeBO employeeBO) throws Exception;
	
	public abstract List<EmployeeBO> viewAll() throws Exception;
	
	public abstract List<EmployeeBO> viewManagers() throws Exception;
}