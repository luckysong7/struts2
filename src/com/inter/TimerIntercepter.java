package com.inter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TimerIntercepter extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	private static Log log = LogFactory.getLog(TimerIntercepter.class); // apache 꺼 Import 해주기
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		// 인터셉터 실행전
		long start = System.currentTimeMillis();
		
		// 인터셉터 stack의 다음 인터셉터 또는 
		// 마지막 인터셉터 액션실행
		String result = invocation.invoke();
		
		long end = System.currentTimeMillis();
		
		log.info("실행시간:" + (end-start) + "ms");
		
		return result;
	}
	

}
