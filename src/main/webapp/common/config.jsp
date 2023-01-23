
<%@page import="com.raghsonline.miniprojects.tms.util.AppUtil"%>
<%@page import="com.raghsonline.miniprojects.tms.util.EmailConfigUtil"%>
<%@page import="com.raghsonline.miniprojects.tms.util.ConfigFile"%>
<%@page import="java.util.List"%>
<%@page import="java.io.IOException"%>
<%@page import="com.raghsonline.miniprojects.tms.util.PropertyUtil"%>
<%@include file="../inc/header.jsp" %>
	<h3 class="text-center">Config Values</h3>
	<p class="lead">
		The centralized configuration values/flags that control the execution flow, are given below.
	</p>
	<div class="row">
		<table class="table table-striped table-hover table-bordered 
						table-responsive caption-top">
			<caption>Configuration Parameters</caption>
			<%	int slNo = 1; %>
			<thead>
				<tr>
					<th>No</th>
					<th>Property / Flag</th>
					<th>Value</th>
				</tr>				
			</thead>
			<tbody class="table-group-divider">
				<tr>
					<td><%= slNo++ %></td>
					<td>GRC (Global Readiness Check) - Verify Email during Server Startup ?</td>
					<td><%= AppUtil.isAppGRCEmailEnabled %></td>
				</tr>
				<tr>
					<td><%= slNo++ %></td>
					<td>App Dev Mode?</td>
					<td><%= AppUtil.isAppDevMode %></td>
				</tr>
				<tr>
					<td><%= slNo++ %></td>
					<td>DB Ready?</td>
					<td><%= AppUtil.isDBReady %></td>
				</tr>
				<tr>
					<td><%= slNo++ %></td>
					<td>App Ready? (Obvious)!!!</td>
					<td><%= AppUtil.isAppReady %></td>
				</tr>																
				<tr>
					<td><%= slNo++ %></td>
					<td>Email Sending Flag</td>
					<td><%= EmailConfigUtil.canSendEmail() %></td>
				</tr>				
			</tbody>
		</table>
	</div>
	<h3 class="text-center">Path Info</h3>
	<p class="lead">
		The actual file path (location) of the Configuration files used in the TMS Application are given below for a quick reference.
	</p>
	<%
		List<ConfigFile> configFileList = PropertyUtil.getConfigFileList();
				
		if(configFileList.size() <= 0 ) 
		{
	%>
			<div class="row">
				<div class="col-12" align="center">
					<div class="alert alert-danger" role="alert">
					  	No details to display. Please check whether there are any config. files present in the Project, and they are accessible.
					</div>
				</div>
			</div>	
	<% 
		}
		else
		{
	%>	
			<div class="row">
				<table class="table table-striped table-hover table-bordered 
								table-responsive caption-top">
					<caption>Config. File Location</caption>
					<thead>
						<tr>
							<th>No</th>
							<th>File</th>
							<th>Absolute Path</th>
						</tr>				
					</thead>
					<tbody class="table-group-divider">
	<%					
						slNo = 1;
						for(ConfigFile configFile : configFileList)
						{
	%>
							<tr>
								<td><%= slNo++ %></td>
								<td><%= configFile.getFileName() %></td>
								<td><%= configFile.getAbsolutePath()%></td>
							</tr>
	<% 
						}
						
	%>
					</tbody>
				</table>
			</div>
	<% 	
		}
	%>
<%@include file="../inc/footer.jsp" %>