package com.raghsonline.miniprojects.tms.bo;

import java.sql.Timestamp;

public class LeaveDetailBO {

	private int id;

	private int empId;

	private int managerId;

	private Timestamp fromDate;

	private Timestamp toDate;

	private String leaveReason;

	private String status;

	private String actionComment;

	private String altContactNo;

	private Timestamp createdDate;

	private int createdBy;

	private Timestamp updatedDate;

	private int updatedBy;

	public LeaveDetailBO() {
	}

	public LeaveDetailBO(int id, int empId, int managerId, 
			String leaveReason, String status) 
	{
		super();
		this.id = id;
		this.empId = empId;
		this.managerId = managerId;
		this.leaveReason = leaveReason;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public Timestamp getFromDate() {
		return fromDate;
	}

	public void setFromDate(Timestamp fromDate) {
		this.fromDate = fromDate;
	}

	public Timestamp getToDate() {
		return toDate;
	}

	public void setToDate(Timestamp toDate) {
		this.toDate = toDate;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getActionComment() {
		return actionComment;
	}

	public void setActionComment(String actionComment) {
		this.actionComment = actionComment;
	}

	public String getAltContactNo() {
		return altContactNo;
	}

	public void setAltContactNo(String altContactNo) {
		this.altContactNo = altContactNo;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() 
	{
		return "LeaveDetailBO [" + "hashCode()=" + hashCode() + ", id=" + id + ", empId=" + empId + ", managerId="
				+ managerId + ", leaveReason=" + leaveReason + ", status=" + status;

	}
}
