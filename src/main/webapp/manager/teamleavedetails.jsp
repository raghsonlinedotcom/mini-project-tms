<%@page import="com.raghsonline.miniprojects.tms.bo.LeaveDetailBO"%>
<%@ page import="java.util.List,java.util.ArrayList" %>
<%@include file="../inc/header.jsp" %>

		<h1>View My Teams Leave</h1>
		<%
		List<LeaveDetailBO> leaveDetailsBOList = new ArrayList<>();
			Object obj = request.getAttribute("leaveDetailsBOList");
			if(null!=obj) {
				leaveDetailsBOList = (List<LeaveDetailBO>) obj;
			}
		%>
				
		<h3>Total number of leave requests is : <%=leaveDetailsBOList.size()%></h3>			
		<%
					if(leaveDetailsBOList.size()<=0) {
					%>
			<div class="row">
						<div class="col-12" align="center">
							<div class="alert alert-danger" role="alert">
							  	No records are available to display.
							</div>
						</div>
			</div>
		<%
		} else {
		%>	
		<h3>Leave Requests</h3>	
		<table class="table table-striped table-hover table-bordered 
						table-responsive caption-top">
					<caption>View My Teams Leave</caption>
					<thead>
						<tr>
							<th>Id</th>
							<th>Emp Id</th>
							<th>Manager Id</th>
							<th>From Date</th>
							<th>To Date</th>
							<th>Leave Reason</th>
							<th>Status</th>
							<th>Action</th>
						</tr>				
					</thead>
			<tbody class="table-group-divider">	
			<%
				for(LeaveDetailBO leaveDetailsBO : leaveDetailsBOList)
						{
							out.println("<tr>");
							out.println("<td class='center'>" + leaveDetailsBO.getId());
							out.println("<td>" + leaveDetailsBO.getEmpId() + "</td>");
							out.println("<td class='center'>" + leaveDetailsBO.getManagerId() + "</td>");
							out.println("<td class='center'>" + leaveDetailsBO.getFromDate() + "</td>");
							out.println("<td>" + leaveDetailsBO.getToDate() + "</td>");
							out.println("<td>" + leaveDetailsBO.getLeaveReason() + "</td>");
							out.println("<td>" + leaveDetailsBO.getStatus() + "</td>");
							out.println("<td>" + "<a href='ViewLeaveDetailsById?id=" + 
							leaveDetailsBO.getId() + "'>View " + "</a> "+  "</td>");
							if(leaveDetailsBO.getStatus().equalsIgnoreCase("Open"))
							{
								out.println("<td>Edit</td>");
							}
							
							out.println("</tr>");
						}
				%>					
			</tbody>
		</table>
		<%
			}
		%>
<%@include file="../inc/footer.jsp" %>