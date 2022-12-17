package com.tutorials.tms.dao;

import com.tutorials.tms.bo.Employee;

public interface EmployeeDAO {
	
	public abstract int createEmployee(Employee employee) throws Exception;
	
	public abstract int getCount() throws Exception;
}