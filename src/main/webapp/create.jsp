<%@page import="com.tutorials.tms.bo.EmployeeBO"%>
<%@page import="com.tutorials.tms.util.AppUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.tutorials.tms.util.AppUtil"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>TMS | Registration Page</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="<%=request.getContextPath()%>/lib/bootstrap-5.2.3-dist/css/bootstrap.min.css"
			rel="stylesheet">
	   	<!--  custom CSS should come later  -->
	    <link rel="stylesheet" href="<%=request.getContextPath()%>/inc/style.css"/>
	    <!-- Custom styles for this template -->
    	<link rel="stylesheet" href="<%=request.getContextPath()%>/inc/sticky-footer-navbar.css"/>
    	<script type="text/javascript">
		 function changeGender()
	      {
	        var gender = document.getElementsByName('gender');
	        //console.dir(gender);
	        var genderValue;
	        for(var i = 0; i < gender.length; i++){
	            if(gender[i].checked){
	                genderValue = gender[i].id;
	            }
	        }
	        console.log("(generic) selected gender : " + genderValue);
	      }
		 </script>
	</head>
	<body class="d-flex flex-column h-100">
		<!-- Begin page content -->
		<main class="flex-shrink-0">
			<div class="container"> <!--  Container Div Start -->
			<%
				//we send the parameter as 'message' only even for the error message. 
				// for the successful cases it is redirected to the `login.jsp` page
				String errorMessage = (String) request.getAttribute("message");
			
				if(null!=errorMessage) {
			%>					
					<div class="row">
						<div class="col-12" align="center">
							<div class="alert alert-danger" role="alert">
							  	<%= errorMessage %>
							</div>
						</div>
					</div>						
			<%
				}
			
			 	String errorMsg = (String) request.getAttribute("errorMsgUI");
			 	EmployeeBO employeeBO = (EmployeeBO) request.getAttribute("employeeForm");
			 	
				boolean isValidationError = false;
				
			 	if(null!=errorMsg) 
			 	{
			 		isValidationError = true;
			 %>
			 		<h3>Validation Error(s)</h3>
					<div class="row">
						<div class="col-12" align="center">
							<div class="alert alert-danger" role="alert">
							  	<%= errorMsg %>
							</div>
						</div>
					</div>			 		
			 <% 
			 	}
			 %>
		<h2>Employee Registration Form</h2>
		<p class="lead">
		 	Please fill the necessary details to register yourself. 
		 	The items marked in red asterisk are mandatory.
		</p>
		<br>
		<%
			boolean isAppDevMode = AppUtil.isAppDevMode;
		
			int empId = 0; /* Default, for PROD */
			String firstName = "";
			String lastName = "";
					
			if(isValidationError) /* If there was an error, use this */
			{
				empId = employeeBO.getEmpId();
				firstName = employeeBO.getFirstName();
				lastName = employeeBO.getLastName();
			}
			else if(isAppDevMode) /* If no error, but Dev Mode, then use this */
			{
				empId = 137;
				firstName = "Arun";
				lastName = "Prasad";
			}
		%>
		<form id="create" name="create" action="EmployeeCreate" method="post" >
			<table class="table table-striped table-hover table-bordered 
				table-responsive caption-top">
  				<caption>Registration Details</caption>
				<thead>
					<tr>
						<th>Field</th>
						<th>Value</th>
					</tr>				
				</thead>
				<tbody class="table-group-divider">
					<tr>
						<td>EmployeeId <span class="required">*</span></td>
						<td>
							<input type="number" class="form-control" id="empId" 
								name="empId" size="10" min = "1"
								placeholder="121" required size="20"
								value='<%= empId %>' >									
						</td>
					</tr>
					<tr>
						<td>First Name <span class="required">*</span></td>
						<td>
							<input type="text" class="form-control"  id="firstName" name="firstName"  
								placeholder="Arun" size="20" maxlength="20" 
								value='<%= firstName %>' 
								required>
						</td>
					</tr>
					<tr>
						<td>Last Name <span class="required">*</span></td>
						<td>
							<input type="text" class="form-control" id="lastName" name="lastName"  
								placeholder="Gubbala" size="20"   
								maxlength="20" 
								value='<%= lastName %>' 
								required >
						</td>
					</tr>
					<tr>
						<td>Date Of Birth <span class="required">*</span></td>
						<td>
							<input type="date" class="form-control"  id="dob" name="dob" 
								min="1960-01-01" max="2004-01-01"  
								value='<%= isAppDevMode ? "1999-11-13" : "" %>'
								required/>
						</td>
					</tr>
					<tr>
	                    <td>Gender <span class="required">*</span></td>
	                    <td>	                    	
     						<div class="form-check">
							  <input class="form-check-input" type="radio" name="gender" 
							  		id="genderM" value="M" onclick="changeGender();"
							  		<%= isAppDevMode ? " checked" : "" %>>
							  <label class="form-check-label" for="genderM">
							    Male
							  </label>
							</div>
							<div class="form-check">
							  <input class="form-check-input" type="radio" name="gender" 
							  		id="genderF" value="F" onclick="changeGender();">
							  <label class="form-check-label" for="genderF">
							    Female
							  </label>
							</div>
	                    </td>
                	</tr>
					<tr>
						<td>AadharId <span class="required">*</span></td>
						<td>
							<input type="number" class="form-control" id="aadharId" name="aadharId" size="12" 
								placeholder="123456789012" maxlength="12"
								value='<%= isAppDevMode ? "123456789012" : "" %>' 
								required>
						</td>
					</tr>
	                <tr>
	                	<td>
                       		 BloodGroup <span class="required">*</span>
                    	</td>
                   		<td>
                       		 <select class="form-select" aria-label=".select example"
                       		 		name="bloodGroup" id="bloodGroup" required>
                       		  	<option value='' selected >Select an Option</option>
			                    <option value="A+ve" <%= isAppDevMode ? "selected" : "" %> >A+ve</option>
			                    <option value="O+ve">O+ve</option>
			                    <option value="B+ve">B+ve</option>
			                    <option value="AB+ve">AB+ve</option>
			                    <option value="A-ve">A-ve</option>
			                    <option value="O-ve">O-ve</option>
			                    <option value="B-ve">B-ve</option>
			                    <option value="AB-ve">AB-ve</option> 
			                </select>
                   		</td>
	                </tr>
	                <tr>
	                    <td>City <span class="required">*</span></td>
	                    <td>
	                    	<input type="text" class="form-control"  
	                    	id="city" name="city" placeholder="city" 
	                    	size="20"   maxlength="20" 
	                    	value='<%= isAppDevMode ? "Kakinada" : "" %>'
	                    	required>
	                    </td>
	                </tr>
					<tr>
	                    <td>PersonalEmail <span class="required">*</span></td>
	                    <td>
	                    	<input type="Email" class="form-control" 
	                    	id="personalEmail" name="personalEmail" 
		                    size="40"  placeholder="abc@gmail.com" 
		                    value='<%= isAppDevMode ? "arun@gmail.com" : "" %>'  
		                    maxlength="40" required>
	                    </td>
	                </tr>
	                <tr>
	                    <td>OfficialEmail <span class="required">*</span></td>
	                    <td><input type="Email" class="form-control" 
	                    id="officialEmail" name="officialEmail" 
	                    size="40"  placeholder="abc.de@milvik.se"  
	                    value='<%= isAppDevMode ? "arun@office.com" : "" %>' 
	                    maxlength="40" required>
	                    </td>
	                </tr>
	                <tr>
	                    <td>Password <span class="required">*</span></td>
	                    <td>
	                    	<input type="password" class="form-control" 
	                    	id="password" name="password" 
	                    	pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" size="15" 
	                    	value='<%= isAppDevMode ? "Arun@123" : "" %>' 
	                    	placeholder="password" maxlength="15" 
	                    	required aria-describedby="pwdPattern">
    						<div id="pwdPattern" class="form-text">
    							At least one number, lowercase, uppercase and a special character with the length of 6 to 15.
    						</div>
	                    </td>
	                </tr>
					<tr>
						<td>Primary Contact Number <span class="required">*</span></td>
						<td>
							<input type="number" class="form-control" 
								id="primaryContactNumber" 
								name="primaryContactNumber" 
								placeholder="1234567890" size="10"  maxlength="10" 
								value='<%= isAppDevMode ? "7288822559" : "" %>'
								required >
						</td>
					</tr>
					<tr>
						<td>Secondary Contact Number</td>
						<td>
							<input type="number" class="form-control" 
								id="secondaryContactNumber" 
								name="secondaryContactNumber" 
								placeholder="1234567890" size="10"  maxlength="10" >
						</td>
					</tr>
					<tr>
						<td>Highest Qualification <span class="required">*</span></td>
						<td>
							<input type="text" class="form-control" 
								id="highestQualification" 
								name="highestQualification" 
								placeholder="MTech, MS, MBA etc.," required size="35" 
								value='<%= isAppDevMode ? "BTech" : "" %>' 
								maxlength="35">
						</td>
					</tr>
					<tr>
						<td>Skill Sets <span class="required">*</span></td>
						<td>
						<textarea class="form-control" rows="4" cols="50"  
								id="skillSets" name="skillSets" 
								placeholder="Java, MySQL, HTML, CSS" maxlength="100"								  
								required><%= isAppDevMode ? "Java, SQL, HTML, CSS" : "" %></textarea>						
						</td>
					<tr>
						<td>Date Of Joining <span class="required">*</span></td>
						<td>
							<input type="date" class="form-control" 
								id="doj" name="doj" 
								value='<%= isAppDevMode ? "2022-04-13" : "" %>'
								required/>
						</td>
					</tr>
					<tr>
	                	<td>
                       		 Hobbies 
                    	</td>
                   		<td>
                       		 <input type="text" class="form-control" 
                       		 	id="hobbies" name="hobbies" 
                       		 	placeholder="Reading Books, Listening to Music, Playing Cricket etc.," 
                       		 	size="100" maxlength="100" 
                       		 	aria-describedby="hobbiesHelp">
	    						<div id="hobbiesHelp" class="form-text">
	    							Mention your extra curricular activities if any.
	    						</div>
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 Manager Id <span class="required">*</span>
                    	</td>
                   		<td>
                       		<select class="form-select" aria-label=".select example"
                       			id="managerId" name="managerId">
                       			<option id="1" value="0">N/A</option>
                       			<option id="1" value="1" selected>Raghavan</option>
                       		</select>
                   		</td>
	                </tr>
					<tr>
						<td colspan="2">							
							<input class="btn btn-primary" type="submit" value="Create"/>
							<input class="btn btn-outline-danger" type="reset" value="Reset"/>
						</td>
					</tr>				
				</tbody>
			</table>
		</form>
<%@include file="inc/footer.jsp" %>