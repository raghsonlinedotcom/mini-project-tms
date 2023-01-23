package com.raghsonline.miniprojects.tms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.raghsonline.miniprojects.tms.bo.LeaveDetailBO;
import com.raghsonline.miniprojects.tms.db.DBConnection;
import com.raghsonline.miniprojects.tms.util.AppUtil;

public class LeaveDetailsDAOImpl implements LeaveDetailsDAO 
{
	Logger logger = Logger.getLogger(LeaveDetailsDAOImpl.class);
	
	@Override
	public List<LeaveDetailBO> getTeamLeaveDetails(int managerId) 
			throws Exception
	{
		logger.info("viewMyTeamsLeave() Invoked");
		
		String sql = "SELECT * FROM LEAVE_DETAILS WHERE MANAGER_ID =?";
		
		logger.info("SQL Query :: "+ sql);
		
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		List<LeaveDetailBO> leaveDetailsList = new ArrayList<>();
		LeaveDetailBO leaveDetailBO = null;
		Connection conn = null;
		
		try 
		{
			conn = DBConnection.getConn();
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, managerId);

			rs = pStmt.executeQuery();
			
			while(rs.next())
			{
				leaveDetailBO = new LeaveDetailBO();
				
				leaveDetailBO.setId(rs.getInt("ID"));
				leaveDetailBO.setEmpId(rs.getInt("EMP_ID"));
				leaveDetailBO.setManagerId(rs.getInt("MANAGER_ID"));
				leaveDetailBO.setFromDate(rs.getTimestamp("FROM_DATE"));
				leaveDetailBO.setToDate(rs.getTimestamp("TO_DATE"));
				leaveDetailBO.setLeaveReason(rs.getString("LEAVE_REASON"));
				leaveDetailBO.setStatus(rs.getString("STATUS"));
				leaveDetailBO.setActionComment(rs.getString("ACTION_COMMENT"));
				leaveDetailBO.setAltContactNo(rs.getString("ALT_CONTACT_NO"));
				leaveDetailBO.setCreatedDate(rs.getTimestamp("CREATED_DATE"));
				leaveDetailBO.setCreatedBy(rs.getInt("CREATED_BY"));
				leaveDetailBO.setUpdatedDate(rs.getTimestamp("UPDATED_DATE"));
				leaveDetailBO.setUpdatedBy(rs.getInt("UPDATED_BY"));
				
				leaveDetailsList.add(leaveDetailBO);	
			}
		} catch (SQLException sqlException) {
			logger.error("SQLException occurred while reading the data from the Database Table");
			logger.error("Message : " + sqlException.getMessage());
			if(AppUtil.isAppDevMode) {
				sqlException.printStackTrace();
			}
		} catch (Exception exception) {
			logger.error("Exception occurred while reading the data from the Database Table");
			logger.error("Message : " + exception.getMessage());
			if(AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
		} finally {
			try {
				if (null != rs)
					rs.close();
				if (null != pStmt)
					pStmt.close();
				if (null != conn)
					conn.close();
			} catch (SQLException sqlException) {
				logger.error("Exception occurred while closing the JDBC Resources");
				logger.error("Message : " + sqlException.getMessage());
				if(AppUtil.isAppDevMode) {
					sqlException.printStackTrace();
				}
			}
		}
		
		logger.info("LeaveDetailsList size : " + leaveDetailsList.size());
		
		return leaveDetailsList;
	}

	@Override
	public LeaveDetailBO getLeaveDetailsById(int id) 
	throws Exception 
	{
		logger.info("viewLeaveDetailsById() invoked - idParam :: " + id);

		String sql = "SELECT * FROM LEAVE_DETAILS WHERE ID=?";

		logger.info("SQL Query :: " + sql);

		PreparedStatement pStmt = null;
		ResultSet rs = null;

		LeaveDetailBO leaveDetailBO = null;
		Connection conn = null;

		try {

			conn = DBConnection.getConn();

			pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, id);

			rs = pStmt.executeQuery();

			while (rs.next()) 
			{ 
				// read one full row's data - one column at a time

				// makes sense to create an object, so that we don't waste the memory allotted
				// to an Object.
				leaveDetailBO = new LeaveDetailBO();

				leaveDetailBO.setId(rs.getInt("ID"));
				leaveDetailBO.setEmpId(rs.getInt("EMP_ID"));
				leaveDetailBO.setManagerId(rs.getInt("MANAGER_ID"));
				leaveDetailBO.setFromDate(rs.getTimestamp("FROM_DATE"));
				leaveDetailBO.setToDate(rs.getTimestamp("TO_DATE"));
				leaveDetailBO.setLeaveReason(rs.getString("LEAVE_REASON"));
				leaveDetailBO.setStatus(rs.getString("STATUS"));
				leaveDetailBO.setActionComment(rs.getString("ACTION_COMMENT"));
				leaveDetailBO.setAltContactNo(rs.getString("ALT_CONTACT_NO"));
				leaveDetailBO.setCreatedDate(rs.getTimestamp("CREATED_DATE"));
				leaveDetailBO.setCreatedBy(rs.getInt("CREATED_BY"));
				leaveDetailBO.setUpdatedDate(rs.getTimestamp("UPDATED_DATE"));
				leaveDetailBO.setUpdatedBy(rs.getInt("UPDATED_BY"));
				
			}
		} catch (SQLException sqlException) {
			logger.error("SQLException occurred while reading the data from the Database Table");
			logger.error("Message : " + sqlException.getMessage());
			if(AppUtil.isAppDevMode) {
				sqlException.printStackTrace();
			}
		} catch (Exception exception) {
			logger.error("Exception occurred while reading the data from the Database Table");
			logger.error("Message : " + exception.getMessage());
			if(AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
		} finally {
			try {
				if (null != rs)
					rs.close();
				if (null != pStmt)
					pStmt.close();
				if (null != conn)
					conn.close();
			} catch (SQLException sqlException) {
				logger.error("Exception occurred while closing the DB Resource(s)");
				logger.error("Message : " + sqlException.getMessage());
				if(AppUtil.isAppDevMode) {
					sqlException.printStackTrace();
				}
			} 
		}

		return leaveDetailBO;

	}
	
	public List<LeaveDetailBO> getLeaveDetails(int idParam) 
	throws Exception 
	{	
		logger.info("LeaveDetailsDAOImpl --- getLeaveDetailsById - idParam ::" + idParam);
		
		String sql ="SELECT * FROM LEAVE_DETAILS WHERE EMP_ID=?";
		
		logger.info("SQL Query :: "+ sql);
		
		ResultSet rs = null;
		List<LeaveDetailBO> leavedetailsBOList = new ArrayList<>();
		LeaveDetailBO leavedetailsBO = null;
		Connection conn = null;
		PreparedStatement pStmt = null;
		
		try 
		{
			conn = DBConnection.getConn();
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, idParam);
			
			rs = pStmt.executeQuery();
			
			while(rs.next())
			{
				leavedetailsBO = new LeaveDetailBO();
				
				leavedetailsBO.setId(rs.getInt("ID"));
				leavedetailsBO.setEmpId(rs.getInt("EMP_ID"));
				leavedetailsBO.setManagerId(rs.getInt("MANAGER_ID"));
				leavedetailsBO.setFromDate(rs.getTimestamp("FROM_DATE"));
				leavedetailsBO.setToDate(rs.getTimestamp("TO_DATE"));
				leavedetailsBO.setLeaveReason(rs.getString("LEAVE_REASON"));
				leavedetailsBO.setStatus(rs.getString("STATUS"));
				leavedetailsBO.setCreatedBy(rs.getInt("CREATED_BY"));
				
				leavedetailsBOList.add(leavedetailsBO);	
			}
		} catch (SQLException sqlException) {
			logger.error("SQLException occurred while Obtaining the data from the Database Table");
			logger.error("Message : " + sqlException.getMessage());
			if(AppUtil.isAppDevMode) {
				sqlException.printStackTrace();
			}
		} catch (Exception exception) {
			logger.error("Exception occurred while Obtaining the data from the Database Table");
			logger.error("Message : " + exception.getMessage());
			if(AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
		} finally {
			try {
				if (null != rs)
					rs.close();
				if (null != pStmt)
					pStmt.close();
				if (null != conn)
					conn.close();
			} catch (SQLException sqlException) {
				logger.error("Exception occurred while closing the JDBC Resources");
				logger.error("Message : " + sqlException.getMessage());
				if(AppUtil.isAppDevMode) {
					sqlException.printStackTrace();
				}
			}
		}
		
		logger.info("LeaveDetailsBOList size : " + leavedetailsBOList.size());
		
		return leavedetailsBOList;
	}
}