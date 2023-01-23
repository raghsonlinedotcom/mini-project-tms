<%@page import="com.raghsonline.miniprojects.tms.bo.LeaveDetailBO"%>
<%@ page import="java.util.List,java.util.ArrayList" %>
<%@include file="../inc/header.jsp" %>

		<h1>View My Teams Leave</h1>
		<%
		List<LeaveDetailBO> leaveDetailBOList = new ArrayList<>();
			Object obj = request.getAttribute("leaveDetailBOList");
			if(null!=obj) {
				leaveDetailBOList = (List<LeaveDetailBO>) obj;
			}
		%>
				
		<h3>Total number of leave requests is : <%=leaveDetailBOList.size()%></h3>			
		<%
					if(leaveDetailBOList.size()<=0) {
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
				for(LeaveDetailBO leaveDetailBO : leaveDetailBOList)
						{
							out.println("<tr>");
							out.println("<td class='center'>" + leaveDetailBO.getId());
							out.println("<td>" + leaveDetailBO.getEmpId() + "</td>");
							out.println("<td class='center'>" + leaveDetailBO.getManagerId() + "</td>");
							out.println("<td class='center'>" + leaveDetailBO.getFromDate() + "</td>");
							out.println("<td>" + leaveDetailBO.getToDate() + "</td>");
							out.println("<td>" + leaveDetailBO.getLeaveReason() + "</td>");
							out.println("<td>" + leaveDetailBO.getStatus() + "</td>");
							out.println("<td>" + "<a href='ViewLeaveDetailsById?id=" + 
									leaveDetailBO.getId() + "'>View " + "</a> "+  "</td>");
							if(leaveDetailBO.getStatus().equalsIgnoreCase("Open"))
							{
								out.println("<td>" + "<a href='ManagerEditLeaveDetails?id=" + 
										leaveDetailBO.getId() + "'>Edit " + "</a> "+  "</td>");
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