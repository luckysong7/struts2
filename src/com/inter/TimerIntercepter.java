package com.inter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TimerIntercepter extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	private static Log log = LogFactory.getLog(TimerIntercepter.class); // apache �� Import ���ֱ�
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		// ���ͼ��� ������
		long start = System.currentTimeMillis();
		
		// ���ͼ��� stack�� ���� ���ͼ��� �Ǵ� 
		// ������ ���ͼ��� �׼ǽ���
		String result = invocation.invoke();
		
		long end = System.currentTimeMillis();
		
		log.info("����ð�:" + (end-start) + "ms");
		
		return result;
	}
	

}
