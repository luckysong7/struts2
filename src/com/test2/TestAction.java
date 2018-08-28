package com.test2;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

// ModelDriven


public class TestAction extends ActionSupport implements ModelDriven<User>, Preparable{

	private static final long serialVersionUID = 1L;

	//************************** �� �� Ʋ *****************************
	
	private User dto;
	
	public User getDto() {
		return dto;
	}
	// getter �� ����� �ָ� �ȴ�.
	// setter �� �˾Ƽ� ������ش� !! (Model Driven�� �˾Ƽ�) 
	// DATA �� �ڵ����� �Ѿ

	@Override
	public User getModel() { // Model Driven �� 
		return dto;
	}
	
	@Override
	public void prepare() throws Exception {
		dto = new User(); // ��ü ���� (����)
	}
	
	//*****************************************************************
	
	public String created() throws Exception {
		if(dto == null || dto.getMode() == null || dto.getMode().equals("")){ // null �� "" ���� �ٲ�� �ȵ� 
			return INPUT; // ��
		}
		
		// requst �� �ʿ��Ҷ����� �������� 
		HttpServletRequest requset = ServletActionContext.getRequest(); 
		requset.setAttribute("message", "��Ʈ����2");
//		requset.setAttribute("dto", dto);
		return SUCCESS; // ����
		
	}


	
	
}
