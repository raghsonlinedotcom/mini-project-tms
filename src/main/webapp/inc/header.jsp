<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>TMS | Home Page</title>
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- CSS only -->
	    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"> -->
	    <link href="<%= request.getContextPath() %>/lib/bootstrap-5.2.3-dist/css/bootstrap.min.css" rel="stylesheet">	    
	    <style>
	      .bd-placeholder-img {
	        font-size: 1.125rem;
	        text-anchor: middle;
	        -webkit-user-select: none;
	        -moz-user-select: none;
	        user-select: none;
	      }
	
	      @media (min-width: 768px) {
	        .bd-placeholder-img-lg {
	          font-size: 3.5rem;
	        }
	      }
	
	      .b-example-divider {
	        height: 3rem;
	        background-color: rgba(0, 0, 0, .1);
	        border: solid rgba(0, 0, 0, .15);
	        border-width: 1px 0;
	        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
	      }
	
	      .b-example-vr {
	        flex-shrink: 0;
	        width: 1.5rem;
	        height: 100vh;
	      }
	
	      .bi {
	        vertical-align: -.125em;
	        fill: currentColor;
	      }
	
	      .nav-scroller {
	        position: relative;
	        z-index: 2;
	        height: 2.75rem;
	        overflow-y: hidden;
	      }
	
	      .nav-scroller .nav {
	        display: flex;
	        flex-wrap: nowrap;
	        padding-bottom: 1rem;
	        margin-top: -1px;
	        overflow-x: auto;
	        text-align: center;
	        white-space: nowrap;
	        -webkit-overflow-scrolling: touch;
	      }
	    </style>
	   	<!--  custom CSS should come later  -->
	    <link rel="stylesheet" href="<%=request.getContextPath()%>/inc/style.css"/>
	    <!-- Custom styles for this template -->
    	<link rel="stylesheet" href="<%=request.getContextPath()%>/inc/sticky-footer-navbar.css"/>
	</head>
	<body class="d-flex flex-column h-100">
	    <header>
   			<%@include file="menu.jsp"%>
   		</header>
		<!-- Begin page content -->
		<main class="flex-shrink-0">
			<div class="container"> <!--  Container Div Start -->
			<%
				if(null==session.getAttribute("employeeBO")) {
					request.setAttribute("errorMessage",  "Unauthorized Access. Please login");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			%>
	    	