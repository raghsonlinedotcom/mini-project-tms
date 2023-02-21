<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat, java.time.LocalDate, java.time.LocalDateTime"%>
<%@include file="../inc/header.jsp" %>
 <link rel="stylesheet" href="<%=request.getContextPath()%>/inc/style.css"/>
		<h1>Date Time in JSP</h1>
		
		<%!
			public String getFormattedDate(String pattern)
			{				
				return getFormattedDate(new java.util.Date(), pattern);
			}
			
			public String getFormattedDate(Date dateObj, String pattern)
			{
				SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				String currentDateStr = null;
				
				try {
					currentDateStr = sdf.format(dateObj);
				}catch(Exception exception) {
					currentDateStr = "Exception";
				}
				
				return currentDateStr;
			}
		
			String pattern = "yyyy-MM-dd";
			String patternWithTime = "yyyy-MM-dd HH:mm:ss";
			
			public Date getParsedDate(String pattern, String dateStr)
			{
				SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				Date dateObj = null;
				
				try {
					dateObj = sdf.parse(dateStr);
				}catch(Exception exception) {
					dateObj = null;
				}
				
				return dateObj;
			}
			
		%>
		<h2>Java Util Date</h2>
		<ol>
			<li>
				Current Date and Time : <%= new java.util.Date() %>
			</li>
			<li>
				Formatted Date and Time (YYYY-MM-DD) : <%= getFormattedDate(pattern) %>
			</li>
			<li>
				Formatted Date and Time (YYYY-MM-DD HH:mm:ss) : <%= getFormattedDate(patternWithTime) %>
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
				Date dateObj = getParsedDate(pattern, "2023-01-01");
				String dateInString = getFormattedDate(dateObj, pattern);
				
				Date dateObj2 = getParsedDate(pattern, "2022-04-13");
				String dateInString2 = getFormattedDate(dateObj2, pattern);
				
				Date dateObj3 = getParsedDate(pattern, "2022-05-09");
				String dateInString3 = getFormattedDate(dateObj3, pattern);
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
				Date dateTimeObj = getParsedDate(patternWithTime, "2023-01-01 17:25:27");
				String dateTimeInString = getFormattedDate(dateTimeObj, patternWithTime);
				
				Date dateTimeObj2 = getParsedDate(patternWithTime, "2022-04-13 10:30:10");
				String dateTimeInString2 = getFormattedDate(dateTimeObj2, patternWithTime);
				
				Date dateTimeObj3 = getParsedDate(patternWithTime, "2022-05-09 09:00:12");
				String dateTimeInString3 = getFormattedDate(dateTimeObj3, patternWithTime);
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