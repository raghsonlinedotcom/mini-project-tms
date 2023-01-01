/**
 * 
 */
package com.raghsonline.miniprojects.tms.util;

import static org.junit.jupiter.api.Assertions.*;

import javax.mail.MessagingException;

import org.junit.jupiter.api.Test;

import com.raghsonline.miniprojects.tms.exception.MissingConfigException;
import com.raghsonline.miniprojects.tms.util.AppUtil;
import com.raghsonline.miniprojects.tms.util.EmailUtil;

/**
 * @author raghavan.muthu
 *
 */
public class JavaMailJUnitTest {

	@Test
	void test() 
	{
		boolean mailSent = false;
		boolean isError = false;
		Exception exceptionObj = null;
		
		try {
			mailSent = new EmailUtil().testMail();
		} catch (MissingConfigException exception) {
			isError = true;
			exceptionObj = exception;
		} catch (MessagingException exception) {
			isError = true;
			exceptionObj = exception;			
		}
		
		if(isError) 
		{
			System.err.println("Exception occurred while sending a test email");
			System.err.println("Error Message : " + exceptionObj.getMessage());
			if(AppUtil.isAppDevMode) {
				exceptionObj.printStackTrace();
			}
			fail("Email sending failed");
		}
		
		assertTrue(mailSent);
	}

}
