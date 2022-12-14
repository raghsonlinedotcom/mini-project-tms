/**
 * 
 */
package com.raghsonline.miniprojects.tms.util;

/**
 * @author raghavan.muthu
 *
 */
public class AppUtil {
	
	public static boolean isAppDevMode = PropertyUtil.isAppModeDev();
	
	public static boolean isAppReady = false;
	
	public static boolean isDBReady = false;
	
	public static boolean isEmailReady = false;
	
	public static boolean isAppGRCEmailEnabled = PropertyUtil.isAppGRCVerifyEmailEnabled();
	
	static {
		
		System.out.println("isAppDevMode ? " + isAppDevMode);
		System.out.println("isAppGRCEmailEnabled ? " + isAppGRCEmailEnabled);
		
		checkDB();
		
		if(isAppGRCEmailEnabled) {
			checkEmail();
			isAppReady = isDBReady && isEmailReady;
		}else  {
			System.out.println("Skipping the mail check now, because either App Mode is Dev OR grcVerifyEmail is NOT enabled.");
			isAppReady = isDBReady ;
		}
		
		System.out.println("isAppReady ? " + isAppReady);
	}
	
	public static void checkDB() 
	{
		DBChecker.checkDB();
		
		if(DBChecker.FLAG_DB_READY) {
			System.out.println("The Database seems to be in good condition to proceed.");
			isDBReady = true;
		} else {
			System.err.println("The DB seems not yet ready. Please read the Application logs for more details");
		}
		System.out.println("isDBReady ? " + isDBReady);
	}
	
	public static void checkEmail() 
	{
		EmailChecker.checkEmail();
		
		if(EmailChecker.FLAG_EMAIL_READY) {
			System.out.println("The Email Config seems to be in good condition to proceed.");
			isEmailReady = true;
		} else {
			System.err.println("The Email Config seems not yet ready. Please read the Application logs for more details");
		}
		System.out.println("isEmailReady ? " + isEmailReady);
	}
}
