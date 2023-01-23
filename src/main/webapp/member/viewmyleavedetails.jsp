<%@ page import="com.raghsonline.miniprojects.tms.bo.LeaveDetailBO" %>
<%@include file="../inc/header.jsp" %>

		<h1>View My LeaveDetails</h1>
		
		<%
				LeaveDetailBO leavedetailsBO = (LeaveDetailBO) request.getAttribute("leavedetailsBO");
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
		
			if(null!=leavedetailsBO) 
			{
				session.setAttribute("leavedetailsBO", leavedetailsBO);
		%>
				<table class="table table-striped table-hover table-bordered 
						table-responsive caption-top">
					<caption>View My LeaveDetails</caption>
					<thead>
						<tr>
							<td>Field</td>
							<td>Value</td>
						</tr>				
					</thead>
					<tbody class="table-group-divider">	
						
						<tr>
							<td>EmpId</td>
							<td><%=leavedetailsBO.getEmpId()%></td>
							
						</tr>
						<tr>
							<td>ManagerId</td>
							<td>${leavedetailsBO.managerId}</td>
						</tr>
						<tr>
							<td>FromDate</td>
							<td>${leavedetailsBO.fromDate}</td>
						</tr>
						<tr>
							<td>ToDate</td>
							<td>${leavedetailsBO.toDate}</td>
						</tr>
						<tr>
							<td>LeaveReason</td>
							<td>${leavedetailsBO.leaveReason}</td>
						</tr>
						<tr>
							<td>Status</td>
							<td>${leavedetailsBO.status}</td>
						</tr>	
						<tr>
							<td>ActionComment</td>
							<td>${leavedetailsBO.actionComment}</td>
						</tr>
						<tr>
							<td>AltContactNo</td>
							<td>${leavedetailsBO.altContactNo}</td>
						</tr>
						<tr>
							<td>Created Date</td>
							<td>${leavedetailsBO.createdDate}</td>
						</tr>
						<tr>
							<td>Created By</td>
							<td>${leavedetailsBO.createdBy}</td>
						</tr>
						<tr>
							<td>Updated Date</td>
							<td>${leavedetailsBO.updatedDate}</td>
						</tr>
						<tr>
							<td>Updated By</td>
							<td>${leavedetailsBO.updatedBy}</td>
						</tr>
						<tr>
							<td colspan="2">
								<!-- <form id="editForm" name="EditForm" action="Edit" action="post">
									<input type="submit" name="Edit" Value="Edit"/>
								</form>-->
								Edit &nbsp;&nbsp;
			
							</td>
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