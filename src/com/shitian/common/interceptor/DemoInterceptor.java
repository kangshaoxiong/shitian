package com.shitian.common.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.shitian.common.constants.Constants;

public class DemoInterceptor implements Interceptor {
	public void intercept(Invocation inv) {
		System.out.println("Before method invoking");
		System.out.println("-----"+Constants.supervisorUrl);
		inv.invoke();
		System.out.println("After method invoking");
	}
}
