package com.imageTest;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequest;






import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.sun.net.httpserver.HttpsConfigurator;
import com.util.FileManager;
import com.util.dao.CommonDAO;
import com.util.dao.CommonDAOImpl;

public class ImageTestAction extends ActionSupport implements Preparable,
		ModelDriven<ImageTestDTO> {

	
	private static final long serialVersionUID = 1L;
	// ***********************************************************
	private ImageTestDTO dto;

	public ImageTestDTO getDto() {
		return dto;
	}

	@Override
	public ImageTestDTO getModel() {
		return dto;
	}

	@Override
	public void prepare() throws Exception {

		dto = new ImageTestDTO();
	}

	// ***********************************************************

	public String created() throws Exception {

		if (dto == null || dto.getMode() == null || dto.getMode().equals("")) {
			
			return INPUT;
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		CommonDAO dao = CommonDAOImpl.getInstance();


		// 파일 업로드 필요 코딩 시작-------------------------------------------

		// 파일 저장할 경로
		// 생략 가능 String root = pageContext.getServletContext().getRealPath("/");
		String root = session.getServletContext().getRealPath("/");
		String savePath = root + File.separator + "pds" + File.separator
				+ "imageFile";


		// 파일 업로드 필요 코딩 끝--------------------------------------------

		// 파일 업로드
	
		saveFileName = FileManager.doFileUpload(dto.getUpload(),
				dto.getUploadFileName(), savePath);

		originalFileName = dto.getUploadFileName();

		return SUCCESS;

	}

	public String list() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String cp = request.getContextPath();
		CommonDAO dao = CommonDAOImpl.getInstance();
		
		com.util.MyUtil myUtil = new com.util.MyUtil();
		
		// client로부터 넘어온 페이지 번호
		String pageNum = request.getParameter("pageNum");

		int currentPage = 1;

		// 처음 실행시 null
		if (pageNum != null) {
			currentPage = Integer.parseInt(pageNum);

		}
		
		// 전체 데이터 개수 구하기
		int numPerPage = 9;
		int totalPage = 0;
		int totalDataCount = 0;
		
		totalDataCount = dao.getIntValue("imageTest.getDataCount");

		if(totalDataCount != 0){
			totalPage =myUtil.getPageCount(numPerPage, totalDataCount);
		}
		
		// 삭제로 전체페이지수보다 표시할 페이지가 큰 경우
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}

		// 데이터의 시작과 끝
		int start = (currentPage - 1) * numPerPage + 1;
		int end = currentPage * numPerPage;
		
		Map<String, Object> hMap = new HashMap<String, Object>();
		hMap.put("start", start);
		hMap.put("end", end);
		List<Object> lists = (List<Object>) dao.getListData("imageTest.getList", hMap);
		String urlList = cp + "/imageTest/list.action";
		request.setAttribute("lists", lists);
		request.setAttribute("totalDataCount", totalDataCount);
		request.setAttribute("pageIndexList",myUtil.pageIndexList(currentPage, totalPage, urlList));
	
		return SUCCESS;

	}
	
	private InputStream inputStream;
	private String saveFileName;
	private String originalFileName;

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	
	
}
