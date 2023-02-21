/**
 * 
 */
package com.raghsonline.miniprojects.tms.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * An Utility class to convert or manipulate the date 
 * and time values to and from the String representation.
 * </p>
 * 
 * @author raghavan.muthu
 * @version 1.0
 *
 */
public class DateUtil 
{
	
	public static final String PATTERN = "yyyy-MM-dd";
	
	public static final String PATTERN_WITH_TIME = "yyyy-MM-dd HH:mm:ss";
	
	public static String getFormattedDate(String pattern)
	{				
		return getFormattedDate(new java.util.Date(), pattern);
	}
	
	public static String getFormattedDate(Date dateObj, String pattern)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String currentDateStr = null;
		
		try {
			currentDateStr = sdf.format(dateObj);
		}catch(Exception exception) {
			currentDateStr = "Exception";
		}
		
		return currentDateStr;
	}
	
	public static Date getParsedDate(String pattern, String dateStr)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date dateObj = null;
		
		try {
			dateObj = sdf.parse(dateStr);
		}catch(Exception exception) {
			dateObj = null;
		}
		
		return dateObj;
	}
}
