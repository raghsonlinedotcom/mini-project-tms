package com.tutorials.tms.junit;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.tutorials.tms.util.PropertyUtilTest;
import com.tutorials.tms.util.JavaMailJUnitTest;

@Suite
@SelectClasses({ 
			EmployeeBOJUnitTest.class,
			EmployeeDAOTest.class, 
			DBCheckerJUnitTest.class,
			EmployeeViewJUnitTest.class,
			EmployeeEditJUnitTest.class,
			LogInJUnitTestTest.class,
			PropertyUtilTest.class,
			JavaMailJUnitTest.class
		})
public class AllTests {

}
