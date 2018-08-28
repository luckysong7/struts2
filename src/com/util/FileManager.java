package com.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;

public class FileManager {

	// path : ������ ������ ���
	// ���� : ������ ����� ���ο� ���ϸ�
	public static String doFileUpload(File file, String originalFileName, String path) throws Exception {
		String newFileName = null;

		if(file == null)
			return null;
		
		// Ŭ���̾�Ʈ�� ���ε��� ������ �̸�
		if(originalFileName.equals(""))
			return null;
		
		// Ȯ����
		String fileExt = originalFileName.substring(originalFileName.lastIndexOf("."));
		if(fileExt == null || fileExt.equals(""))
			return null;
		
		// ������ ������ ���ο� ���ϸ��� �����.
		newFileName = String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", 
				         Calendar.getInstance());
		newFileName += System.nanoTime();
		newFileName += fileExt;
		
		// ���ε��� ��ΰ� �������� �ʴ� ��� ������ ���� �Ѵ�.
		File dir = new File(path);
		if(!dir.exists())
			dir.mkdirs();
		
		String fullFileName = path + File.separator + newFileName;
		
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(fullFileName);
		int bytesRead = 0;
        byte[] buffer = new byte[1024];
        while ((bytesRead = fis.read(buffer, 0, 1024)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }
        fos.close();
        fis.close();
		
		return newFileName;
	}
	
	// ���� �ٿ�ε�
	// saveFileName : ������ ����� ���ϸ�
	// originalFileName : Ŭ���̾�Ʈ�� ���ε��� ���ϸ�
	// path : ������ ����� ���
	public static boolean doFileDownload(String saveFileName, String originalFileName, String path, HttpServletResponse response) {
		String load_dir = path + File.separator + saveFileName;
		
        try {
    		if(originalFileName == null || originalFileName.equals(""))
    			originalFileName = saveFileName;
        	originalFileName = new String(originalFileName.getBytes("euc-kr"),"8859_1");
        } catch (UnsupportedEncodingException e) {
        }

	    try {
	        File file = new File(load_dir);

	        if (file.exists()){
	            byte readByte[] = new byte[4096];

	            response.setContentType("application/octet-stream");
				response.setHeader(
						"Content-disposition",
						"attachment;filename=" + originalFileName);

	            BufferedInputStream  fin  = new BufferedInputStream(new FileInputStream(file));
	            //javax.servlet.ServletOutputStream outs =	response.getOutputStream();
	            OutputStream outs = response.getOutputStream();
	            
	   			int read;
	    		while ((read = fin.read(readByte, 0, 4096)) != -1)
	    				outs.write(readByte, 0, read);
	    		outs.flush();
	    		outs.close();
	            fin.close();
	            
	            return true;
	        }
	    } catch(Exception e) {
	    }
	    
	    return false;
	}
	
	// ���� ���� ����
	public static void doFileDelete(String fileName, String path) 
	        throws Exception {
		File file = null;
		String fullFileName = path + "\\"+ fileName;
		
        file = new java.io.File(fullFileName);
        
        if (file.exists())
           file.delete();
	}	
}
