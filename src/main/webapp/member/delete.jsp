<%@page import="com.raghsonline.miniprojects.tms.bo.EmployeeBO"%>
<%@include file="../inc/header.jsp" %>
<script>
function changeDecision()
{
  var decision = document.getElementsByName('decision');
  var decisionValue;
  for(var i = 0; i < decision.length; i++){
      if(decision[i].checked){
    	  decisionValue = decision[i].value;
      }
  }
  console.log("(generic) selected decision : " + decisionValue);
}

</script>
<%
			//String message = (String) request.getAttribute("message");
			EmployeeBO employeeBO = (EmployeeBO) session.getAttribute("employeeBO");
			String firstName = employeeBO.getFirstName();
			String lastName = employeeBO.getLastName();
			
%>	
	<h1>Delete your Employee Profile</h1>
	<p><b>Oh No <%= firstName + " " + lastName%>! We would not like to lose you.</b></p>
		<form id="deleteForm" name="DeleteMyProfileForm" action="<%=request.getContextPath()%>/DeleteEmployee" method="post">
			<table class="table table-striped table-hover table-bordered 
							table-responsive caption-top">
				<caption>Delete my Profile</caption>
				<thead>	
						<tr>
							<th>Select <b>"Yes"</b> if you still want to delete your profile, or <b>"No"</b> to go back to your home page</th>
						</tr>
				</thead>
						<tr>
							<td>
								<div class="form-check">
										  <input class="form-check-input" type="radio" name="decision" 
										  		id="Yes" value="Yes" onclick="changeDecision();"
										  		>
										  <label class="form-check-label" for="Yes">
										    Yes
										  </label>
								</div>
								<div class="form-check">
										  <input class="form-check-input" type="radio" name="decision" 
										  		id="No" value="No" onclick="changeDecision();">
										  <label class="form-check-label" for="genderF">
										    No
										  </label>
								</div>
							</td>
						</tr>
							
						<tr>
								<td colspan="2">
									 <input class="btn btn-primary" type="submit" value="Submit"/>
									 <input class="btn btn-outline-danger" type="reset" value="Reset"/>
								</td>
						</tr>	
					
			</table>
		</form>
		
<%@include file="../inc/footer.jsp" %>