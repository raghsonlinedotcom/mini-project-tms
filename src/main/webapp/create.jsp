<%@page import="com.raghsonline.miniprojects.tms.bo.EmployeeBO"%>
<%@page import="com.raghsonline.miniprojects.tms.dao.EmployeeDAO"%>
<%@page import="com.raghsonline.miniprojects.tms.dao.EmployeeDAOImpl"%>
<%@ page import="java.util.List, java.util.ArrayList , java.util.Date" %>
<%@page import="com.raghsonline.miniprojects.tms.util.AppUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.raghsonline.miniprojects.tms.util.AppUtil"%>
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
			
			<%!
				int empId = 0; /* Default, for PROD */
				String firstName = "";
				String lastName = "";
				Date dob = null;
				char gender = ' ';
				String aadharId = "";
				String bloodGroup = "";
				String city = "";
				String personalEmail = "";
				String officialEmail = "";
				String password = "";
				String primaryContactNumber = "";
				String secondaryContactNumber = "";
				String highestQualification = "";
				String skillsets = "";
				Date doj = null;
				String hobbies = "";
				int managerId = 0;
				
			%>
			<%
				EmployeeDAO employeeDAO = new EmployeeDAOImpl();
				List<EmployeeBO> managerList = employeeDAO.viewManagers();
				
				//we send the parameter as 'message' only even for the error message. 
				// for the successful cases it is redirected to the `login.jsp` page
				String errorMessage = (String) request.getAttribute("message");
			 	EmployeeBO employeeBO = (EmployeeBO) request.getAttribute("employeeForm");
				
			
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
			
			 	String errorMsgUI = (String) request.getAttribute("errorMsgUI");
			 	
				boolean isValidationError = false;
				
			 	if(null!=errorMsgUI) 
			 	{
			 		isValidationError = true;
			 %>
			 		<h3>Validation Error(s)</h3>
					<div class="row">
						<div class="col-12" align="center">
							<div class="alert alert-danger" role="alert">
							  	<%= errorMsgUI %>
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
		
			if(isValidationError || null!=errorMessage) /* If there was an error, use this */
			{
				empId = employeeBO.getEmpId();
				firstName = employeeBO.getFirstName();
				lastName = employeeBO.getLastName();
				dob = employeeBO.getDateOfBirth();
				gender = employeeBO.getGender();
				aadharId = employeeBO.getAadharId();
				bloodGroup = employeeBO.getBloodGroup();
				city = employeeBO.getCity();
				personalEmail = employeeBO.getPersonalEmail();
				officialEmail = employeeBO.getOfficialEmail();
				password = employeeBO.getPassword();
				primaryContactNumber = employeeBO.getPrimaryContactNo();
				secondaryContactNumber = employeeBO.getSecondaryContactNo();
				highestQualification = employeeBO.getHighestQualification();
				skillsets = employeeBO.getSkillsets();
				doj = employeeBO.getDateOfJoining();
				hobbies = employeeBO.getHobbies();
				managerId = employeeBO.getManagerId();
			}
			else if(isAppDevMode) /* If no error, but Dev Mode, then use this */
			{
				Date dob1 = new Date(1999-11-13);
				Date doj1 = new Date(2022-04-13);
				empId = 137;
				firstName = "Arun";
				lastName = "Prasad";
				dob = dob1;
				gender = 'M'; 
				aadharId = "123456789012";
				bloodGroup = "selected";
				city = "Kakinada";
				personalEmail = "Arun@123gmail.com";
				officialEmail = "Arun@Office.com";
				password = "Arun@123";
				primaryContactNumber = "7274767870";
				secondaryContactNumber = "9193959799"; //Optional Value
				highestQualification = "BTech";
				skillsets = "Java, SQL, HTML, CSS";
				doj = doj1;
				hobbies = "Playing Cricket,Listening to Music,Gardening"; //Optional Value
				managerId = 140;
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
								value='<%= dob %>'
								required/>
						</td>
					</tr>
					<tr>
	                    <td>Gender <span class="required">*</span></td>
	                    <td>	                    	
     						<div class="form-check">
							  <input class="form-check-input" type="radio" name="gender" 
							  		id="genderM" value="M" onclick="changeGender();"
							  		<%= gender == 'M' ? "checked" : "" %>>
							  <label class="form-check-label" for="genderM">
							    Male
							  </label>
							</div>
							<div class="form-check">
							  <input class="form-check-input" type="radio" name="gender" 
							  		id="genderF" value="F" onclick="changeGender();"
							  		<%= gender == 'F' ? "checked" : "" %> >
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
								value='<%= aadharId %>' 
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
			                    <option value="A+ve" <%= bloodGroup.equals("A+ve") ? "selected" : "" %> >A+ve</option>
			                    <option value="O+ve" <%= bloodGroup.equals("O+ve") ? "selected" : "" %> >O+ve</option>
			                    <option value="B+ve" <%= bloodGroup.equals("B+ve") ? "selected" : "" %> >B+ve</option>
			                    <option value="AB+ve" <%= bloodGroup.equals("AB+ve") ? "selected" : "" %> >AB+ve</option>
			                    <option value="A-ve" <%= bloodGroup.equals("A-ve") ? "selected" : "" %> >A-ve</option>
			                    <option value="O-ve" <%= bloodGroup.equals("O-ve") ? "selected" : "" %> >O-ve</option>
			                    <option value="B-ve" <%= bloodGroup.equals("B-ve") ? "selected" : "" %> >B-ve</option>
			                    <option value="AB-ve" <%= bloodGroup.equals("AB-ve") ? "selected" : "" %>>AB-ve</option> 
			                </select>
                   		</td>
	                </tr>
	                <tr>
	                    <td>City <span class="required">*</span></td>
	                    <td>
	                    	<input type="text" class="form-control"  
	                    	id="city" name="city" placeholder="city" 
	                    	size="20"   maxlength="20" 
	                    	value='<%= city %>'
	                    	required>
	                    </td>
	                </tr>
					<tr>
	                    <td>PersonalEmail <span class="required">*</span></td>
	                    <td>
	                    	<input type="Email" class="form-control" 
	                    	id="personalEmail" name="personalEmail" 
		                    size="40"  placeholder="abc@gmail.com" 
		                    value='<%= personalEmail %>'  
		                    maxlength="40" required>
	                    </td>
	                </tr>
	                <tr>
	                    <td>OfficialEmail <span class="required">*</span></td>
	                    <td><input type="Email" class="form-control" 
	                    id="officialEmail" name="officialEmail" 
	                    size="40"  placeholder="abc.de@milvik.se"  
	                    value='<%= officialEmail %>' 
	                    maxlength="40" required>
	                    </td>
	                </tr>
	                <tr>
	                    <td>Password <span class="required">*</span></td>
	                    <td>
	                    	<input type="password" class="form-control" 
	                    	id="password" name="password" 
	                    	pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" size="15" 
	                    	value='<%= password %>' 
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
								value='<%= primaryContactNumber %>'
								required >
						</td>
					</tr>
					<tr>
						<td>Secondary Contact Number</td>
						<td>
							<input type="number" class="form-control" 
								id="secondaryContactNumber" 
								name="secondaryContactNumber" 
								value='<%= secondaryContactNumber %>'
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
								value='<%= highestQualification %>' 
								maxlength="35">
						</td>
					</tr>
					<tr>
						<td>Skill Sets <span class="required">*</span></td>
						<td>
						<textarea class="form-control" rows="4" cols="50"  
								id="skillSets" name="skillSets" 
								placeholder="Java, MySQL, HTML, CSS" maxlength="100"								  
								required><%= skillsets %></textarea>						
						</td>
					<tr>
						<td>Date Of Joining <span class="required">*</span></td>
						<td>
							<input type="date" class="form-control" 
								id="doj" name="doj" 
								value='<%= doj %>'
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
                       		 	value='<%= hobbies %>'
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
                       		id="managerId" name="managerId" required>
                       		<option disabled selected value> -- SELECT -- </option>
                       			<%
                       				for(EmployeeBO managerBO : managerList)
                						{
                       			%>
                							<option value = "<%=managerBO.getEmpId()%>" > 
                								<%=
                									managerBO.getEmpId() + " | " + 
                							        managerBO.getFirstName() + " " +
                									managerBO.getLastName() 
                								 %>
                							</option>
                				<% 
                						}	
                       			%>
                       			<option value="0">N/A</option>
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