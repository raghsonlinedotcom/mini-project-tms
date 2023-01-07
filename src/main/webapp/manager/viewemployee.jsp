<%@ page import="com.raghsonline.miniprojects.tms.bo.EmployeeBO" %>
<%@include file="../inc/header.jsp" %>

		<h1>View Employee Details</h1>
		
		<%
			EmployeeBO employeeBO = (EmployeeBO) request.getAttribute("employeeBO");
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
		
			if(null!=employeeBO) 
			{
				
		%>
				<table class="table table-striped table-hover table-bordered 
						table-responsive caption-top">
					<caption>View Employee Details</caption>
					<thead>
						<tr>
							<td>Field</td>
							<td>Value</td>
						</tr>				
					</thead>
					<tbody class="table-group-divider">	
						
						<tr>
							<td>EmpId</td>
							<td><%=employeeBO.getEmpId()%></td>
							
						</tr>
						<tr>
							<td>FirstName</td>
							<td>${employeeBO.firstName}</td>
						</tr>
						<tr>
							<td>LastName</td>
							<td>${employeeBO.lastName}</td>
						</tr>
						<tr>
							<td>DateOfBirth</td>
							<td>${employeeBO.dateOfBirth}</td>
						</tr>
						<tr>
							<td>Gender</td>
							<td>${employeeBO.gender}</td>
						</tr>
						<tr>
							<td>AadharId</td>
							<td>${employeeBO.aadharId}</td>
						</tr>	
						<tr>
							<td>BloodGroup</td>
							<td>${employeeBO.bloodGroup}</td>
						</tr>
						<tr>
							<td>City</td>
							<td>${employeeBO.city}</td>
						</tr>
						<tr>
							<td>PersonalEmail</td>
							<td>${employeeBO.personalEmail}</td>
						</tr>
						<tr>
							<td>OfficialEmail</td>
							<td>${employeeBO.officialEmail}</td>
						</tr>
						
						<tr>
							<td>PrimaryContactNo</td>
							<td>${employeeBO.primaryContactNo}</td>
						</tr>	
						<tr>
							<td>SecondaryContactNo</td>
							<td>${employeeBO.secondaryContactNo}</td>
						</tr>
						<tr>
							<td>HighestQualification</td>
							<td>${employeeBO.highestQualification}</td>
						</tr>
						<tr>
							<td>SkillSets</td>
							<td>${employeeBO.skillsets}</td>
						</tr>
						<tr>
							<td>DateOfJoining</td>
							<td>${employeeBO.dateOfJoining}</td>
						</tr>
						<tr>
							<td>Hobbies</td>
							<td>${employeeBO.hobbies}</td>
						</tr>
						<tr>
							<td>ManagerId</td>
							<td>${employeeBO.managerId}</td>
						</tr>
						<tr>
							<td>Created Date</td>
							<td>${employeeBO.createdDate}</td>
						</tr>
						<tr>
							<td>Created By</td>
							<td>${employeeBO.createdBy}</td>
						</tr>
						<tr>
							<td>Updated Date</td>
							<td>${employeeBO.updatedDate}</td>
						</tr>
						<tr>
							<td>Updated By</td>
							<td>${employeeBO.updatedBy}</td>
						</tr>	
					</tbody>
				</table>
		<%
			} else {
		%>
				<div class=errorMsg>No matching records for the given Id - ${param.empId}.</div>
		<%
			}
		%>

<%@include file="../inc/footer.jsp" %>