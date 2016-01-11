package com.shitian.modules.front.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.shitian.common.interceptor.DemoInterceptor;
import com.shitian.modules.front.model.User;

/**
 * 测试使用的用户Controller
 * 可修改为正式开发可使用的
* @ClassName: UserController
* @Description: TODO
* @author kangshaoxiong
* @date 2016年1月9日 上午10:09:16
*
 */
@Before(DemoInterceptor.class)
public class UserController extends Controller{
	
	public void index(){
		renderText("hello Jfinal");
	}
	
	/**
	 * 所有用户列表
	 */
	public void allUsers(){
		System.out.println(User.getUserPage(getParaToInt("currentPage",1),getParaToInt("pageSize",10),"",""));
		setAttr("userPage",User.getUserPage(getParaToInt("currentPage",1),getParaToInt("pageSize",10),"",""));
		render("allUsers.html");
	}
}
