package com.raghsonline.miniprojects.tms.util;

import static com.raghsonline.miniprojects.tms.util.StringUtil.isNotValid;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import com.raghsonline.miniprojects.tms.bo.EmailConfigBO;
import com.raghsonline.miniprojects.tms.exception.MissingConfigException;

public class EmailUtil 
{
	
	Logger logger = Logger.getLogger(EmailUtil.class);
	
	public static final String KEY_EMAIL_FROM = "email.user.from";
	
	public static final String KEY_EMAIL_TO = "email.user.to";
	
	public static final String KEY_EMAIL_SUBJECT = "email.subject.test";
	
	public static final String KEY_EMAIL_BODY = "email.body.test";
	
	EmailConfigBO emailConfigBO = EmailConfigUtil.loadEmailConfig();
	

	public boolean testMail() 
	throws AddressException, MessagingException, MissingConfigException 
    {

		boolean mailSent = false;
		
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		//prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		//prop.put("mail.smtp.port", "465");
		//prop.put("mail.smtp.socketFactory.port", "465");
	    //prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    
		String username = PropertyUtil.getEmailPropertyValue("smtp.user.name");
		String password = PropertyUtil.getEmailPropertyValue("smtp.user.pass");
		
		validateEmailConfig("SMTPConfig", "emailconfig-user.properties", 
				username, password);
			
		/*Session session = Session.getInstance(prop, new Authenticator() {
	    	@Override
	    	protected PasswordAuthentication getPasswordAuthentication() {
	        		return new PasswordAuthentication(username, password);
	    		}
		});*/
		
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	        }
	    });
		
		String fromEmail = emailConfigBO.getEmailFrom();
		String toEmail = emailConfigBO.getEmailTo();
		String emailSubject = emailConfigBO.getEmailSubject();
		String emailBody = emailConfigBO.getEmailBody();
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(fromEmail));
		message.setRecipients(
		  Message.RecipientType.TO, InternetAddress.parse(toEmail));
		message.setSubject(emailSubject);
	
		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(emailBody, "text/html; charset=utf-8");
	
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);
	
		message.setContent(multipart);
	
		Transport.send(message);
		
		System.out.println("Email was sent successfully.");
		
		mailSent = true;
		
		return mailSent;
    }
	
	public boolean sendMail(EmailConfigBO emailConfigBO) 
		throws AddressException, MessagingException, MissingConfigException
    {
		boolean mailSent = false;
		
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		//prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		//prop.put("mail.smtp.port", "465");
		//prop.put("mail.smtp.socketFactory.port", "465");
	    //prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    
		String username = PropertyUtil.getEmailPropertyValue("smtp.user.name");
		String password = PropertyUtil.getEmailPropertyValue("smtp.user.pass");
		
		validateEmailConfig("SMTPConfig", "emailconfig-user.properties", 
								username, password);
			
		/*Session session = Session.getInstance(prop, new Authenticator() {
	    	@Override
	    	protected PasswordAuthentication getPasswordAuthentication() {
	        		return new PasswordAuthentication(username, password);
	    		}
		});*/
		
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	        }
	    });
	
		String fromEmail = emailConfigBO.getEmailFrom();
		String toEmail = emailConfigBO.getEmailTo();
		String emailSubject = emailConfigBO.getEmailSubject();
		String emailBody = emailConfigBO.getEmailBody();
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(fromEmail));
		message.setRecipients(
		  Message.RecipientType.TO, InternetAddress.parse(toEmail));
		message.setSubject(emailSubject);
	
		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(emailBody, "text/html; charset=utf-8");
	
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);
	
		message.setContent(multipart);
	
		Transport.send(message);
		
		System.out.println("Email was sent successfully.");
		
		mailSent = true;
		
		return mailSent;
    }
	
	public void validateEmailConfig(EmailConfigBO emailConfigBO)
	throws MissingConfigException
	{
		validateEmailConfig("EmailConfig", "emailconfig.properties", 
				emailConfigBO.getEmailFrom(), emailConfigBO.getEmailTo());
	}
	
	public void validateEmailConfig(String key, String configFileName, String... values)
	throws MissingConfigException
	{
		if(isNotValid(values)) {
			System.err.println("Missing " + key + " Credentials");
			System.err.println("Check whether a valid [" + configFileName 
					+ "] file exists in the classpath and accessible");
			throw new MissingConfigException("Missing " + key + " Credentials");
		}
	}
}
