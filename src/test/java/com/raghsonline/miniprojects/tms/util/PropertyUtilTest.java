/**
 * 
 */
package com.raghsonline.miniprojects.tms.util;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Properties;

import org.junit.jupiter.api.Test;

import com.raghsonline.miniprojects.tms.util.PropertyUtil;

/**
 * @author raghavan.muthu
 *
 */
public class PropertyUtilTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Properties properties = PropertyUtil.getDBProps();
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
	public void testDBProps()
	{
		Properties properties = PropertyUtil.getDBProps();
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
	
	@Test
	public void testEmailProps()
	{
		Properties properties = PropertyUtil.getEmailProps();
		System.out.println("Properties : " + properties);
		
		System.out.println("------ Explicitly accessing values ----");
		String[] keys = new String[] {"smtp.user.name", "smtp.user.pass", "email.user.from", "email.user.to"};
		
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
