<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>TMS | Register</title>
		<script type="text/javascript">
		 function validate changeGender()
	      {
	        var gender = document.getElementsByName('gender');
	        //console.dir(gender);
	        var genderValue;
	        for(var i = 0; i < gender.length; i++){
	            if(gender[i].checked){
	                genderValue = gender[i].value;
	            }
	        }
	        console.log("(generic) selected gender : " + genderValue);
	      }
		 </script>
	</head>
	<body>
		<h1>Employee-RegisterationForm :</h1>
		<br>
		<form id="register" name="register" action="check.jsp" method="post">
			<table border="1">
				<thead>
					<tr>
						<th>Field</th>
						<th>Value</th>
					</tr>				
				</thead>
				<tbody>	
					<tr>
						<td>Employee Id</td>
						<td>
							<input type="number" id="employeeId" name="employeeId" size="3" 
							     min="1" max="999" step="1"
								placeholder="ex:121" required   >
						</td>
					</tr>
					<tr>
						<td>First Name</td>
						<td>
							<input type="text" id="firstName" name="firstName"  
								placeholder="Ex:ABC" size="20" maxlength="20" required>
						</td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td>
							<input type="text" id="lastName" name="lastName"  
								placeholder="Ex:XYZ" size="20"   maxlength="20"required >
						</td>
					</tr>
					<tr>
						<td>Date-Of-Birth</td>
						<td>
							<input type="date" id="dob" name="dob" 
							min="18" max="52" required/>
						</td>
					</tr>
					<tr>
	                    <td>Gender</td>
	                    <td>
	                    	<input type="radio" id="gender" name="gender" value="M" required onclick="changeGender();">Male
     						<input type="radio" id="gender" name="gender" value="F" onclick="changeGender();">Female
	                    </td>
                	</tr>
					<tr>
						<td>Aadhaar Id</td>
						<td>
							<input type="number" id="AadhaarId" name="AadhaarId" size="12" 
								placeholder="ex:123456789012" maxlength="12" required>
						</td>
					</tr>
	                <tr>
	                	<td>
                       		 BloodGroup
                    	</td>
                   		<td>
                       		 <select name="bloodGroup" id="bloodGroup" required>
                       		  	<option value='' selected disabled hidden>Select an Option</option>
			                    <option value="A +ve">A +ve</option>
			                    <option value="O +ve">O +ve</option>
			                    <option value="B +ve">B +ve</option>
			                    <option value="AB +ve">AB +ve</option>
			                    <option value="A -ve">A -ve</option>
			                    <option value="O -ve">O -ve</option>
			                    <option value="B -ve">B -ve</option>
			                    <option value="AB -ve">AB -ve</option> 
			                </select>
                   		</td>
	                </tr>
	                <tr>
	                    <td>City</td>
	                    <td><input type="text" id="city" name="city" placeholder="city" size="20"   maxlength="20" required></td>
	                </tr>
					<tr>
	                    <td>PersonalEmail</td>
	                    <td><input type="Email" id="persoalEmail" name="persoalEmail" size="40"  placeholder="Ex:abc@gmail.com"  maxlength="40" required></td>
	                </tr>
	                <tr>
	                    <td>OfficialEmail</td>
	                    <td><input type="Email" id="officialEmail" name="officialEmail" size="40"  placeholder="Ex:abc.de@milvik.se" maxlength="40" required></td>
	                </tr>
	                <tr>
	                    <td>Password</td>
	                    <td><input type="password" id="password" name="password" size="15"  placeholder="password" maxlength="15" required></td>
	                </tr>
					<tr>
						<td>Primary Contact Number</td>
						<td>
							<input type="number" id="primaryContactNumber" name="primaryContactNumber" 
								placeholder="ex:1234567890" size="10"  maxlength="10" required >
						</td>
					</tr>
					<tr>
						<td>Secondary Contact Number</td>
						<td>
							<input type="number" id="secondaryContactNumber" name="secondaryContactNumber" 
								placeholder="ex:1234567890" size="10"  maxlength="10" >
						</td>
					</tr>
					<tr>
						<td>Highest Qualification</td>
						<td>
							<input type="text" id="highestQualification" name="highestQualification" 
								placeholder="ex:Master's" required size="35" maxlength="35">
						</td>
					</tr>
					<tr>
						<td>Skill Sets</td>
						<td>
						<textarea rows="4" cols="50"  id="skillSets" name="skillSets" 
								placeholder="ex:java,mysql,html,css" size="100" maxlength="100" required>
						</textarea>
						</td>
					<tr>
						<td>Date-Of-Joinig</td>
						<td>
							<input type="date" id="doj" name="doj"
								required/>
						</td>
					</tr>
					<tr>
	                	<td>
                       		 Hobbies
                    	</td>
                   		<td>
                       		 <input type="text" id="hobbies" name="hobbies" placeholder="ex:Singing,Dancing,etc" size="100"  maxlength="100" required >
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 Manager Name
                    	</td>
                   		<td>
                       		 <input type="text" id="managerName" name="managerName" placeholder="ex:abc" size="100"  maxlength="20" required >
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 Manager Id
                    	</td>
                   		<td>
                       		 <input type="number" id="managerId" name="managerId" 
                       		 min="1" max="999" step="1"  placeholder="Ex:123" size="3"  maxlength="3" required>
                   		</td>
	                </tr>
					<tr>
						<td colspan="2">
							<input type="submit" name="Create" Value="Create"/>
						</td>
					</tr>				
				</tbody>
			</table>
		</form>
	</body>
</html>