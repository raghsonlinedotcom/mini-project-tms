<%@ page import="com.raghsonline.miniprojects.tms.bo.LeaveDetailBO" %>
<%@include file="../../inc/header.jsp" %>

		<h1>View My LeaveDetails</h1>
		
		<%
				LeaveDetailBO leaveDetailBO = (LeaveDetailBO) request.getAttribute("leaveDetailBO");
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
		
			if(null!=leaveDetailBO) 
			{
				session.setAttribute("leaveDetailBO", leaveDetailBO);
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
							<td>Emp Id</td>
							<td><%=leaveDetailBO.getEmpId()%></td>
							
						</tr>
						<tr>
							<td>Manager Id</td>
							<td>${leaveDetailBO.managerId}</td>
						</tr>
						<tr>
							<td>From Date</td>
							<td>${leaveDetailBO.fromDate}</td>
						</tr>
						<tr>
							<td>To Date</td>
							<td>${leaveDetailBO.toDate}</td>
						</tr>
						<tr>
							<td>Leave Reason</td>
							<td>${leaveDetailBO.leaveReason}</td>
						</tr>
						<tr>
							<td>Status</td>
							<td>${leaveDetailBO.status}</td>
						</tr>	
						<tr>
							<td>Action Comment</td>
							<td>${leaveDetailBO.actionComment}</td>
						</tr>
						<tr>
							<td>AltContactNo</td>
							<td>${leaveDetailBO.altContactNo}</td>
						</tr>
						<tr>
							<td>Created Date</td>
							<td>${leaveDetailBO.createdDate}</td>
						</tr>
						<tr>
							<td>Created By</td>
							<td>${leaveDetailBO.createdBy}</td>
						</tr>
						<tr>
							<td>Updated Date</td>
							<td>${leaveDetailBO.updatedDate}</td>
						</tr>
						<tr>
							<td>Updated By</td>
							<td>${leaveDetailBO.updatedBy}</td>
						</tr>
						<%
						 	System.out.println("leaveDetailBO :" + leaveDetailBO);
							if(leaveDetailBO.getStatus().equalsIgnoreCase("OPEN"))
							{
						%>
								<tr>
									<td colspan="2">
										<a href="<%=request.getContextPath()%>/member/leave/editleave.jsp">Edit</a> &nbsp;&nbsp;
									</td>
								</tr>
						<%
							}
						%>					
					</tbody>
				</table>
		<%
			} else {
		%>
				<div class=errorMsg>No matching records for the given Id - ${param.id}.</div>
		<%
			}
		%>

<%@include file="../../inc/footer.jsp" %>