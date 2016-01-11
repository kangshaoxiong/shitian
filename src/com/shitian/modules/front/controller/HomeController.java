package com.shitian.modules.front.controller;

import com.jfinal.core.Controller;

/**
 * 前台首页
* @ClassName: IndexController
* @Description: TODO
* @author kangshaoxiong
* @date 2016年1月11日 上午9:29:00
*
 */
public class HomeController extends Controller{
	public void index(){
		render("index.html");
	}
}
