package com.test;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String userId;
	private String userName;
	private String message;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String execute() throws Exception {
		//실행하지 않아도 무조건 실행됨
		
		message = userName + " 님 방가방가 ^^ ";
		return SUCCESS; 

		// SUCCESS 에 사용자정의해서 사용 가능 
		// INPUT 도 있음
//		return INPUT;
		
	}

}
