<%@include file="../inc/header.jsp" %>

	<h1>Test Utilities</h1>

	<table class="table table-striped table-hover table-bordered 
		table-responsive caption-top">
		<caption>List of Test Files</caption>
		<thead>
			<tr>
				<th>File Name</th>
				<th>Description</th>
				<th>Link</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>dateTime.jsp</td>
				<td>
					Conversion of Date and Time values with the 
					utility methods defined in the JSP file
				</td>
				<td>
					<a href="dateTime.jsp">dateTime.jsp</a>
				</td>
			</tr>
			<tr>
				<td>dateTime.jsp</td>
				<td>
					Conversion of Date and Time values with the 
					utility methods defined in a separate Util class
					<code>DateUtil</code> defined in the package
				</td>
				<td>
					<a href="dateTimeUtil.jsp">dateTimeUtil.jsp</a>
				</td>
			</tr>			
		</tbody>
	</table>

<%@include file="../inc/footer.jsp" %>