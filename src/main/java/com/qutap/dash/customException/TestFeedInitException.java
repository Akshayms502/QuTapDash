package com.qutap.dash.customException;

public class TestFeedInitException extends Exception {
	private static final long serialVersionUID = 1L;
	public TestFeedInitException(String msg,Exception e){
		super(msg,e);

	}

}
