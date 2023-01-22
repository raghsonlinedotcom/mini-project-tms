<%@page import="com.raghsonline.miniprojects.tms.bo.LeaveDetailsBO"%>
<%@ page import="java.util.List, java.util.ArrayList" %>
<%@include file="../inc/header.jsp" %>

		<h1>View My LeaveDetails</h1>
		<%
			List<LeaveDetailsBO> leavedetailsBOList = new ArrayList<>();
			Object obj = request.getAttribute("leavedetailsBOList");
			if(null!=obj) {
				leavedetailsBOList = (List<LeaveDetailsBO>) obj;
			}
		%>
				
		<h3>Total list of leaves is : <%= leavedetailsBOList.size() %></h3>			
		<% 
			if(leavedetailsBOList.size()<=0) {
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
		<h3>LeaveDetails</h3>	
		<table class="table table-striped table-hover table-bordered 
						table-responsive caption-top">
					<caption>View My LeaveDetails</caption>
					<thead>
						<tr>
						    <th>Id</th>
							<th>EmpId</th>
							<th>ManagerId</th>
							<th>FromDate</th>
							<th>ToDate</th>
							<th>LeaveReason</th>
							<th>Status</th>
							<th>View</th>
							<th>Edit</th>
						</tr>				
					</thead>
			<tbody class="table-group-divider">	
			<%				
				for(LeaveDetailsBO leavedetailsBO : leavedetailsBOList)
				{
					out.println("<tr>");
					out.println("<td class='center'>" + leavedetailsBO.getId());
					out.println("<td class='center'>" + leavedetailsBO.getEmpId());
					out.println("<td>" + leavedetailsBO.getManagerId() + "</td>");
					out.println("<td class='center'>" + leavedetailsBO.getFromDate() + "</td>");
					out.println("<td class='center'>" + leavedetailsBO.getToDate() + "</td>");
					out.println("<td>" + leavedetailsBO.getLeaveReason() + "</td>");
					out.println("<td>" + leavedetailsBO.getStatus() + "</td>");
					//out.println("<td>" + leavedetailsBO.getActionComment() + "</td>");
					//out.println("<td>" + leavedetailsBO.getAltContactNo() + "</td>");
					out.println("<td>" + "<a href='ViewMyLeaveDetails?id=" + 
							leavedetailsBO.getId() + "'>View " + "</a> "+  "</td>");
					out.println("<td>Edit</td>");
					out.println("</tr>");
				}			
			%>					
			</tbody>
		</table>
		<%
			}
		%>
<%@include file="../inc/footer.jsp" %>