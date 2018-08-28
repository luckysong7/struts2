package com.util;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MyUtil {
	// ���ڿ��� ������ ���ϴ� ���ڿ��� �ٸ� ���ڿ��� ��ȯ
	// String str = replaceAll(str, "\r\n", "<br>"); // ���͸� <br>�� ��ȯ
	public String replaceAll(String str, String oldStr, String newStr) {
		if(str == null || str.equals(""))
			return "";
		
		Pattern p = Pattern.compile(oldStr);
		Matcher m = p.matcher(str);
		
		StringBuffer sb = new StringBuffer();
		
		while(m.find()) {
			m.appendReplacement(sb, newStr);
		}
		m.appendTail(sb);
		
		return sb.toString();
	}

 // *******************************************************************************
    // ������ �� ���ϱ�
	public int getPageCount(int numPerPage, int dataCount) {
		int pageCount = 0;
		int remain;

		 // �� ������ ���� ���ϱ� ���� ������ ���
		remain = dataCount % numPerPage;
		if(remain == 0)
			pageCount = dataCount / numPerPage;
		else
			pageCount = dataCount / numPerPage + 1;

		return pageCount;
	}
    
// Get ��Ŀ� ���� ������ ó�� �޼��� *************************************
    public String pageIndexList(int current_page, int total_page, String list_url) {
        int numPerBlock = 10;   // ����Ʈ�� ��Ÿ�� ������ ��
        int currentPageSetUp;
        int n;
        int page;
        StringBuffer strList = new StringBuffer();
        
        if(current_page == 0)
        	return "";
        
        if(list_url.indexOf("?") != -1)
        	list_url = list_url + "&";
        else
        	list_url = list_url +"?";

        // ǥ���� ù ������
        currentPageSetUp = (current_page / numPerBlock) * numPerBlock;
        if (current_page % numPerBlock == 0)
            currentPageSetUp = currentPageSetUp - numPerBlock;

        // 1 ������
        if ((total_page > numPerBlock) && (currentPageSetUp > 0)) {
           strList.append("<a href='"+list_url+"pageNum=1'>1</a> ");
        }

        // [Prev] : �� ���������� numPerBlock �̻��� ��� ���� numPerBlock ������
        n = current_page - numPerBlock;
        if (total_page > numPerBlock && currentPageSetUp > 0) {
           strList.append("[<a href='"+list_url+"pageNum="+n+"'>Prev</a>] ");
        }

        // �ٷΰ��� ������ ����
        page = currentPageSetUp + 1;
        while((page <= total_page) && (page <= currentPageSetUp + numPerBlock)) {
           if(page == current_page) {
             strList.append("<font color='Fuchsia'>"+page+" </font>");
           }
           else {
             strList.append("<a href='"+list_url+"pageNum="+page+"'>"+page+"</a> ");
           }
           page++;
        }
        
        // [Next] : �� ���������� numPerBlock ������ �̻��� ��� ���� numPerBlock �������� ������
        // n = currentPageSetUp + numPerBlock + 1;
        n = current_page + numPerBlock;
        if (total_page - currentPageSetUp > numPerBlock) {
			strList.append("[<a href='"+list_url+"pageNum="+n+"'>Next</a>] ");
        }

        // ������ ������
        if ((total_page > numPerBlock) && (currentPageSetUp + numPerBlock < total_page)) {
			strList.append("<a href='"+list_url+"pageNum="+total_page+"'>"+total_page+"</a>");
        }

        return strList.toString();
    }
    
    // �ڹ� ��ũ��Ʈ(listPage �Լ�)�� ���� ������ ó�� �޼���(prototype ��) ***********************
    public String pageIndexList(int current_page, int total_page) {
        int numPerBlock = 10;   // ����Ʈ�� ��Ÿ�� ������ ��
        int currentPageSetUp;
        int n;
        int page;
        String strList="";
        
        if(current_page == 0)
        	return "";

        // ǥ���� ù ������
        currentPageSetUp = (current_page / numPerBlock) * numPerBlock;
        if (current_page % numPerBlock == 0)
            currentPageSetUp = currentPageSetUp - numPerBlock;

        // 1 ������
        if ((total_page > numPerBlock) && (currentPageSetUp > 0)) {
            strList = "<a onclick='listPage(1);'>1</a> ";
        }

        // [Prev] : �� ���������� numPerBlock �̻��� ��� ���� numPerBlock ������
        n = current_page - numPerBlock;
        if (total_page > numPerBlock && currentPageSetUp > 0) {
            strList = strList + "[<a onclick='listPage("+n+");'>Prev</a>] ";
        }

        // �ٷΰ��� ������ ����
        page = currentPageSetUp + 1;
        while((page <= total_page) && (page <= currentPageSetUp + numPerBlock)) {
           if(page == current_page) {
               strList = strList + "<font color='Fuchsia'>"+page+" </font>";
           }
           else {
               strList = strList +"<a onclick='listPage("+page+");'>"+page+"</a> ";
           }
           page++;
        }

        // [Next] : �� ���������� numPerBlock ������ �̻��� ��� ���� numPerBlock �������� ������
        // n = currentPageSetUp + numPerBlock + 1;
        n = current_page + numPerBlock;
        if (total_page - currentPageSetUp > numPerBlock) {
            strList = strList + "[<a onclick='listPage("+n+");'>Next</a>] ";
        }

        // ������ ������
        if ((total_page > numPerBlock) && (currentPageSetUp + numPerBlock < total_page)) {
            strList = strList + "<a onclick='listPage("+total_page+");'>"+total_page+"</a>";
        }

        return strList;
    }
// *******************************************************************************
    
 // Ajax(Dojo) ������ ó�� �޼��� *************************************
    public String ajaxPageIndexList(int current_page, int total_page, String list_url, String targets) {
        int numPerBlock = 10;   // ����Ʈ�� ��Ÿ�� ������ ��
        int currentPageSetUp;
        int n;
        int page;
        StringBuffer strList = new StringBuffer();
        
        if(current_page == 0)
        	return "";
        
        if(list_url.indexOf("?") != -1)
        	list_url = list_url + "&";
        else
        	list_url = list_url +"?";

        // ǥ���� ù ������
        currentPageSetUp = (current_page / numPerBlock) * numPerBlock;
        if (current_page % numPerBlock == 0)
            currentPageSetUp = currentPageSetUp - numPerBlock;

        // 1 ������
        if ((total_page > numPerBlock) && (currentPageSetUp > 0)) {
           strList.append("<a dojoType='struts:BindAnchor' href='"+list_url+"pageNo=1' targets='"+targets+"' showError='true'>1</a> ");
        }

        // [Prev] : �� ���������� numPerBlock �̻��� ��� ���� numPerBlock ������
        n = current_page - numPerBlock;
        if (total_page > numPerBlock && currentPageSetUp > 0) {
           strList.append("[<a dojoType='struts:BindAnchor' href='"+list_url+"pageNo="+n+"' targets='"+targets+"' showError='true'>Prev</a>] ");
        }

        // �ٷΰ��� ������ ����
        page = currentPageSetUp + 1;
        while((page <= total_page) && (page <= currentPageSetUp + numPerBlock)) {
           if(page == current_page) {
             strList.append("<font color='Fuchsia'>"+page+" </font>");
           }
           else {
             strList.append("<a dojoType='struts:BindAnchor' href='"+list_url+"pageNo="+page+"' targets='"+targets+"' showError='true'>"+page+"</a> ");
           }
           page++;
        }

        // [Next] : �� ���������� numPerBlock ������ �̻��� ��� ���� numPerBlock �������� ������
        n = current_page + numPerBlock;
        if (total_page - currentPageSetUp > numPerBlock) {
			strList.append("[<a dojoType='struts:BindAnchor' href='"+list_url+"pageNo="+n+"' targets='"+targets+"' showError='true'>Next</a>] ");
        }

        // ������ ������
        if ((total_page > numPerBlock) && (currentPageSetUp + numPerBlock < total_page)) {
			strList.append("<a dojoType='struts:BindAnchor' href='"+list_url+"pageNo="+total_page+"' targets='"+targets+"' showError='true'>"+total_page+"</a>");
        }

        return strList.toString();
    }
// *******************************************************************************
    
// *******************************************************************************
	// E-Mail �˻�
    public boolean isEmail(String email) {
        if (email==null) return false;
        boolean b = Pattern.matches(
            "[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+", 
            email.trim());
        return b;
    }

	// NULL �� ��� ""�� 
    public String checkNull(String str) {
        String strTmp;
        if (str == null)
            strTmp = "";
        else
            strTmp = str;
        return strTmp;
    }
    
    // 8859_1 �� euc-kr��
    public String isoToEuc(String str) {
        String convStr = null;
        try {
            if(str == null)
                return "";

            convStr = new String(str.getBytes("8859_1"),"euc-kr");
        } catch (UnsupportedEncodingException e) {
        }
        return convStr;
    }

    // 8859_1 �� utf-8��
    public String isoToUtf(String str) {
        String convStr = null;
        try {
            if(str == null)
                return "";

            convStr = new String(str.getBytes("8859_1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
        }
        return convStr;
    }

    // euc-kr �� ISO-8859-1 ��
    public String eucToIso(String str) {
        String convStr = null;
        try {
            if(str == null)
                return "";

            convStr = new String(str.getBytes("euc-kr"),"8859_1");
        } catch (UnsupportedEncodingException e) {
        }
        return convStr;
    }
    
    // KSC56O1 �� 8859_1��
    public String fromKorean(String str) {
        String convStr = null;
        try {
            if(str == null)
                return "";

            convStr = new String(str.getBytes("KSC5601"),"8859_1");
        } catch (UnsupportedEncodingException e) {
        }
        return convStr;
    }
    
    // euc-kr �� KSC5601 ��
    public String eucToKsc(String str) {
        String convStr = null;
        try {
            if(str == null)
                return "";

            convStr = new String(str.getBytes("euc-kr"),"8859_1");
            convStr = new String(convStr.getBytes("8859_1"),"KSC5601");
        } catch (UnsupportedEncodingException e) {
        }
        return convStr;
    }
}
