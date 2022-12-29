
<%@page import="com.tutorials.tms.util.ConfigFile"%>
<%@page import="java.util.List"%>
<%@page import="java.io.IOException"%>
<%@page import="com.tutorials.tms.util.PropertyUtil"%>
<%@include file="../inc/header.jsp" %>
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
						int slNo = 1;
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