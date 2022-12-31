<%@ page import="java.util.List, java.util.ArrayList, com.tutorials.tms.bo.EmployeeBO" %>
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
							<td>Employee Id</td>
							<td>First Name</td>
							<td>Last Name</td>
							<td>Gender</td>
							<td>Date of Birth</td>
							<td>City</td>
							<td>Personal Email</td>
							<td>Official Email</td>
							<td>Primary Contact Number</td>
							<td>Date of Joining</td>
							<td>Manager Id </td>
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
					out.println("<td>" + employeeBO.getDateOfBirth() + "</td>");
					out.println("<td>" + employeeBO.getCity() + "</td>");
					out.println("<td>" + employeeBO.getPersonalEmail() + "</td>");
					out.println("<td>" + employeeBO.getOfficialEmail() + "</td>");
					out.println("<td>" + employeeBO.getPrimaryContactNo() + "</td>");
					out.println("<td>" + employeeBO.getDateOfJoining() + "</td>");
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