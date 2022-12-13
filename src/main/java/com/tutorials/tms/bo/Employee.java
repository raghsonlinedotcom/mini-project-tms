package com.tutorials.tms.bo;

import java.sql.Date;

//import java.util.Date;

public class Employee {

	private int emp_id;

	private String first_name;
	
	private String last_name;

	private Date date_of_birth;

	private char  gender;
	
	private String aadhar_id;

	private String blood_group;

	private String city ;
	
	private String personal_email;
	
	private String offical_email;
	
	private String password;

	private String primary_contact_no;
	
	private String secondary_contact_no;
	
	private String highest_qualification;
	
	private String skillsets;

	private Date date_of_joining;
	
	private String hobbies;
	
	private String manager_name;
	
	private int manager_id;
	
	
	/**
	 * @param emp_id
	 * @param first_name
	 * @param last_name
	 * @param date_of_birth
	 * @param gender
	 * @param aadhar_id
	 * @param blood_group
	 * @param city
	 * @param personal_email
	 * @param offical_email
	 * @param password
	 * @param primary_contact_no
	 * @param secondary_contact_no
	 * @param highest_qualification
	 * @param skillsets
	 * @param date_of_joining
	 * @param hobbies
	 * @param manager_name
	 * @param manager_id
	 */
	public Employee() {
		
	}
	
	public Employee(int emp_id, String first_name, String last_name, Date date_of_birth, char gender, String aadhar_id,
			String blood_group, String city, String personal_email, String offical_email, String password,
			String primary_contact_no, String secondary_contact_no, String highest_qualification, String skillsets,
			Date date_of_joining, String hobbies, String manager_name, int manager_id) {
		super();
		this.emp_id = emp_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.date_of_birth = date_of_birth;
		this.gender = gender;
		this.aadhar_id = aadhar_id;
		this.blood_group = blood_group;
		this.city = city;
		this.personal_email = personal_email;
		this.offical_email = offical_email;
		this.password = password;
		this.primary_contact_no = primary_contact_no;
		this.secondary_contact_no = secondary_contact_no;
		this.highest_qualification = highest_qualification;
		this.skillsets = skillsets;
		this.date_of_joining = date_of_joining;
		this.hobbies = hobbies;
		this.manager_name = manager_name;
		this.manager_id = manager_id;
	}





	public int getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public Date getDate_of_birth() {
		return date_of_birth;
	}


	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public String getAadhar_id() {
		return aadhar_id;
	}


	public void setAadhar_id(String aadhar_id) {
		this.aadhar_id = aadhar_id;
	}


	public String getBlood_group() {
		return blood_group;
	}


	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPersonal_email() {
		return personal_email;
	}


	public void setPersonal_email(String personal_email) {
		this.personal_email = personal_email;
	}


	public String getOffical_email() {
		return offical_email;
	}


	public void setOffical_email(String offical_email) {
		this.offical_email = offical_email;
	}


	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	public String getPrimary_contact_no() {
		return primary_contact_no;
	}



	public void setPrimary_contact_no(String primary_contact_no) {
		this.primary_contact_no = primary_contact_no;
	}




	public String getSecondary_contact_no() {
		return secondary_contact_no;
	}



	public void setSecondary_contact_no(String secondary_contact_no) {
		this.secondary_contact_no = secondary_contact_no;
	}


	public String getHighest_qualification() {
		return highest_qualification;
	}


	public void setHighest_qualification(String highest_qualification) {
		this.highest_qualification = highest_qualification;
	}


	public String getSkillsets() {
		return skillsets;
	}


	public void setSkillsets(String skillsets) {
		this.skillsets = skillsets;
	}


	public Date getDate_of_joining() {
		return date_of_joining;
	}


	public void setDate_of_joining(Date date_of_joining) {
		this.date_of_joining = date_of_joining;
	}


	public String getHobbies() {
		return hobbies;
	}



	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}


	public String getManager_name() {
		return manager_name;
	}



	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}



	public int getManager_id() {
		return manager_id;
	}



	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}




		@Override
		public String toString() {
			return "Employee ["
					+ ", hashCode()=" + hashCode()
					+ "emp_id=" + emp_id 
					+ ", first_name=" + first_name 
					+ ", last_name=" + last_name
					+ ", date_of_birth=" + date_of_birth 
					+ ", gender=" + gender 
					+ ", aadhar_id=" + aadhar_id
					+ ", blood_group=" + blood_group 
					+ ", city=" + city 
					+ ", personal_email=" + personal_email
					+ ", offical_email=" + offical_email 
					+ ", password=" + password
					+ ", primary_contact_no="+ primary_contact_no 
					+ ", secondary_contact_no=" + secondary_contact_no 
					+ ", highest_qualification="+ highest_qualification 
					+ ", skillsets=" + skillsets 
					+ ", date_of_joining=" + date_of_joining
					+ ", hobbies=" + hobbies 
					+ ", manager_name=" + manager_name 
					+ ", manager_id=" + manager_id;
		}



		// TODO Auto-generated constructor stub
	}


