package com.raghsonline.miniprojects.tms.junit;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.raghsonline.miniprojects.tms.util.JavaMailJUnitTest;
import com.raghsonline.miniprojects.tms.util.PropertyUtilTest;

@Suite
@SelectClasses({ 
			EmployeeBOJUnitTest.class,
			EmployeeDAOJUnitTest.class, 
			DBCheckerJUnitTest.class,
			PropertyUtilTest.class,
			JavaMailJUnitTest.class
		})
public class AllTests {

}
