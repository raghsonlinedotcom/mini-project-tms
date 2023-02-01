<%@page import="com.raghsonline.miniprojects.tms.bo.LeaveDetailBO"%>
<%@include file="../../inc/header.jsp" %>

<script type="text/javascript">
function validateDate()
{    
 var fromDate = document.getElementById('fromDate').value;
 var toDate = document.getElementById('toDate').value;
    if (fromDate > toDate) {
            alert('Please Select fromDate Less Than toDate');
            return false;
    	}
    else if (toDate < fromDate) {
	    	alert('Please Select toDate  Greater Than fromDate');
	        return false;
    	}
    return true;
}
</script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/inc/style.css"/>
		<h1>Edit Leave Details</h1>
		<%
			LeaveDetailBO leaveDetailBO = (LeaveDetailBO) request.getAttribute("leaveDetailBO");
			System.out.println("LeaveDetailBO from DB :" + leaveDetailBO);
			if(null==leaveDetailBO) 
			{
				leaveDetailBO = (LeaveDetailBO) session.getAttribute("leaveDetailBO");	
				System.out.println("LeaveDetailBO from session :" + leaveDetailBO);
			}
			System.out.println("LeaveDetailBO from session :" + leaveDetailBO);
		%>
		<%
			String message = (String) request.getAttribute("message");			
			
			String exceptionMsg = (String) request.getAttribute("exceptionMsg");
			
			String errorMsg = (String) request.getAttribute("errorMsg");
			
			String errorMsgUI = (String) request.getAttribute("errorMsgUI");
			
			if(null!=message) 
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
			if(null!=exceptionMsg) 
			{	
		%>
			<div class="row">
				<div class="col-12" align="center">
					 <div class="alert alert-danger" role="alert">
						<%= exceptionMsg %>
					 </div>
				</div>
			</div>		
		<%
			}
			if(null!=errorMsg) 
			{
		%>
			<div class="row">
				<div class="col-12" align="center">
					 <div class="alert alert-danger" role="alert">
						<%= errorMsg %>
					 </div>
				</div>
			</div>		
		<%
			}
			if(null!=errorMsgUI) 
			{
		%>
			<div class="row">
				<div class="col-12" align="center">
					 <div class="alert alert-danger" role="alert">
						<%= errorMsgUI %>
					 </div>
				</div>
			</div>	
		<%
			}
			String Status = leaveDetailBO.getStatus();
			System.out.println("Status :"+ Status);
			if(null==leaveDetailBO)
			{
		%>
			<div class="row">
				<div class="col-12" align="center">
					 <div class="alert alert-danger" role="alert">
						No Leave-Details available to edit!
					 </div>
				</div>
			</div>	
		<%		
			} 
			else if(!Status.equals("OPEN")) 
			{
				if(Status.equals("Canceled")) {
					%>	
					<div class="row">
						<div class="col-12" align="center">
						 	<div class="alert alert-danger" role="alert">
								The Leave Request Has Canceled,So the Leave-Request is NOT available to edit!
						 	</div>
						</div>
					</div>	
					<%
				} else if(Status.equals("Rejected")) {
					%>	
					<div class="row">
						<div class="col-12" align="center">
						 	<div class="alert alert-danger" role="alert">
								The Leave Request Has Rejected,So the Leave-Request is NOT available to edit!
						 	</div>
						</div>
					</div>	
					<%	
				} else if(Status.equals("Approved")) {
					%>	
					<div class="row">
						<div class="col-12" align="center">
						 	<div class="alert alert-danger" role="alert">
								The Leave Request Has Approved,So the Leave-Request is NOT available to edit!
						 	</div>
						</div>
					</div>
					<%
				}
					%>
		<%
			} else {
		%>		
				<form id="updateForm" name="UpdateForm" onsubmit="return validateDate()"
					action="<%=request.getContextPath()%>/UpdateLeave" method="post">
					<table class="table table-striped table-hover table-bordered 
					table-responsive caption-top">
						<tbody>
							<tr>
								<td>Id</td>
								<td>
									<input type="number" name="id" readonly value="${leaveDetailBO.id}" />
								</td>		
							</tr>
							<tr>
								<td>EmployeeId<span class="required">*</span></td>
								<td>
									<input type="number" name="empId" readonly value="${leaveDetailBO.empId}"/>
								</td>		
							</tr>
							<tr>
								<td> Manager Id <span class="required">*</span></td>
								<td>
									<input type="number" name="managerId" readonly value="${leaveDetailBO.managerId}"/>
								</td>
							</tr>
							<tr>
								<td>From Date<span class="required">*</span></td>
								<td>
									<input type="datetime-local" class="form-control"  id="fromDate" name="fromDate" 
										   value="${leaveDetailBO.fromDate}" onchange ="validateDate()"
										   required aria-describedby="fromDateHelp">
				    				<div id="fromDateHelp" class="form-text">
				    					   From date should be less than to date
				    				</div>
								</td>
							</tr>
							<tr>
								<td>To Date<span class="required">*</span></td>
								<td>
									<input type="datetime-local" class="form-control"  id="toDate" name="toDate"  
										   value="${leaveDetailBO.toDate}" onchange ="validateDate()"
										   required aria-describedby="toDateHelp">
				    				<div id="toDateHelp" class="form-text">
				    					   To date should be greater than from date.
				    				</div>
								</td>
							</tr>
							<tr>
								<td>Leave Reason<span class="required">*</span></td>
								<td>
									<input type="text" class="form-control"  id="leaveReason" name="leaveReason"  
										   value="${leaveDetailBO.leaveReason}"
										   required aria-describedby="leaveReasonHelp">
				    				<div id="leaveReasonHelp" class="form-text">
				    					   Mention your reason for applying the Leave.
				    				</div>
								</td>
							</tr>
							<tr>
								<td>Status<span class="required">*</span></td>
								<td>
									<select class="form-select" aria-label=".select example" name="status" 
							          id="status" required>
		                       		  	<option value="${leaveDetailBO.status}">${leaveDetailBO.status}</option>
		                       		  	<option value="OPEN">OPEN</option>
					                    <option value="Canceled">Cancel Leave</option>
					                </select>
								</td>
							</tr>
							<tr>
								<td>Action Comment<span class="required">*</span></td>
								<td>
									<input type="text" class="form-control"  id="actionComment" name="actionComment"  
										   value="${leaveDetailBO.actionComment}"
										   required aria-describedby="actionCommentHelp">
				    				<div id="actionCommentHelp" class="form-text">
				    					   Mention your reason for Action or Update of Leave.
				    				</div>
								</td>
							</tr>
							<tr>
								<td>Alternate Contact Number</td>
								<td>
									<input type="tel" class="form-control" 
										id="altContactNumber" 
										name="altContactNumber" 
										size="10" maxlength="10" value="${leaveDetailBO.altContactNo}"
										aria-describedby="altContactNumberHelp">
				    				<div id="altContactNumberHelp" class="form-text">
				    					Mention your Alternate Contact Number.
				    				</div>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="submit" name="Update" Value="Update"
									onclick="validate()" />
								</td>
							</tr>			
						</tbody>
					</table>
				</form>
		<% 		
			}
		%>
<%@include file="../../inc/footer.jsp" %>