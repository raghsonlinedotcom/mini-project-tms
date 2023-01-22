<%@ page import="com.raghsonline.miniprojects.tms.bo.LeaveDetailsBO" %>
<%@include file="../inc/header.jsp" %>

		<h1>View Leave Details</h1>
		
		<%
			LeaveDetailsBO leaveDetailsBO = (LeaveDetailsBO) request.getAttribute("leaveDetailsBO");
			String message = (String) request.getAttribute("message");	
			
			if(null!=message)
			{
		%>
				<div class="row">
					<div class="col-12" align="center">
						<div class="alert alert-success" role="alert">
						  	<%= message %>
						</div>
					</div>
				</div>				
		<% 
			}
		
			if(null!=leaveDetailsBO) 
			{
				
		%>
				<table class="table table-striped table-hover table-bordered 
						table-responsive caption-top">
					<caption>View Leave Details</caption>
					<thead>
						<tr>
							<td>Field</td>
							<td>Value</td>
						</tr>				
					</thead>
					<tbody class="table-group-divider">	
						
						<tr>
							<td>Id</td>
							<td><%=leaveDetailsBO.getId()%></td>
							
						</tr>
						<tr>
							<td>Emp Id</td>
							<td>${leaveDetailsBO.empId}</td>
						</tr>
						<tr>
							<td>Manager Id</td>
							<td>${leaveDetailsBO.managerId}</td>
						</tr>
						<tr>
							<td>From Date</td>
							<td>${leaveDetailsBO.fromDate}</td>
						</tr>
						<tr>
							<td>To Date</td>
							<td>${leaveDetailsBO.toDate}</td>
						</tr>
						<tr>
							<td>Leave Reason</td>
							<td>${leaveDetailsBO.leaveReason}</td>
						</tr>	
						<tr>
							<td>Status</td>
							<td>${leaveDetailsBO.status}</td>
						</tr>
						<tr>
							<td>Action Comment</td>
							<td>${leaveDetailsBO.actionComment}</td>
						</tr>
						<tr>
							<td>Alternate Contact Number</td>
							<td>${leaveDetailsBO.altContactNo}</td>
						</tr>
						<tr>
							<td>Created Date</td>
							<td>${leaveDetailsBO.createdDate}</td>
						</tr>
						
						<tr>
							<td>Created By</td>
							<td>${leaveDetailsBO.createdBy}</td>
						</tr>	
						<tr>
							<td>Updated Date</td>
							<td>${leaveDetailsBO.updatedDate}</td>
						</tr>
						<tr>
							<td>Updated By</td>
							<td>${leaveDetailsBO.updatedBy}</td>
						</tr>
					</tbody>
				</table>
		<%
			} else {
		%>
				<div class=errorMsg>No matching records for the given Id - ${param.id}.</div>
		<%
			}
		%>

<%@include file="../inc/footer.jsp" %>