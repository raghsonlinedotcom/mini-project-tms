----Dropping the existing TMS Database ---------
DROP DATABASE TMS;

-----Creating the TMS Database again-----
CREATE DATABASE TMS;
USE TMS;

---DDL Statements ----
CREATE TABLE EMPLOYEE (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    EMP_ID INT UNIQUE NOT NULL,
    FIRST_NAME VARCHAR(20) NOT NULL,
    LAST_NAME VARCHAR(20) NOT NULL,
    DATE_OF_BIRTH DATE NOT NULL,
    GENDER CHAR(1) NOT NULL,
    AADHAR_ID VARCHAR(12) UNIQUE NOT NULL,
    BLOOD_GROUP VARCHAR(10) NOT NULL,
    CITY VARCHAR(25) NOT NULL,
    PERSONAL_EMAIL VARCHAR(40) UNIQUE NOT NULL,
    OFFICIAL_EMAIL VARCHAR(40) UNIQUE NOT NULL,
    PASSWORD VARCHAR(15) NOT NULL,
    PRIMARY_CONTACT_NO VARCHAR(10) NOT NULL,
    SECONDARY_CONTACT_NO VARCHAR(10),
    HIGHEST_QUALIFICATION VARCHAR(35) NOT NULL,
    SKILLSETS VARCHAR(100) NOT NULL,
    DATE_OF_JOINING DATE NOT NULL,
    HOBBIES VARCHAR(100),
    MANAGER_ID INT,
    IS_ACTIVE boolean default TRUE
);

---- Sample Values for Employee Table (DML) ---

INSERT INTO EMPLOYEE(
	EMP_ID, FIRST_NAME, LAST_NAME,DATE_OF_BIRTH, GENDER, 
	AADHAR_ID, BLOOD_GROUP, CITY, PERSONAL_EMAIL, 
	OFFICIAL_EMAIL, PASSWORD, PRIMARY_CONTACT_NO, 
	SECONDARY_CONTACT_NO, HIGHEST_QUALIFICATION, 
	SKILLSETS, DATE_OF_JOINING, 
	HOBBIES) 
VALUES (
	140, "RAGHAVAN", "MUTHU", "1981-01-01", "M", 
	"123456789876", "B+VE", "BANGALORE", "raghavan.muthu@gmail.com", 
	"raghavan.muthu@milvik.se", "Raghavan@muthu", "8095261616", 
	"9848022338", "M.Tech", 
	"Java, MySQL, Spring, HTML, CSS", "2022-05-12", 
	"Training young freshers, Playing Cricket, Reading Books"
);


--- Retrieve Values --
SELECT * FROM EMPLOYEE;
