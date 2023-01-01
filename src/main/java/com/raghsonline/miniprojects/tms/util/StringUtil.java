/**
 * 
 */
package com.raghsonline.miniprojects.tms.util;

import java.util.List;

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
	
	public static boolean isPresent(String target, List<String> dataList)
	{
		return isPresent(target, dataList, true);
	}
	
	public static boolean isPresent(String target, List<String> dataList, 
			boolean isCaseSensitive)
	{
		/*System.out.println("target : [" + target + "]");
		System.out.println("dataList : [" + dataList + "]");
		System.out.println("isCaseSensitive : [" + isCaseSensitive + "]");*/
		
		if(dataList==null || dataList.size()<=0) {
			return false;
		}
		
		if(StringUtil.isEmpty(target)) {
			return false;
		}
		
		for(String s : dataList) 
		{
			//System.out.println("datalist member : [" + s + "]");
			
			if(isCaseSensitive) 
			{
				if(target.contains(s)) {
					//System.out.println("Case Sensitive Search - Success");
					return true;
				}
			} else if(target.toLowerCase().contains(s.toLowerCase())) {
				//System.out.println("Case Insensitive Search - Success");
				return true;
			}
		}
		
		//System.out.println("No match!!!");
		
		return false;
	}
}
