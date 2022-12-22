package com.tutorials.tms.junit;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({ 
			EmployeeBOJUnitTest.class,
			EmployeeDAOTest.class, 
			DBCheckerJUnitTest.class
		})
public class AllTests {

}
