package com.mindtree.propertytaxapp.exception;

/**
 * @author M1056078
 *
 */
public class PropertyTaxException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PropertyTaxException() {
		
	}

	public PropertyTaxException(String message) {
		super(message);
		
	}

	public PropertyTaxException(Throwable cause) {
		super(cause);
		
	}

	public PropertyTaxException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PropertyTaxException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
