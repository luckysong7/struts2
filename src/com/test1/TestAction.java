package com.test1;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private User user; // User ȣ��
	private String message;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public String execute() throws Exception {
		message = user.getUserName() + "�� �ȳ��ϼ���";
		
		return "ok"; // ���ϰ� (Ȯ��) - SUCCESS ��� ���ڷ� ��밡�� 
				
	}

}
