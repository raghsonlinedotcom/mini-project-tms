<%@page import="com.tutorials.tms.util.AppUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>TMS | Home Page</title>
		<link rel="stylesheet" href="style.css"/>
	</head>
	<body>
		<%
			if(!AppUtil.isAppReady) {
		%>
				<span class="required">
					The Application is not yet ready. Please contact Admin.
				</span>
		<% 
			} else {
		%>
				<h1> Welcome to TMS - Team Management System </h1>
				<div>
					Click on <a href="create.jsp" style="color: green">Register</a>
				</div>
		<%	
			}
		%>
	</body>
</html>