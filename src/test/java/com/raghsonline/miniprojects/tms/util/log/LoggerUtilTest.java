/**
 * 
 */
package com.raghsonline.miniprojects.tms.util.log;

import java.util.Enumeration;

import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author raghavan.muthu
 *
 */
public class LoggerUtilTest 
{
	static Logger logger = Logger.getLogger(LoggerUtilTest.class);
	
	/**
	 * Logger Levels
	 * -------------
	 * TRACE >> DEBUG >> INFO >> WARN >> ERROR >> FATAL
	 * (Low)										(high)
	 * 
	 * LOGGER Component Level : 
	 * If the level of the Logger Component is higher than or equal
	 * to the message level, then only it will be printed.
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasicConfigurator.configure();
		System.out.println("Logger : " + logger);
		System.out.println("Logger Level : " + logger.getLevel());
		logger.setLevel(Level.DEBUG);
		System.out.println("(2) Logger Level : " + logger.getLevel());
		
		@SuppressWarnings("rawtypes")
		Enumeration appenders = logger.getAllAppenders();
		System.out.println("Appenders : " + appenders);
		while(appenders.hasMoreElements()) {
			Appender appender = (Appender) appenders.nextElement();
			System.out.println(".... Appender Name : " + appender.getName());
			System.out.println("Appender : "+ appender);
			System.out.println("Appender Layout " + appender.getLayout());
		}
		System.out.println("---------------");
		testLogMessages();
		System.out.println("---------------");
		testMessages();
		
	}
	
	public static void testMessages() {
		System.out.println("Hello, I am an utility to test Log Messages");
		System.out.println("User creation is success");
		System.out.println("User modification failed. Please try again");
		System.out.println("Looping .. i value : 7");
		System.err.println("Error Message : ClassNotFound-com.mysql.cj.jdbc.Driver");
	}
	
	public static void testLogMessages() {
		for(int i=0; i <10000; i++) 
		{
			logger.debug("Looping .. i value : " + i);
			logger.info("Hello, I am an utility to test Log Messages");
			logger.info("User creation is success");	
			logger.warn("Necessary precision is missing, considering the default precision of 2");
			logger.error("User modification failed. Please try again");
			logger.error("Error Message : ClassNotFound-com.mysql.cj.jdbc.Driver");
			logger.fatal("JVM Out of Memory");	
		}
	}

}
