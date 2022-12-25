<%@include file="header.jsp" %>
<%@page import="com.tutorials.tms.util.AppUtil"%>
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
<%@include file="footer.jsp" %>