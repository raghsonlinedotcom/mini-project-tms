package com.raghsonline.miniprojects.tms.util;

import org.apache.log4j.Logger;

import com.raghsonline.miniprojects.tms.bo.EmailConfigBO;

public class EmailConfigUtil 
{

	static Logger logger = Logger.getLogger(EmailConfigUtil.class);
	
	public static final String KEY_EMAIL_FROM = "email.user.from";
	
	public static final String KEY_EMAIL_TO = "email.user.to";
	
	public static final String KEY_EMAIL_SUBJECT = "email.subject";
	
	public static final String KEY_EMAIL_BODY = "email.body";
	
	public static final String KEY_FLAG_EMAIL_SEND = "flag.email.send";
	
	private static final String KEY_SUFFIX_TEST = ".test";
	
	private static final String KEY_SUFFIX_TMS = ".tms";
	
	public static EmailConfigBO loadEmailConfig()
	{
		return loadEmailConfig(KEY_SUFFIX_TEST);
	}
	
	public static EmailConfigBO loadEmailConfigForTMS()
	{
		return loadEmailConfig(KEY_SUFFIX_TMS);
	}
	
	public static EmailConfigBO loadEmailConfig(String key)
	{
		logger.info("EmailConfigBO - loadEmailConfig() - key : [" + key + "]");
		
		EmailConfigBO emailConfigBO = new EmailConfigBO();
		
		emailConfigBO.setEmailFrom(PropertyUtil.getEmailPropertyValue(KEY_EMAIL_FROM));
		emailConfigBO.setEmailTo(PropertyUtil.getEmailPropertyValue(KEY_EMAIL_TO));
		emailConfigBO.setEmailSubject(PropertyUtil.getEmailPropertyValue(KEY_EMAIL_SUBJECT + key));
		emailConfigBO.setEmailBody(PropertyUtil.getEmailPropertyValue(KEY_EMAIL_BODY + key));
		
		String flagEmailSend = PropertyUtil.getEmailPropertyValue(KEY_FLAG_EMAIL_SEND);
		boolean canSendEmail = null!=flagEmailSend && flagEmailSend.equalsIgnoreCase("Y");
		emailConfigBO.setSendEmail(canSendEmail);
				
		logger.info("EmailConfigBO populated successfully!, emailConfigBO = " + emailConfigBO);
		
		return emailConfigBO;
	}
}
