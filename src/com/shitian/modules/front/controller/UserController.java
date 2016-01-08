package com.shitian.modules.front.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.shitian.common.interceptor.DemoInterceptor;

@Before(DemoInterceptor.class)
public class UserController extends Controller{
	public void index(){
		renderText("hello Jfinal");
	}
}
