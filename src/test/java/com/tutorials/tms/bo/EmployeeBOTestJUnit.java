/**
 * 
 */
package com.tutorials.tms.bo;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

/**
 * @author raghavan.muthu
 *
 */
class EmployeeBOTestJUnit {

	/**
	 * Test method for {@link com.tutorials.tms.bo.EmployeeBO#EmployeeBO()}.
	 */
	@Test
	void testEmployeeBO() {
		EmployeeBO employeeBO = new EmployeeBO();
		Date dob = new Date(1986-9-13);
		Date doj = new Date(2014-01-01);
		employeeBO = new EmployeeBO();
 
        employeeBO.setFirstName("Balaji"); 
        employeeBO.setLastName("Jayavelu");
        employeeBO.setDateOfBirth(dob);
        employeeBO.setGender('M');
        employeeBO.setAadharId("232323456788");
        employeeBO.setBloodGroup("B+ve");
        employeeBO.setCity("Bengaluru");
        employeeBO.setPersonalEmail("balaji@gmail.com");
        employeeBO.setOfficialEmail("balaji@office.com");
        employeeBO.setPassword("Balaji@123");
        employeeBO.setPrimaryContactNo("9804612341");
        employeeBO.setSecondaryContactNo("9999451111");
        employeeBO.setHighestQualification("BTech");  
        employeeBO.setSkillsets("Java, TOGAF");
        employeeBO.setDateOfJoining(doj);
        employeeBO.setHobbies("Cycling, Coding");
        employeeBO.setManagerId(140);
        employeeBO.setEmpId("81");
        
        assertNotNull(employeeBO);
        assertEquals("82", employeeBO.getEmpId());
	}
}
