<%@page import="com.raghsonline.miniprojects.tms.bo.LeaveDetailBO"%>
<%@ page import="java.util.List,java.util.ArrayList" %>
<%@include file="../../inc/header.jsp" %>

		<h1>View My LeaveDetails</h1>
		<%
		List<LeaveDetailBO> leaveDetailBOList = new ArrayList<>();
			Object obj = request.getAttribute("leaveDetailBOList");
			if(null!=obj) {
				leaveDetailBOList = (List<LeaveDetailBO>) obj;
			}
		%>
				
		<h3>Total list of leaves is : <%=leaveDetailBOList.size()%></h3>			
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
				for(LeaveDetailBO leaveDetailBO : leaveDetailBOList)
						{
							out.println("<tr>");
							out.println("<td class='center'>" + leaveDetailBO.getId());
							out.println("<td class='center'>" + leaveDetailBO.getEmpId());
							out.println("<td>" + leaveDetailBO.getManagerId() + "</td>");
							out.println("<td class='center'>" + leaveDetailBO.getFromDate() + "</td>");
							out.println("<td class='center'>" + leaveDetailBO.getToDate() + "</td>");
							out.println("<td>" + leaveDetailBO.getLeaveReason() + "</td>");
							out.println("<td>" + leaveDetailBO.getStatus() + "</td>");
							//out.println("<td>" + leavedetailsBO.getActionComment() + "</td>");
							//out.println("<td>" + leavedetailsBO.getAltContactNo() + "</td>");
							out.println("<td>" + "<a href='MyLeaveDetails?id=" + 
									leaveDetailBO.getId() + "'>View " + "</a> "+  "</td>");
							if(leaveDetailBO.getStatus().equalsIgnoreCase("OPEN"))
							{
								out.println("<td>" + "<a href='EditLeave?id=" + 
										leaveDetailBO.getId() + "'>Edit" + "</a> "+  "</td>");
							}
							out.println("</tr>");
						}
				%>					
			</tbody>
		</table>
		<%
			}
		%>
<%@include file="../../inc/footer.jsp" %>