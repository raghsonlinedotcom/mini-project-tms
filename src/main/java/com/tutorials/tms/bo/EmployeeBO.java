package com.tutorials.tms.bo;

import java.sql.Date;

//import java.util.Date;

public class EmployeeBO {

	private int id;

	private int empId;
	
	private String firstName;
	
	private String lastName;

	private Date dateOfBirth;

	private char  gender;
	
	private String aadharId;

	private String bloodGroup;

	private String city ;
	
	private String personalEmail;
	
	private String officialEmail;
	
	private String password;

	private String primaryContactNo;
	
	private String secondaryContactNo;
	
	private String highestQualification;
	
	private String skillsets;

	private Date dateOfJoining;
	
	private String hobbies;

	private int managerId;

	
	public EmployeeBO() {
	}
	
	
	public EmployeeBO(int id,int empId, String firstName, String lastName, String officialEmail,
			String primaryContactNo,Date dateOfJoining,  int managerId) {
		super();
		this.id = id;
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.officialEmail=officialEmail;
		this.primaryContactNo = primaryContactNo;
		this.dateOfJoining = dateOfJoining;
		this.managerId = managerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
 
	

	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int  empId) {
		this.empId =  empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getAadharId() {
		return aadharId;
	}

	public void setAadharId(String aadharId) {
		this.aadharId = aadharId;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getOfficialEmail() {
		return officialEmail;
	}

	public void setOfficialEmail(String officialEmail) {
		this.officialEmail = officialEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrimaryContactNo() {
		return primaryContactNo;
	}

	public void setPrimaryContactNo(String primaryContactNo) {
		this.primaryContactNo = primaryContactNo;
	}

	public String getSecondaryContactNo() {
		return secondaryContactNo;
	}

	public void setSecondaryContactNo(String secondaryContactNo) {
		this.secondaryContactNo = secondaryContactNo;
	}

	public String getHighestQualification() {
		return highestQualification;
	}

	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}

	public String getSkillsets() {
		return skillsets;
	}

	public void setSkillsets(String skillsets) {
		this.skillsets = skillsets;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public int getManagerId() {
		return managerId;
		
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	
	@Override
	public String toString() 
	{
		return "EmployeeBO ["
				+ ", hashCode()=" + hashCode()
				+ ", id=" + id 
				+ ", empId=" + empId 
				+ ", firstName=" + firstName
				+ ", lastName=" + lastName
				+ ", officialEmail=" + officialEmail 
				+ ", primaryContactNo="+  primaryContactNo
				+ ", dateOfJoining=" + dateOfJoining
				+ ", managerId=" + managerId;
	}	
}
