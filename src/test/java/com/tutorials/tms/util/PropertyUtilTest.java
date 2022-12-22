/**
 * 
 */
package com.tutorials.tms.util;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Properties;

import org.junit.jupiter.api.Test;

/**
 * @author raghavan.muthu
 *
 */
public class PropertyUtilTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Properties properties = PropertyUtil.getProps();
		System.out.println("Properties : " + properties);
		
		System.out.println("------ Explicitly accessing values ----");
		String[] keys = new String[] {"jdbc.user.name", "jdbc.user.pass", "jdbc.user.url"};
		
		for(String key : keys)
		{
			String value = properties.getProperty(key);
			//String value2 = PropertyUtil.getPropertyValue(key);
			System.out.println("Key : [" + key + "], value : [" + value + "]");
		}
	}
	
	@Test
	public void testProps()
	{
		Properties properties = PropertyUtil.getProps();
		System.out.println("Properties : " + properties);
		
		System.out.println("------ Explicitly accessing values ----");
		String[] keys = new String[] {"jdbc.user.name", "jdbc.user.pass", "jdbc.url"};
		
		for(String key : keys)
		{
			String value = properties.getProperty(key);
			//String value2 = PropertyUtil.getPropertyValue(key);
			System.out.println("Key : [" + key + "], value : [" + value + "]");
			assertNotNull(key);
			assertNotNull(value);
		}
		
		
	}
}
