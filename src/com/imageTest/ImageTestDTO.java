package com.imageTest;

import java.io.File;

public class ImageTestDTO {

	private int num;
	private String subject;
	private String saveFileName;

	private String mode; // ȭ�� ������

	private File upload;

	// ������ ������ upload�� FileName ���ڸ�
	// �ٿ��� ������ ����� Struts2�� �ڵ�����
	// �����̸��� �־��ش�.
	// upload+FileName (�ڵ����� ���ϸ� ����)
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
