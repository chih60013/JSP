package com.lcpan.bean;

public class StringBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
