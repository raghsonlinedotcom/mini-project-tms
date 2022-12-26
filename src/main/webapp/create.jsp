<%@page import="com.tutorials.tms.bo.EmployeeBO"%>
<%@include file="header.jsp" %>
<%@page import="com.tutorials.tms.util.AppUtil"%>
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
		 <%
		 	String errorMsg = (String) request.getAttribute("errorMsgUI");
		 	EmployeeBO employeeBO = (EmployeeBO) request.getAttribute("employeeForm");
		 	
			boolean isValidationError = false;
			
		 	if(null!=errorMsg) 
		 	{
		 		isValidationError = true;
		 %>
		 		<h3>Validation Error(s)</h3>
		 		<div class="errorMsg"><%= errorMsg %></div>
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
							  		id="genderM" onclick="changeGender();"
							  		<%= isAppDevMode ? " checked" : "" %>>
							  <label class="form-check-label" for="genderM">
							    Male
							  </label>
							</div>
							<div class="form-check">
							  <input class="form-check-input" type="radio" name="gender" 
							  		id="genderF" onclick="changeGender();">
							  <label class="form-check-label" for="genderF">
							    Female
							  </label>
							</div>
							
							<!-- <div class="input-group mb-3">
							  <div class="input-group-text">
							    <input class="form-check-input mt-0" type="checkbox" 
							    	value="" aria-label="Checkbox for following text input">
							  </div>
							  <input type="text" class="form-control" 
							  	aria-label="Text input with checkbox">
							</div>
							
							<div class="input-group">
							  <div class="input-group-text">
							    <input class="form-check-input mt-0" type="radio" value="" 
							    	aria-label="Radio button for following text input">
							  </div>
							  <input type="text" class="form-control" 
							  	aria-label="Text input with radio button">
							</div>-->
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
	                    	id="persoalEmail" name="persoalEmail" 
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
						<!-- <div class="input-group">
						  <span class="input-group-text">Skillsets</span> 
						  <textarea class="form-control" aria-label="With textarea" 
						  		rows="4" cols="50"  id="skillSets" name="skillSets" 
								placeholder="java,mysql,html,css" maxlength="100"								  
								required></textarea>
						</div>-->
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
                       			<!-- <option id="-1" value="--Select--">--- Select ---</option>
                       			<option id="1" value="1" selected>Raghavan</option>
                       			<option id="2" value="2">Dev</option>
                       			<option id="3" value="3">Balaji</option> -->
                       			<option id="1" value="0">N/A</option>
                       			<option id="1" value="1" selected>Raghavan</option>
                       		</select>
                   		</td>
	                </tr>
					<tr>
						<td colspan="2">
							<!-- <input type="submit" name="Create" Value="Create"/> -->
							<input class="btn btn-primary" type="submit" value="Create">
							<input class="btn btn-outline-danger" type="reset" value="Reset">
						</td>
					</tr>				
				</tbody>
			</table>
		</form>
<%@include file="footer.jsp" %>