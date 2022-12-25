/**
 * 
 */
package com.tutorials.tms.util;

/**
 * @author raghavan.muthu
 *
 */
public class AppUtil {
	
	public static boolean isAppDevMode = PropertyUtil.isAppModeDev();
	
	public static boolean isAppReady = false;
	
	static {		
		DBChecker.checkDB();
		if(DBChecker.FLAG_DB_READY) {
			System.out.println("The Database seems to be in good condition to proceed.");
			isAppReady = true;
		} else {
			System.err.println("The DB seems not yet ready. Please read the Application logs for more details");
		}
	}

}
