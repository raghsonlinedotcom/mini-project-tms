/**
 * 
 */
package com.tutorials.tms.util;

/**
 * @author raghavan.muthu
 *
 */
public class EmailChecker 
{

	public static boolean FLAG_EMAIL_READY = false;

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		checkEmail();
		System.out.println("Email Readiness Flag : " + FLAG_EMAIL_READY);
	}
	
	public static void checkEmail()
	{
		EmailUtil emailUtil = new EmailUtil();
		
		try {
			emailUtil.testMail();
			FLAG_EMAIL_READY = true;
		} catch (Exception exception) {
			System.err.println("Exception occurred while verifying the Email Status : ");
			System.err.println("Error Message : " + exception.getMessage());
			if(AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
		}
		
		System.out.println("FLAG_EMAIL_READY ? " + FLAG_EMAIL_READY);
	}
}
