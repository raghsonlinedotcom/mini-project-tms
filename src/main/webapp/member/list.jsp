<%@page import="com.raghsonline.miniprojects.tms.bo.EmployeeBO"%>
<%@ page import="java.util.List, java.util.ArrayList" %>
<%@include file="../inc/header.jsp" %>

		<h1>View All Employees</h1>
		<%
			List<EmployeeBO> employeeBOList = new ArrayList<>();
			Object obj = request.getAttribute("employeeBOList");
			if(null!=obj) {
				employeeBOList = (List<EmployeeBO>) obj;
			}
		%>
				
		<h3>Total list of employees is : <%= employeeBOList.size() %></h3>			
		<% 
			if(employeeBOList.size()<=0) {
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
		<h3>Employees List</h3>	
		<table class="table table-striped table-hover table-bordered 
						table-responsive caption-top">
					<caption>View All Employees</caption>
					<thead>
						<tr>
							<th>Emp Id</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Gender</th>
							<th>Official Email</th>
							<th>Primary Contact Number</th>
							<th>Manager Id </th>
						</tr>				
					</thead>
			<tbody class="table-group-divider">	
			<%				
				for(EmployeeBO employeeBO : employeeBOList)
				{
					out.println("<tr>");
					out.println("<td class='center'>" + employeeBO.getEmpId());
					out.println("<td>" + employeeBO.getFirstName() + "</td>");
					out.println("<td class='center'>" + employeeBO.getLastName() + "</td>");
					out.println("<td class='center'>" + employeeBO.getGender() + "</td>");
					out.println("<td>" + employeeBO.getOfficialEmail() + "</td>");
					out.println("<td>" + employeeBO.getPrimaryContactNo() + "</td>");
					out.println("<td>" + employeeBO.getManagerId() + "</td>");
					out.println("</tr>");
				}			
			%>					
			</tbody>
		</table>
		<%
			}
		%>
<%@include file="../inc/footer.jsp" %>