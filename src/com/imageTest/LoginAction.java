package com.imageTest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.util.dao.CommonDAO;
import com.util.dao.CommonDAOImpl;

public class LoginAction extends ActionSupport implements Preparable,
		ModelDriven<MemberDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();

	private MemberDTO dto;

	public MemberDTO getDto() {
		return dto;
	}

	@Override
	public MemberDTO getModel() {
		return dto;
	}

	@Override
	public void prepare() throws Exception {
		dto = new MemberDTO();
	}

	// 로그인 처리 메소드

	public String login() throws Exception {

		if (dto.getMode() == null || dto.getMode().equals("")) {
			return INPUT;
		}

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		CommonDAO dao = CommonDAOImpl.getInstance();

		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");

		System.out.println(userId);
		System.out.println(userPwd);

		MemberDTO dto2 = (MemberDTO) dao.getReadData("imageTest.getMember",
				userId);
		
		if (dto2 == null || !(dto2.getUserPwd().equals(userPwd))) {
			request.setAttribute("message", "아이디 또는 패스워드가 잘못되었습니다.");
			return ERROR;
		}

		CustomInfo info = new CustomInfo();
		info.setUserId(dto2.getUserId());
		info.setUserName(dto2.getUserName());

		session.setAttribute("customInfo", info);

		return SUCCESS;
	}

	public String signup() throws Exception {
		if (dto.getMode() == null || dto.getMode().equals("")) {
			return INPUT;
		}

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		CommonDAO dao = CommonDAOImpl.getInstance();

		dao.insertData("imageTest.signupMember", dto);

		return SUCCESS;

	}

	public String logout() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		if (session == null) {
			return ERROR;
		}
		session.removeAttribute("customInfo");
		session.invalidate();

		return SUCCESS;
	}

	public String searchPwd() throws Exception {
		if (dto.getMode() == null || dto.getMode().equals("")) {
			return INPUT;
		}

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		CommonDAO dao = CommonDAOImpl.getInstance();
		MemberDTO dto2= (MemberDTO) dao.getReadData("imageTest.getMember",	dto.getUserId());
		
		if(dto2 == null && dto.getMode().equals("search")){
			session.setAttribute("message2", "아이디가 존재하지 않습니다.");
			return ERROR;
		}
		if (dto2.getUserId().equals(dto.getUserId())
				&& !dto2.getUserTel().equals(dto.getUserTel())) {
			session.setAttribute("message2", "전화번호가 일치하지않습니다.");
			return ERROR;
		}
		if(dto2.getUserId().equals(dto.getUserId())
				&& dto2.getUserTel().equals(dto.getUserTel())){
		session.setAttribute("message2", "비밀번호는 " +dto2.getUserPwd() +"입니다.");
		return SUCCESS;
		}
		return NONE;

	}

}
