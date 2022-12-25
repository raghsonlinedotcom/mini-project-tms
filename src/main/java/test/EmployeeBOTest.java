package test;

import java.sql.Date;

import com.tutorials.tms.bo.EmployeeBO;

public class EmployeeBOTest 
{
	
	public static void main(String[] args) {
	    EmployeeBO employeeBO = new EmployeeBO();
		Date dob = new Date(2000-01-01);
		Date doj = new Date(2022-01-01);
		employeeBO = new EmployeeBO();
		employeeBO.setId(548); 
        employeeBO.setFirstName("Pruthvi"); 
        employeeBO.setLastName("Narayan");
        employeeBO.setDateOfBirth(dob);
        employeeBO.setGender('M');
        employeeBO.setAadharId("926342516473");
        employeeBO.setBloodGroup("B+ ve");
        employeeBO.setCity("Hassan");
        employeeBO.setPersonalEmail("pruthvi@gmail.com");
        employeeBO.setOfficialEmail("pruthvi23@gmail.com");
        employeeBO.setPassword("Hassan@123");
        employeeBO.setPrimaryContactNo("9876786545");
        employeeBO.setSecondaryContactNo("9856342341");
        employeeBO.setHighestQualification("B E");  
        employeeBO.setSkillsets("JAVA,PYTHON");
        employeeBO.setDateOfJoining(doj);
        employeeBO.setHobbies("singing");
        employeeBO.setManagerId(140);
		System.out.println("EmployeeBO : "+ employeeBO);
	}

}

