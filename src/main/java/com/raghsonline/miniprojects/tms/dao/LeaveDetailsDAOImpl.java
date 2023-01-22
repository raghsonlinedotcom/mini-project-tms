package com.raghsonline.miniprojects.tms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.raghsonline.miniprojects.tms.bo.LeaveDetailsBO;
import com.raghsonline.miniprojects.tms.db.DBConnection;
import com.raghsonline.miniprojects.tms.util.AppUtil;

public class LeaveDetailsDAOImpl implements LeaveDetailsDAO {
	Logger logger = Logger.getLogger(LeaveDetailsDAOImpl.class);
	
	@Override
	public List<LeaveDetailsBO> viewMyTeamsLeave(int managerId) throws Exception {
		logger.info("viewMyTeamsLeave() Invoked");
		
		String sql = "SELECT * FROM LEAVE_DETAILS WHERE MANAGER_ID =?";
		
		logger.info("SQL Query :: "+ sql);
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<LeaveDetailsBO> leaveDetailsList = new ArrayList<>();
		LeaveDetailsBO leaveDetailsBO = null;
		Connection conn = null;
		
		try 
		{
			conn = DBConnection.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, managerId);

			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				leaveDetailsBO = new LeaveDetailsBO();
				leaveDetailsBO.setId(rs.getInt("ID"));
				leaveDetailsBO.setEmpId(rs.getInt("EMP_ID"));
				leaveDetailsBO.setManagerId(rs.getInt("MANAGER_ID"));
				leaveDetailsBO.setFromDate(rs.getTimestamp("FROM_DATE"));
				leaveDetailsBO.setToDate(rs.getTimestamp("TO_DATE"));
				leaveDetailsBO.setLeaveReason(rs.getString("LEAVE_REASON"));
				leaveDetailsBO.setStatus(rs.getString("STATUS"));
				leaveDetailsBO.setActionComment(rs.getString("ACTION_COMMENT"));
				leaveDetailsBO.setAltContactNo(rs.getString("ALT_CONTACT_NO"));
				leaveDetailsBO.setCreatedDate(rs.getTimestamp("CREATED_DATE"));
				leaveDetailsBO.setCreatedBy(rs.getInt("CREATED_BY"));
				leaveDetailsBO.setUpdatedDate(rs.getTimestamp("UPDATED_DATE"));
				leaveDetailsBO.setUpdatedBy(rs.getInt("UPDATED_BY"));
				leaveDetailsList.add(leaveDetailsBO);	
			}
		} catch (SQLException sqlException) {
			logger.error("SQLException occurred while reading the data from the Database Table");
			logger.error("Message : " + sqlException.getMessage());
		} catch (Exception exception) {
			logger.error("Exception occurred while reading the data from the Database Table");
			logger.error("Message : " + exception.getMessage());
		} finally {
			try {
				if (null != rs)
					rs.close();
				if (null != pstmt)
					pstmt.close();
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
	public LeaveDetailsBO viewLeaveDetailsById(int id) throws Exception {
		logger.info("viewLeaveDetailsById() invoked - idParam :: " + id);

		String sql = "SELECT * FROM LEAVE_DETAILS WHERE ID=?";

		logger.info("SQL Query :: " + sql);

		PreparedStatement stmt = null;
		ResultSet rs = null;

		LeaveDetailsBO leaveDetailsBO = null;
		Connection conn = null;

		try {

			conn = DBConnection.getConn();

			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			while (rs.next()) 
			{ // read one full row's data - one column at a time

				// makes sense to create an object, so that we don't waste the memory allotted
				// to an Object.
				leaveDetailsBO = new LeaveDetailsBO();

				leaveDetailsBO.setId(rs.getInt("ID"));
				leaveDetailsBO.setEmpId(rs.getInt("EMP_ID"));
				leaveDetailsBO.setManagerId(rs.getInt("MANAGER_ID"));
				leaveDetailsBO.setFromDate(rs.getTimestamp("FROM_DATE"));
				leaveDetailsBO.setToDate(rs.getTimestamp("TO_DATE"));
				leaveDetailsBO.setLeaveReason(rs.getString("LEAVE_REASON"));
				leaveDetailsBO.setStatus(rs.getString("STATUS"));
				leaveDetailsBO.setActionComment(rs.getString("ACTION_COMMENT"));
				leaveDetailsBO.setAltContactNo(rs.getString("ALT_CONTACT_NO"));
				leaveDetailsBO.setCreatedDate(rs.getTimestamp("CREATED_DATE"));
				leaveDetailsBO.setCreatedBy(rs.getInt("CREATED_BY"));
				leaveDetailsBO.setUpdatedDate(rs.getTimestamp("UPDATED_DATE"));
				leaveDetailsBO.setUpdatedBy(rs.getInt("UPDATED_BY"));
				
			}
		} catch (SQLException sqlException) {
			logger.error("SQLException occurred while reading the data from the Database Table");
			logger.error("Message : " + sqlException.getMessage());
		} catch (Exception exception) {
			logger.error("Exception occurred while reading the data from the Database Table");
			logger.error("Message : " + exception.getMessage());
		} finally {
			try {
				if (null != rs)
					rs.close();
				if (null != stmt)
					stmt.close();
				if (null != conn)
					conn.close();
			} catch (SQLException sqlException) {
				logger.error("Exception occurred while closing the DB Resource(s)");
				logger.error("Message : " + sqlException.getMessage());
			} 
		}

		return leaveDetailsBO;

	}

}
