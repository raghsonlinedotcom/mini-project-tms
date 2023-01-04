/**
 * 
 */
package com.raghsonline.miniprojects.tms.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author raghavan.muthu
 *
 */
class StringUtilTest 
{
	static Logger logger = Logger.getLogger(StringUtilTest.class);
	
	static List<String> dataList;
	
	@BeforeAll
	public static void before() 
	{
		logger.info("beforeAll() invoked...");
		
		dataList = List.of(
				"create", 
				"Create", 
				"login", 
				"Login");
		
		logger.info("dataList initialized");
	}
	
	@Test
	@DisplayName("Case sensitive search - Successful scenario")
	void test() 
	{			
		String target = "/tmsmaven/Login";
		
		boolean isPresent = StringUtil.isPresent(target, dataList);
		
		assertTrue(isPresent);
	}
	
	@Test
	@DisplayName("Case Insensitive search - Successful scenario")
	void test2() 
	{	
		String target = "/tmsmaven/login.jsp";
		
		boolean isCaseSensitive = false;
		
		boolean isPresentCaseSensitive = StringUtil.isPresent(
						target, dataList, isCaseSensitive);
		
		assertTrue(isPresentCaseSensitive);
		
	}
	
	@Test
	@DisplayName("Case sensitive search - Unsuccessful scenario")
	void test3() 
	{		
		String target2 = "/tmsmaven/delete.jsp";
		
		boolean isPresent2 = StringUtil.isPresent(target2, dataList);
		
		assertFalse(isPresent2);
	}
	
	@Test
	@DisplayName("Case Insensitive search - Unsuccessful scenario")
	void test4() 
	{
		String target2 = "/tmsmaven/Delete";
		
		boolean isCaseSensitive = false;
		
		boolean isPresentCaseSensitive2 = StringUtil.isPresent(
						target2, dataList, isCaseSensitive);
		
		assertFalse(isPresentCaseSensitive2);
	}
}
