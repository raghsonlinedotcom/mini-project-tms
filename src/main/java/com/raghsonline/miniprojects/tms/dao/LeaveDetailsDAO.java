package com.raghsonline.miniprojects.tms.dao;

import java.util.List;

import com.raghsonline.miniprojects.tms.bo.LeaveDetailBO;

public interface LeaveDetailsDAO {
	
	public abstract List<LeaveDetailBO> getTeamLeaveDetails(int managerId) throws Exception;
	
	public abstract LeaveDetailBO getLeaveDetailsById(int id) throws Exception;
	
	public abstract List<LeaveDetailBO> getLeaveDetails(int empId) throws Exception;

}
