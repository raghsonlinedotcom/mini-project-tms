/**
 * 
 */
package com.tutorials.tms.util;

import static org.junit.jupiter.api.Assertions.*;

import javax.mail.MessagingException;

import org.junit.jupiter.api.Test;

/**
 * @author raghavan.muthu
 *
 */
class JavaMailJUnitTest {

	@Test
	void test() 
	{
		boolean mailSent = false;
		try {
			mailSent = new EmailUtil().testMail();
		} catch (MessagingException exception) {
			System.err.println("Exception occurred while sendingn a test email");
			System.err.println("Error Message : " + exception.getMessage());
			if(AppUtil.isAppDevMode) {
				exception.printStackTrace();
			}
			fail("Email sending failed");
		}
		assertTrue(mailSent);
	}

}
