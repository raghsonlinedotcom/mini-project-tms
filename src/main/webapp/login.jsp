<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.raghsonline.miniprojects.tms.util.AppUtil"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>TMS | Login Page</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="<%=request.getContextPath()%>/lib/bootstrap-5.2.3-dist/css/bootstrap.min.css"
			rel="stylesheet">
	   	<!--  custom CSS should come later  -->
	    <link rel="stylesheet" href="<%=request.getContextPath()%>/inc/style.css"/>
	    <!-- Custom styles for this template -->
    	<link rel="stylesheet" href="<%=request.getContextPath()%>/inc/sticky-footer-navbar.css"/>
	</head>
	<body class="d-flex flex-column h-100">
		<!-- Begin page content -->
		<main class="flex-shrink-0">
			<div class="container"> <!--  Container Div Start -->
			<%
				String errorMessage = (String) request.getAttribute("errorMessage");
				String message = (String) request.getAttribute("message");
			
				if(null!=errorMessage) {
			%>					
					<div class="row">
						<div class="col-12" align="center">
							<div class="alert alert-danger" role="alert">
							  	<%= errorMessage %>
							</div>
						</div>
					</div>						
			<%
				} 
				else 
				{
					if(null!=message) {
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
				}
			%>	
			<%
				if (!AppUtil.isAppReady) 
				{
			%>
					<div class="card">
					  <h5 class="card-header">Error</h5>
					  <div class="card-body">
					    <h5 class="card-title">Critical Error</h5>
					    <p class="card-text text-danger">The Application is not yet ready. Please contact Admin.</p>					    
					  </div>
					</div>
			<%
				} 
				else 
				{
			%>
					<div class="d-flex justify-content-center">	
						<div class="row">
							<!--  <div class="col-12">				
								<h1>Welcome to Team Management System (TMS)</h1>
							</div>-->
							<div class="col-12">				
								<h2>Login</h2>
							</div>
							<!-- <div class="col-12">				
								<p>
									Please login with your credentials.
								</p>
							</div> -->
							<div class="col-12">												
								<form id="loginForm" name="LoginForm" method="post" 
											action="<%=request.getContextPath()%>/Login">
									<table
										class="table table-striped table-hover table-bordered 
											table-responsive caption-top">
										<tbody>
											<tr>
												<td>Employee Id</td>
												<td>
													<input type="number" class="form-control" 
														id="empId" name="empId" size="10" min="1" 
														placeholder="Enter your EMP Id"
														value='<%= AppUtil.isAppDevMode ? "140" : "" %>'
														required size="20" >
												</td>
											</tr>
											<tr>
												<td>Password</td>
												<td>
													<input type="password" class="form-control" 
														id="password" name="password" size="15" 
														placeholder="password" maxlength="15"
														value='<%= AppUtil.isAppDevMode ? "Raghavan@muthu" : "" %>'
														required>
												</td>
											</tr>
											<tr>
												<td colspan="2" align="center">
													<input class="btn btn-primary" type="submit" value="Login"/>
													<input class="btn btn-outline-danger" type="reset" value="Reset"/>																									
												</td>
											</tr>
											<tr>
												<td colspan="2" align="center">
													New User ? Click  
													<a href="<%=request.getContextPath() %>/create.jsp">here</a>	
													to register. 																								
												</td>
											</tr>
										</tbody>
									</table>
								</form>
							</div>
						</div>
					</div>
			<%
				}
			%>
<%@include file="inc/footer.jsp" %>
