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
		logger.info("getLeaveDetailsById() invoked - idParam :: " + id);

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
		logger.info("getLeaveDetails() invoked- idParam ::" + idParam);
		
		String sql ="SELECT * FROM LEAVE_DETAILS WHERE EMP_ID=?";
		
		logger.info("SQL Query :: "+ sql);
		
		ResultSet rs = null;
		List<LeaveDetailBO> leaveDetailBOList = new ArrayList<>();
		LeaveDetailBO leaveDetailBO = null;
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
				leaveDetailBO = new LeaveDetailBO();
				
				leaveDetailBO.setId(rs.getInt("ID"));
				leaveDetailBO.setEmpId(rs.getInt("EMP_ID"));
				leaveDetailBO.setManagerId(rs.getInt("MANAGER_ID"));
				leaveDetailBO.setFromDate(rs.getTimestamp("FROM_DATE"));
				leaveDetailBO.setToDate(rs.getTimestamp("TO_DATE"));
				leaveDetailBO.setLeaveReason(rs.getString("LEAVE_REASON"));
				leaveDetailBO.setStatus(rs.getString("STATUS"));
				leaveDetailBO.setCreatedBy(rs.getInt("CREATED_BY"));
				
				leaveDetailBOList.add(leaveDetailBO);	
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
		
		logger.info("LeaveDetailBOList size : " + leaveDetailBOList.size());
		
		return leaveDetailBOList;
	}

	@Override
	public int managerUpdateLeaveDetails(LeaveDetailBO leaveDetailBO) throws Exception {
		logger.info("managerUpdateLeaveDetails :: " + leaveDetailBO);

		String sql = "UPDATE LEAVE_DETAILS SET STATUS=?, ACTION_COMMENT=?, "
				+ "UPDATED_DATE=?, UPDATED_BY=? WHERE ID= ?";

		logger.info("SQL Query :: " + sql);
		Connection conn = null;
		PreparedStatement pStmt = null;
		int recordsUpdated = 0;
		
		try
		{
			conn = DBConnection.getConn();
			
			pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, leaveDetailBO.getStatus());
			pStmt.setString(2, leaveDetailBO.getActionComment());
			pStmt.setTimestamp(3, leaveDetailBO.getUpdatedDate());
			pStmt.setInt(4, leaveDetailBO.getUpdatedBy());
			pStmt.setInt(5, leaveDetailBO.getId());
			
			recordsUpdated = pStmt.executeUpdate();
			
			logger.info("recordsUpdated : " + recordsUpdated);
			
		} catch (Exception exception) {
			logger.error("Exception occurred while updating the data into the Database Table");
			logger.error("Message : " + exception.getMessage());
		} finally {
			try {
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

		logger.info("recordsUpdated  : " + recordsUpdated);
		
		return recordsUpdated;

	}

	@Override
	public int createLeaveDetails(LeaveDetailBO leaveDetailBO)
	throws Exception 
	{
		logger.info("LeaveDetailsDAOImpl - createLeaveDetails() invoked");

		// 1. Obtain the DB Connection
		Connection conn = DBConnection.getConn();

		// 2. Prepare the SQL Query and Statement Object
		String sql = "INSERT INTO LEAVE_DETAILS(EMP_ID, MANAGER_ID, FROM_DATE,TO_DATE, LEAVE_REASON,"
				+ "  ALT_CONTACT_NO,CREATED_BY)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = null;
		int rowsAdded = 0;
		int lastInsertedId = 0;
		ResultSet rs = null;

		ps = conn.prepareStatement(sql);

		// 3. Set/ Bind Values to the Prepared Statement
		ps.setInt(1, leaveDetailBO.getEmpId());
		if ( leaveDetailBO.getManagerId() == 0) { /* No Manager */
			ps.setObject(2, null);
		} else {
			ps.setInt(2,  leaveDetailBO.getManagerId());
		}
		ps.setTimestamp(3, leaveDetailBO.getFromDate());
		ps.setTimestamp(4, leaveDetailBO.getToDate());
		ps.setString(5,  leaveDetailBO.getLeaveReason());
		ps.setString(6,  leaveDetailBO.getAltContactNo());
		ps.setInt(7,   leaveDetailBO.getCreatedBy());
	
        // 4. Execute the Statement
		rowsAdded = ps.executeUpdate();

		rs = ps.executeQuery("SELECT LAST_INSERT_ID()");

		if (rs.next()) {
			lastInsertedId = rs.getInt(1);
		} else {
			logger.error("There was no record inserted in this session!");
		}

		logger.info("Rows Added : " + rowsAdded);
		logger.info("Last Inserted Id : " + lastInsertedId);
		
		conn.close();

		return lastInsertedId;
	}

	@Override
	public int updateLeave(LeaveDetailBO leaveDetailBO) 
	throws Exception 
	{
		logger.info("updateLeave :: " + leaveDetailBO);

		String sql = "UPDATE LEAVE_DETAILS SET " + "FROM_DATE=?, TO_DATE=?, LEAVE_REASON=?, STATUS=?,"
				+ " ACTION_COMMENT=?, ALT_CONTACT_NO=?,"
				+ " UPDATED_DATE=?,UPDATED_BY=?"
				+ " WHERE ID= ?";

		logger.info("SQL Query :: " + sql);
		Connection conn = null;
		PreparedStatement pStmt = null;
		int recordsUpdated = 0;
		
		try
		{
			conn = DBConnection.getConn();
			
			pStmt = conn.prepareStatement(sql);
			
			pStmt.setTimestamp(1, leaveDetailBO.getFromDate());
			pStmt.setTimestamp(2, leaveDetailBO.getToDate());
			pStmt.setString(3, leaveDetailBO.getLeaveReason());
			pStmt.setString(4, leaveDetailBO.getStatus());
			pStmt.setString(5, leaveDetailBO.getActionComment());
			pStmt.setString(6, leaveDetailBO.getAltContactNo());
			pStmt.setTimestamp(7, leaveDetailBO.getUpdatedDate());
			pStmt.setInt(8, leaveDetailBO.getUpdatedBy());
			pStmt.setInt(9, leaveDetailBO.getId());
			
			recordsUpdated = pStmt.executeUpdate();
			
			logger.info("recordsUpdated : " + recordsUpdated);
			
		} 
		catch (Exception exception) 
		{
			logger.error("Exception occurred while updating the data into the Database Leave Details Table");
			logger.error("Message : " + exception.getMessage());
		} 
		finally 
		{
			try 
			{
				if (null != pStmt)
					pStmt.close();
				if (null != conn)
					conn.close();
			} 
			catch (SQLException sqlException)
			{
				logger.error("Exception occurred while closing the JDBC Resources");
				logger.error("Message : " + sqlException.getMessage());
				if(AppUtil.isAppDevMode) 
				{
					sqlException.printStackTrace();
				}
			}
		}
		logger.info("recordsUpdated  : " + recordsUpdated);
		return recordsUpdated;
	}
}