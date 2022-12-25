/**
 * 
 */
package com.tutorials.tms.util.log;

/**
 * @author raghavan.muthu
 *
 */
public class NoLogUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testMessages();
	}
	
	public static void testMessages() {
		System.out.println("Hello, I am an utility to test Log Messages");
		System.out.println("User creation is success");
		System.out.println("User modification failed. Please try again");
		System.out.println("Looping .. i value : 7");
		System.err.println("Error Message : ClassNotFound-com.mysql.cj.jdbc.Driver");
	}

}
