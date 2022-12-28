<%@page import="com.tutorials.tms.bo.EmployeeBO"%>
<%@include file="../inc/header.jsp" %>

		<h1>Edit Profile</h1>
		
		<%
			Object empIdParam = request.getParameter("empId");
			int empId = -1;
			if(null!=empIdParam) {
				empId = Integer.parseInt(empIdParam.toString());
				out.println("Id parameter passed is : " + empId);
			}
		
			EmployeeBO employeeBO= null;
			
			
			employeeBO = (EmployeeBO) request.getAttribute("employeeBO");
			
			
			if(null==employeeBO) {
				employeeBO = (EmployeeBO) session.getAttribute("employeeBO");	
			}		
		%>
		<%
			String message = (String) request.getAttribute("message");			
			
			String exceptionMsg = (String) request.getAttribute("exceptionMsg");
			
			String errorMsg = (String) request.getAttribute("errorMsg");
			
			if(null!=message) {
		%>
				<div class="message">${message}</div>
		<% 
			}
			if(null!=exceptionMsg) {
		%>
				<div class="errorMsg">${exceptionMsg}</div>
		<%
			}
			
			if(null!=errorMsg) {
		%>
				<div class="errorMsg">${errorMsg}</div>
		<%
			}
			
			if(null==employeeBO) {
		%>
				<div class="errorMsg">No Employee available to edit!</div>
		<%		
			} else {
		%>	
				<form id="updateForm" name="UpdateForm" action="<%=request.getContextPath()%>/UpdateEmployee" method="post">
					<table class="table table-striped table-hover table-bordered 
					table-responsive caption-top">
						
						<tbody>	
						<tr>
								<td>Id</td>
								<td>
									${employeeBO.id}
									<input type="hidden" name="id" value="${employeeBO.id}"/>
								</td>		
								</tr>
								<tr>
								<td>EmployeeId</td>
								<td>
									${employeeBO.empId}
									<input type="hidden" name="empId" value="${employeeBO.empId}"/>
								</td>		
								</tr>
							<tr>
								<td>First Name</td>
								<td>
									<input type="text" class="form-control"  id="firstName" name="firstName"  
										placeholder="Your FirstName" value="${employeeBO.firstName}"
										required />
								</td>
							</tr>
							<tr>
								<td>Last Name</td>
								<td>
									<input type="text" class="form-control"  id="lastName" name="lastName"  
										placeholder="Your LastName" value="${employeeBO.lastName}"
										required />
								</td>
							</tr>
							<tr>
								<td>Date Of Birth</td>
								<td>
									<input readonly  type="date" class="form-control"  id="dob" name="dob" 
										min="1960-01-01" max="2004-01-01"  
										placeholder="Your dob" value="${employeeBO.dateOfBirth}"
										required/>
								</td>
							</tr>
						<tr>
						<td>Gender</td>
						<td>
						<input readonly type="radio" name="gender" id="genderM" value="M" 
									<%
                                        if(employeeBO.getGender()=='M') {
                                            out.println(" checked");
                                        }
                                    %>>M
						<input readonly type="radio" name="gender" id="genderF" value="F"
									<%
                                        if(employeeBO.getGender()=='F') {
                                            out.println(" checked");
                                        }
                                    %>>F
                     </td>
					 </tr>
							<tr>
								<td>AadharId </td>
								<td>
										<input readonly  type="number" class="form-control" id="aadharId" name="aadharId" size="12" 
										placeholder="Your AadharId" 
										value="${employeeBO.aadharId}" required/>
								</td>
							</tr>
							<tr>
						<td> BloodGroup </td>
						<td>
							<select class="form-select" aria-label=".select example"
                       		 		name="bloodGroup" id="bloodGroup" required>
                       		  	<option value="${employeeBO.bloodGroup}">${employeeBO.bloodGroup}</option>
			                    <option value="A+ve" disabled >A+ve</option>
			                    <option value="O+ve" disabled>O+ve</option>
			                    <option value="B+ve" disabled>B+ve</option>
			                    <option value="AB+ve" disabled>AB+ve</option>
			                    <option value="A-ve" disabled>A-ve</option>
			                    <option value="O-ve" disabled>O-ve</option>
			                    <option value="B-ve" disabled>B-ve</option>
			                    <option value="AB-ve" disabled>AB-ve</option> 
			                </select>
			               
						</td>
					<tr>
					<tr>
						<td>City</td>
						<td>
							<input type="text" class="form-control"  
	                    	id="city" name="city" placeholder="city" 
	                    	size="20"   maxlength="20" value="${employeeBO.city}"
								required />
						</td>
					</tr>
					<tr>
						<td>PersonalEmail</td>
						<td>
							<input type="Email" class="form-control" 
	                    	id="persoalEmail" name="personalEmail" 
		                    size="40"  placeholder="your email"  value="${employeeBO.personalEmail}"
								required />
							
						</td>
					</tr>
					<tr>
						<td>OfficialEmail</td>
						<td>
							<input  readonly type="Email" class="form-control" 
	                    id="officialEmail" name="officialEmail" 
	                    size="40"    maxlength="40" placeholder="your email"  value="${employeeBO.officialEmail}"
								required />
						</td>
					</tr>
					<tr>
						<td>Primary Contact Number </td>
						<td>
							<input type="number" class="form-control" 
								id="primaryContactNumber" 
								name="primaryContactNumber" 
								placeholder="your number" size="10"  maxlength="10" value="${employeeBO.primaryContactNo}"
								required />
					
						</td>
					</tr>
						<tr>
						<td>Secondary Contact Number </td>
						<td>
							<input type="number" class="form-control" 
								id="secondaryContactNumber" 
								name="secondaryContactNumber" 
								placeholder="your number" size="10"  maxlength="10" value="${employeeBO.secondaryContactNo}"/>
		
						</td>
					</tr>
					<tr>
						<td>Highest Qualification</td>
						<td>
							<input type="text" class="form-control" 
								id="highestQualification" 
								name="highestQualification" 
								placeholder="your highestQualification"  size="35"  maxlength="35" value="${employeeBO.highestQualification}"
								required />
						</td>
					</tr>
					<tr>
						<td>Skill Sets</td>
						<td>
							<textarea class="form-control" rows="4" cols="50"  
								id="skillSets" name="skillSets" placeholder="your skill set" maxlength="100"								  
								required>${employeeBO.skillsets}</textarea> 
						</td>
					</tr>
					
					<tr>
						<td>Date Of Joining </td>
						<td>
							<input  readonly type="date" class="form-control" 
								id="doj" name="doj"  value="${employeeBO.dateOfJoining}"
								required />
						</td>
					</tr>
					<tr>
						<td> Hobbies </td>
						<td>
							<input type="text" class="form-control" 
                       		 	id="hobbies" name="hobbies" 
                       		 	placeholder="Reading Books, Listening to Music, Playing Cricket etc.," 
                       		 	size="100" maxlength="100"  value="${employeeBO.hobbies}"required />
                       		 	
	    						<div id="hobbiesHelp" class="form-text">
	    							Mention your extra curricular activities if any.
	    						</div>
						</td>
					</tr>
					
					<tr>
						<td> Manager Id </td>
						<td>
							<select class="form-select" aria-label=".select example"
                       			id="managerId" name="managerId"required>
                       			<option value="${employeeBO.managerId}">${employeeBO.managerId}</option>
                       			<option id="1" value="0" disabled >N/A</option>
                       			<option id="1" value="1" disabled>Raghavan</option>
                       		</select>
								
						</td>
					</tr>
				
							<tr>
								<td colspan="2">
									<input type="submit" name="Update" Value="Update"/>
								
								</td>
							</tr>			
						</tbody>
					</table>
				</form>
		<% 		
			}
		%>
<%@include file="../inc/footer.jsp" %>
