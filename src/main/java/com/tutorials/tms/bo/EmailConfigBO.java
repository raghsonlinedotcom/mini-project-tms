package com.tutorials.tms.bo;

public class EmailConfigBO 
{
	private String emailFrom;
	
	private String emailTo;
	
	private String emailSubject;
	
	private String emailBody;
	
	public EmailConfigBO() {
		super();
	}
	

	/**
	 * @param emailFrom
	 * @param emailTo
	 * @param emailSubject
	 * @param emailBody
	 */
	public EmailConfigBO(String emailFrom, String emailTo, String emailSubject, String emailBody) {
		super();
		this.emailFrom = emailFrom;
		this.emailTo = emailTo;
		this.emailSubject = emailSubject;
		this.emailBody = emailBody;
	}
	

	/**
	 * @return the emailFrom
	 */
	public String getEmailFrom() {
		return emailFrom;
	}

	/**
	 * @param emailFrom the emailFrom to set
	 */
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	/**
	 * @return the emailTo
	 */
	public String getEmailTo() {
		return emailTo;
	}

	/**
	 * @param emailTo the emailTo to set
	 */
	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	/**
	 * @return the emailSubject
	 */
	public String getEmailSubject() {
		return emailSubject;
	}

	/**
	 * @param emailSubject the emailSubject to set
	 */
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	/**
	 * @return the emailBody
	 */
	public String getEmailBody() {
		return emailBody;
	}

	/**
	 * @param emailBody the emailBody to set
	 */
	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	@Override
	public String toString() {
		return "EmailConfigBO [emailFrom=" + emailFrom + ", emailTo=" + emailTo + ", emailSubject=" + emailSubject
				+ ", emailBody=" + emailBody + ", hashCode()=" + hashCode() + "]";
	}
}
