<%@include file="inc/header.jsp"%>
<%@page import="com.raghsonline.miniprojects.tms.util.AppUtil"%>
<%
	String message = (String) request.getAttribute("message");
	String errorMessage = (String) request.getAttribute("errorMessage");
	if (null != message) 
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
	if (null != errorMessage) 
	{
%>
	<div class="row">
			<div class="col-12" align="center">
				<div class="alert danger" role="alert">
				  	<%= errorMessage %>
				</div>
			</div>
		</div>
<%
	}
%>
	
	<div class="row">
		<div class="col-12">
			<h1 class="mt-5">Team Management System</h1>
			<p class="lead text-center">A simple Java based Web Application to
				manage a Team.</p>
		</div>
	</div>
	<br />
	<div class="row">
		<div class="col-12">Click on the menu items on top for the
			different features.</div>
	</div>
	<br />
	<br />
	<div class="row">
	<div class="col-6">The frequently accessed link for the active
		development and tracking of projects can be found below.</div>
	<div class="col-6">
		<ul>
			<li><b>Jira</b> &rarr; <a
				href="https://raghsonlinedotcom.atlassian.net/projects/TMS">
					https://raghsonlinedotcom.atlassian.net/projects/TMS </a></li>
			<li><b>Confluence</b> &rarr; <a
				href="https://raghsonlinedotcom.atlassian.net/wiki/spaces/TE/pages/1114342/Welcome">
					https://raghsonlinedotcom.atlassian.net/wiki/spaces/TE/pages </a></li>
			<li><b>GitHub</b> &rarr; <a
				href="https://github.com/raghsonlinedotcom/mini-project-tms">
					https://github.com/raghsonlinedotcom/mini-project-tms </a></li>
			<li><b>Tomcat Server</b>
				<ul>
					<li><b>Localhost </b> &rarr; <a
						href="http://localhost:18080/TMS/">
							http://localhost:18080/TMS/ </a></li>
					<li><b>AWS EC2 Tomcat</b> &rarr; <a
						href="http://10.121.1.241:8080/TMS">
							http://10.121.1.241:8080/TMS </a> <br /> ...<i>Note: </i> You need to
						be connected to the VPN.</li>
					<li><b>Tomcat (webapps) inside Eclipse</b> &rarr; <code>
							&lt;ECLIPSE_INSTALLED_DIR&gt;/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps
						</code></li>
				</ul></li>
		</ul>
	</div>
</div>

<%@include file="inc/footer.jsp"%>