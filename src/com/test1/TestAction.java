package com.test1;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private User user; // User 호출
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
		message = user.getUserName() + "님 안녕하세요";
		
		return "ok"; // 리턴값 (확인) - SUCCESS 대신 문자로 사용가능 
				
	}

}
