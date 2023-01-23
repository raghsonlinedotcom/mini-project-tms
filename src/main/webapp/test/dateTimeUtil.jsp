<%@page import="com.raghsonline.miniprojects.tms.util.DateUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat, java.time.LocalDate, java.time.LocalDateTime"%>
<%@include file="../inc/header.jsp" %>
		<h1>Date Time in JSP</h1>
		<p>
			Below are the sample values converted to and from a String representation
			to the Date (java.util, java.sql, java.time.LocalDate) and the Timestamp
			(java.sql.Timestamp, java.time.LocalDateTime) etc., using an Utility class
			defined <b>DateUtil</b> in the package <code>com.raghsonline.miniprojects.tms.util</code>
		</p>
		<%!String pattern = DateUtil.PATTERN;
			String patternWithTime = DateUtil.PATTERN_WITH_TIME;
		%>
		<h2>Java Util Date</h2>
		<ol>
			<li>
				Current Date and Time : <%= new java.util.Date() %>
			</li>
			<li>
				Formatted Date and Time (YYYY-MM-DD) : <%= DateUtil.getFormattedDate(pattern) %>
			</li>
			<li>
				Formatted Date and Time (YYYY-MM-DD HH:mm:ss) : <%= DateUtil.getFormattedDate(patternWithTime) %>
			</li>
		</ol>
		<h2>Local Date</h2>
		<ol>
			<li>
				Current Date (LocalDate) : <%= LocalDate.now() %>
			</li>
		</ol>
		<h2>Local Date Time</h2>
		<ol>
			<li>
				Current Date and Time (LocalDateTime) : <%= LocalDateTime.now() %>
			</li>
		</ol>
		<h2>Java SQL Date, TimeStamp</h2>
		<ol>
			<%
				Date utilDate = new java.util.Date();
				long timestampValue = utilDate.getTime();
				
				java.sql.Date sqlDate = new java.sql.Date(timestampValue);
				java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(timestampValue);
			%>
			<li>
				Current Date : 
					<%-- <%= new java.sql.Date(new java.util.Date().getTime()) |   --%>
					<%= sqlDate %> is of type <%= sqlDate.getClass().getName() %>
			</li>
			<li>
				Current Date and Time : 
					<%-- <%= new java.sql.Timestamp(new java.util.Date().getTime()) | --%> 
					<%= sqlTimestamp %> is of type <%= sqlDate.getClass().getName() %>
			</li>			
		</ol>
		<h2>Explicit Date Parsing</h2>
		<ol>
			<%
				Date dateObj = DateUtil.getParsedDate(pattern, "2023-01-01");
				String dateInString = DateUtil.getFormattedDate(dateObj, pattern);
				
				Date dateObj2 = DateUtil.getParsedDate(pattern, "2022-04-13");
				String dateInString2 = DateUtil.getFormattedDate(dateObj2, pattern);
				
				Date dateObj3 = DateUtil.getParsedDate(pattern, "2022-05-09");
				String dateInString3 = DateUtil.getFormattedDate(dateObj3, pattern);
			%>
			<li>
				Date in String <b>01 Jan 2023</b> converted to a Date object : <%= dateObj %> | <%= dateInString %>
			</li>
			<li>
				Date in String <b>13 Apr 2022</b> converted to a Date object : <%= dateObj2 %> | <%= dateInString2 %>
			</li>
			<li>
				Date in String <b>09 May 2022</b> converted to a Date object : <%= dateObj3 %> | <%= dateInString3 %>
			</li>						
		</ol>
		<h2>Explicit Date and Time Parsing</h2>
		<ol>
			<%
				Date dateTimeObj = DateUtil.getParsedDate(patternWithTime, "2023-01-01 17:25:27");
				String dateTimeInString = DateUtil.getFormattedDate(dateTimeObj, patternWithTime);
				
				Date dateTimeObj2 = DateUtil.getParsedDate(patternWithTime, "2022-04-13 10:30:10");
				String dateTimeInString2 = DateUtil.getFormattedDate(dateTimeObj2, patternWithTime);
				
				Date dateTimeObj3 = DateUtil.getParsedDate(patternWithTime, "2022-05-09 09:00:12");
				String dateTimeInString3 = DateUtil.getFormattedDate(dateTimeObj3, patternWithTime);
			%>
			<li>
				Date in String <b>01 Jan 2023</b> converted to a Date object : <%= dateTimeObj %> | <%= dateTimeInString %>
			</li>
			<li>
				Date in String <b>13 Apr 2022</b> converted to a Date object : <%= dateTimeObj2 %> | <%= dateTimeInString2 %>
			</li>
			<li>
				Date in String <b>09 May 2022</b> converted to a Date object : <%= dateTimeObj3 %> | <%= dateTimeInString3 %>
			</li>						
		</ol>		
<%@include file="../inc/footer.jsp" %>		