/**
 * 
 */
package com.raghsonline.miniprojects.tms.util;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import com.raghsonline.miniprojects.tms.exception.MissingConfigException;

/**
 * @author raghavan.muthu
 *
 */
public class JavaMailJUnitTest 
{
	Logger logger = Logger.getLogger(JavaMailJUnitTest.class);

	@Test
	void test() 
	{
		boolean mailSent = false;
		boolean isError = false;
		Exception exceptionObj = null;
		
		boolean isAppGRCEmailEnabled = PropertyUtil.isAppGRCVerifyEmailEnabled();
		
		logger.info("isAppGRCEmailEnabled ? " + isAppGRCEmailEnabled);
		
		if(!isAppGRCEmailEnabled) 
		{
			logger.info("GRC Email Verify flag has been disabled. Skipping the email verification");
			assertTrue(true);
			return;
		}
		
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
			logger.error("Exception occurred while sending a test email");
			logger.error("Error Message : " + exceptionObj.getMessage());
			if(AppUtil.isAppDevMode) {
				exceptionObj.printStackTrace();
			}
			fail("Email sending failed");
		}
		
		assertTrue(mailSent);
	}

}
