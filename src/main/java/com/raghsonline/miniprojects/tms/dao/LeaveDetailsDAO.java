package com.raghsonline.miniprojects.tms.dao;

import java.util.List;

import com.raghsonline.miniprojects.tms.bo.LeaveDetailsBO;

public interface LeaveDetailsDAO {
	
	public abstract List<LeaveDetailsBO> viewMyTeamsLeave(int managerId) throws Exception;
	
	public abstract LeaveDetailsBO viewLeaveDetailsById(int id) throws Exception;
	
	public abstract List<LeaveDetailsBO> myLeaveDetails(int empId) throws Exception;

}
