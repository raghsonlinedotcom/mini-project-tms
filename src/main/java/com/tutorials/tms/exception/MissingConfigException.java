/**
 * 
 */
package com.tutorials.tms.exception;

/**
 * @author raghavan.muthu
 *
 */
public class MissingConfigException extends Exception {

	private static final long serialVersionUID = 311505286480952273L;
	
	public MissingConfigException(String message) {
		super(message);
	}
	
	public MissingConfigException(String message, Throwable cause) {
		super(message, cause);
	}

}
