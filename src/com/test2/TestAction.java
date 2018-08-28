package com.test2;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

// ModelDriven


public class TestAction extends ActionSupport implements ModelDriven<User>, Preparable{

	private static final long serialVersionUID = 1L;

	//************************** 기 본 틀 *****************************
	
	private User dto;
	
	public User getDto() {
		return dto;
	}
	// getter 만 만들어 주면 된다.
	// setter 는 알아서 만들어준다 !! (Model Driven이 알아서) 
	// DATA 가 자동으로 넘어감

	@Override
	public User getModel() { // Model Driven 꺼 
		return dto;
	}
	
	@Override
	public void prepare() throws Exception {
		dto = new User(); // 객체 생성 (수동)
	}
	
	//*****************************************************************
	
	public String created() throws Exception {
		if(dto == null || dto.getMode() == null || dto.getMode().equals("")){ // null 과 "" 순서 바뀌면 안됨 
			return INPUT; // 널
		}
		
		// requst 를 필요할때마다 만들어야함 
		HttpServletRequest requset = ServletActionContext.getRequest(); 
		requset.setAttribute("message", "스트럿츠2");
//		requset.setAttribute("dto", dto);
		return SUCCESS; // 성공
		
	}


	
	
}
