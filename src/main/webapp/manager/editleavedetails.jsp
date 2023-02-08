<%@page import="com.raghsonline.miniprojects.tms.bo.LeaveDetailBO"%>
<%@include file="../inc/header.jsp" %>
<script type="text/javascript">
function validate()
{    
 var status = document.getElementById('status').value;    
    if (status == "Rejected") {
        if (document.getElementById("actionComment").value == "") {
            alert('Please specify the reason for Rejection');
            return false;
        }

    }
    return true;
}

</script>
 <link rel="stylesheet" href="<%=request.getContextPath()%>/inc/style.css"/>
		<h1>Edit Leave Details</h1>
		
		<%
			LeaveDetailBO leaveDetailBO = (LeaveDetailBO) request.getAttribute("leaveDetailBO");
		%>
		<%
			String message = (String) request.getAttribute("message");			
			
			String exceptionMsg = (String) request.getAttribute("exceptionMsg");
			
			String errorMsg = (String) request.getAttribute("errorMsg");
			
			String errorMsgUI = (String) request.getAttribute("errorMsgUI");
			
			if(null!=message) {
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
			if(null!=exceptionMsg) {
				
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
			
			if(null!=errorMsg) {
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
			if(null!=errorMsgUI) {
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
			
			if(null==leaveDetailBO) {
		%>
				<div class="errorMsg">No Leave Details available to edit!</div>
		<%		
			} else {
		%>	
			<form id="updateForm" name="UpdateForm" onsubmit="return validate()"
			method="post" action="<%=request.getContextPath()%>/UpdateMyTeamsLeave">
				<table class="table table-striped table-hover table-bordered 
				table-responsive caption-top">	
					<tbody>	
						<tr>
							<td>Id</td>
							<td>
								${leaveDetailBO.id}
								<input type="hidden" name="id"  
								value="${leaveDetailBO.id}" />
							</td>		
						</tr>
						<tr>
							<td>Employee Id<span class="required">*</span></td>
							<td>
								${leaveDetailBO.empId}
								<input type="hidden"  name="empId" 
								value="${leaveDetailBO.empId}"/>
							</td>		
						</tr> 
						<tr>
							<td>Manager Id<span class="required">*</span></td>
							<td>
								<input readonly class="form-control"  
								id="managerId" name="managerId"  
								value="${leaveDetailBO.managerId}" required />
							</td>
						</tr>
						<tr>
							<td>From Date<span class="required">*</span></td>
							<td>
								<input readonly class="form-control" 
								id="fromDate" name="fromDate"  
								value="${leaveDetailBO.fromDate}" required />
								</td>
						</tr>
						<tr>
							<td>To Date<span class="required">*</span></td>
							<td>
								<input readonly class="form-control" 
								id="toDate" name="toDate" 
								value="${leaveDetailBO.toDate}" required/>
							</td>
						</tr>
						<tr>
							<td>Leave Reason<span class="required">*</span></td>
							<td>
								<input readonly class="form-control" 
								id="leaveReason" name="leaveReason"
								value="${leaveDetailBO.leaveReason}" required/>
								</td>
						</tr>
						<tr>
							<td> Status<span class="required">*</span></td>
							<td>
								<select class="form-select" 
								aria-label=".select example" name="status" 
								id="status" onchange ="validate()" required>
                       		  	<option value="${leaveDetailBO.status}">
                       		  	${leaveDetailBO.status}</option>
			                    <option value="Approved" >Approve</option>
			                    <option value="Rejected" >Reject</option>
			                	</select>
							</td>
						</tr>
						<tr>
							<td>Action Comment</td>
							<td>
								<textarea class="form-control" rows="4" cols="50"  
								id="actionComment" name="actionComment" 
								placeholder="Your comments" maxlength="100"								  
								aria-describedby="actionCommentCondition">${leaveDetailBO.actionComment}</textarea>
								<div id="actionCommentCondition" class="form-text">
    							Action Comment is Mandatory if the leave is Rejected.
    						</div> 
							</td>
						</tr>
					
						<tr>
							<td>Alternate Contact Number</td>
							<td>
								<input readonly class="form-control" 
	                    		id="altContactNo" name="altContactNo" 
	                    		value="${leaveDetailBO.altContactNo}" required />
							</td>
						</tr>
						<tr>
							<td>Created Date<span class="required">*</span></td>
							<td>
								<input readonly class="form-control" 
								id="createdDate" name="createdDate" 
								value="${leaveDetailBO.createdDate}" required />
							</td>
						</tr>
						<tr>
							<td>Created By<span class="required">*</span></td>
							<td>
								<input readonly class="form-control" 
								id="createdBy" name="createdBy" 
								value="${leaveDetailBO.createdBy}" required/>
						</td>
					</tr>
					<tr>
						<td>Updated Date<span class="required">*</span></td>
						<td>
							<input readonly class="form-control" 
							id="updateddate" name="updatedDate" 
							value="${leaveDetailBO.updatedDate}" required />
						</td>
					</tr>
					
					<tr>
						<td>Updated By<span class="required">*</span></td>
						<td>
							<input readonly class="form-control" 
							id="updatedBy" name="updatedBy"  
							value="${leaveDetailBO.updatedBy}" required />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" name="Update" Value="Update" 
							onclick="validate()"/>
						</td>
					</tr>			
				</tbody>
			</table>
		</form>
		<% 		
			}
		%>
<%@include file="../inc/footer.jsp" %>
