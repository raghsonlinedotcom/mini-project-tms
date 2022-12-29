/**
 * 
 */
package com.tutorials.tms.util;

/**
 * @author raghavan.muthu
 *
 */
public class StringUtil 
{
	public static boolean isNull(String data) {
		return null==data;
	}
	
	public static boolean isEmpty(String data) {
		return data.trim().length() <=0;
	}
	
	public static boolean isNotNull(String data) {
		return !isNull(data);
	}
	
	public static boolean isNotEmpty(String data) {
		return !isEmpty(data);
	}
	
	public static boolean isValid(String data) {
		return isNotNull(data) && isNotEmpty(data);
	}
	
	public static boolean isValid(String... elements)
	{
		for(String s : elements)
		{
			if(!isValid(s)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isNotValid(String... elements)
	{
		return !isValid(elements);
	}

}
