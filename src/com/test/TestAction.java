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
		//�������� �ʾƵ� ������ �����
		
		message = userName + " �� �氡�氡 ^^ ";
		return SUCCESS; 

		// SUCCESS �� ����������ؼ� ��� ���� 
		// INPUT �� ����
//		return INPUT;
		
	}

}
