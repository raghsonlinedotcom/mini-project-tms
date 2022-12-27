
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TMS | Login Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="<%=request.getContextPath()%>/lib/bootstrap-5.2.3-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="style.css" />
<link href="sticky-footer-navbar.css" rel="stylesheet">
</head>
<body class="log">

		<%
			String errorMessage = (String) request.getAttribute("errorMessage");
			String message = (String) request.getAttribute("message");
		
			if(null!=errorMessage) {
		%>
				<div class="errorMsg"><%= errorMessage %></div>
		<%
			} else {
				if(null!=message) {
		%>	
				<div class=successMsg><%= message %></div>
		<%	
				}
			}
		%>	
	<h2>Login</h2>

	<form id="loginForm" name="LoginForm" method="post" action="Login">
		<table
			class="table table-striped table-hover table-bordered 
				table-responsive caption-top">
			<thead>
				<tr>
					<th>Field</th>
					<th>Value</th>
				</tr>
			</thead>

			<tbody class="table-group-divider">
				<tr>
					<td>EmployeeId</td>
					<td><input type="number" class="form-control" id="empId"
						name="empId" size="10" min="1" placeholder="Enter the employeeId"
						required size="20"></td>
				</tr>

				<tr>
					<td>Password</td>
					<td><input type="password" class="form-control" id="password"
						name="password" size="15" placeholder="password" maxlength="15"
						required></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" name="Login"
						Value="Login" /> <input type="reset" name="Reset" Value="Reset" />



					</td>

				</tr>
			</tbody>
		</table>
	</form>



</body>
</html>
<%@include file="footer.jsp" %>
