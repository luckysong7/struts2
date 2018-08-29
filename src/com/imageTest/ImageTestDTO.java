package com.imageTest;

import java.io.File;

public class ImageTestDTO {

	private int num;
	private String subject;
	private String saveFileName;

	private String mode; // 화면 구분자

	private File upload;

	// 위에서 정의한 upload에 FileName 문자를
	// 붙여서 변수를 만들면 Struts2가 자동으로
	// 파일이름을 넣어준다.
	// upload+FileName (자동으로 파일명 전달)
	private String uploadFileName;

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

}
