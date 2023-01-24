<%@page import="com.raghsonline.miniprojects.tms.bo.LeaveDetailBO"%>
<%@page import="com.raghsonline.miniprojects.tms.bo.EmployeeBO"%>
<%@page import="com.raghsonline.miniprojects.tms.dao.EmployeeDAO"%>
<%@page import="com.raghsonline.miniprojects.tms.dao.EmployeeDAOImpl"%>
<%@page import="com.raghsonline.miniprojects.tms.dao.LeaveDetailsDAO"%>
<%@page import="com.raghsonline.miniprojects.tms.dao.LeaveDetailsDAOImpl"%>
<%@ page import="java.util.List, java.util.ArrayList , java.sql.Timestamp" %>
<%@include file="../../inc/header.jsp" %>
               
			<%
				EmployeeDAO employeeDAO = new EmployeeDAOImpl();
				List<EmployeeBO> managerList = employeeDAO.viewManagers();
	    		
				String errorMessage = (String) request.getAttribute("message");
				LeaveDetailBO leaveDetailBO = (LeaveDetailBO) request.getAttribute("leaveDetailBO");
				
				EmployeeBO employeeBO = (EmployeeBO)session.getAttribute("employeeBO");
				
			
				if(null!=errorMessage) {
			%>					
					<div class="row">
						<div class="col-12" align="center">
							<div class="alert alert-danger" role="alert">
							  	<%= errorMessage %>
							</div>
						</div>
					</div>						
			<%	
				}
			
			 	String errorMsgUI = (String) request.getAttribute("errorMsgUI");
			 	
				boolean isValidationError = false;
				
			 	if(null!=errorMsgUI) 
			 	{
			 		isValidationError = true;
			 %>
			 		<h3>Validation Error(s)</h3>
					<div class="row">
						<div class="col-12" align="center">
	                        <div class="alert alert-danger" role="alert">
							  	<%= errorMsgUI %>
							</div>
						</div>
					</div>			 		
			 <% 
			 	}
			 %>
		<h2>Leave Request Form</h2>
		<form id="create" name="create" action="<%=request.getContextPath()%>/CreateLeaveDetails" method="post" >
		     <table class="table table-striped table-hover table-bordered 
				table-responsive caption-top">
  				<caption>Leave Details</caption>
				<thead>
					<tr>
						<th>Field</th>
						<th>Value</th>
					</tr>				
				</thead>
				<tbody class="table-group-divider">
					<tr>
						<td>EmployeeId <span class="required">*</span></td>
						<td>
							<input type ="number" Readonly class="form-control" id="empId" 
								name="empId" size="10" value = "<%=employeeBO.getEmpId()%>"
								 required size="20" >									
						</td>
					</tr>
					
					  <tr>
						<td>ManagerId <span class="required">*</span></td>
						<td>
							<input type="number" Readonly class="form-control" id="managerId" 
								name="managerId" size="10" value = "<%=employeeBO.getManagerId()%>" 
								 required size="20" >									
						</td>
					</tr>
					
					<tr>
						<td>From Date <span class="required">*</span></td>
						<td>
							<input type="datetime-local" class="form-control" id="fromDate" name="fromDate"  
								required >
						</td>
					</tr>
					<tr>
						<td>To Date <span class="required">*</span></td>
						<td>
							<input type="datetime-local" class="form-control" id="toDate" name="toDate"  
								required >
						</td>
					</tr>
					
					<tr>
						<td>Leave Reason <span class="required">*</span></td>
						<td>
							<input type="text" class="form-control" id="leaveReason" name="leaveReason" size="100" 
								placeholder="Enter the reason" maxlength="100"	required>
						</td>
					</tr>
	                
	                <tr>
	                    <td>Alternate Contact No <span class="required">*</span></td>
	                    <td><input type="tel" class="form-control" 
	                    id="alternateContactNo" name="alternateContactNo" 
	                    size="10"  placeholder="1234567890" 
	                    maxlength="10" required>
	                    </td>
	                </tr>
	               
	            	<tr>
						<td colspan="2">							
							<input class="btn btn-primary" type="submit" value="Apply"/>
							<input class="btn btn-outline-danger" type="reset" value="Reset"/>
						</td>
					</tr>				
				</tbody>
			</table>
		</form>
<%@include file="../../inc/footer.jsp" %>