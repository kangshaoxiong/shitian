package com.shitian.modules.front.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.shitian.common.constants.Constants;
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
		setAttr("userPage",User.getUserPage(getParaToInt("currentPage",1),getParaToInt("pageSize",10),"",""));
		render("allUsers.html");
	} 
	
	/**
	 * 删除用户
	 */
	public void deleteUser(){
		boolean flag = User.deleteUser(getParaToLong("userId"));
		if(flag){			
			setAttr("msg","删除成功！");
		}else{
			setAttr("msg", "删除失败！");
		}
		redirect(Constants.frontUrl+"/user/allUsers");
	}
	
	/**
	 * 添加用户页面
	 */
	public void addUserInit(){
		render("addUser.html");
	}
	
	/**
	 * 添加用户
	 */
	public void addUser(){
		//方式一:页面user.XXX修改为XXX
		/*Map<String,Object> map = new HashMap<String,Object>();
		map.put("name",getPara("name","丽丽"));
		map.put("realityName", getPara("realityName", "唐丽"));
		map.put("mobile",getPara("mobile"));
		map.put("cardId",getPara("cardId"));
		map.put("email", getPara("email"));
		map.put("loginTime",new Date());
		map.put("loginIP","127.0.0.1");
		boolean flag = User.addUser(map);*/
		//方式二
		User user = getModel(User.class);
		boolean flag = User.addUserOfModel(user);
		if(flag){			
			setAttr("msg","添加成功！");
		}else{
			setAttr("msg", "添加失败！");
		}
		redirect(Constants.frontUrl+"/user/allUsers");
	}
	
	/**
	 * 更新用户初始化
	 */
	public void updateUserInit(){
		User user = User.dao.findById(getParaToLong("userId"));
		setAttr("user",user);
		render("updateUser.html");
	}
	
	/**
	 * 更新用户
	 */
	public void updateUser(){
		//方式一：页面user.XXX修改为XXX
		/*Map<String,Object> map = new HashMap<String,Object>();
		map.put("name",getPara("name","丽丽"));
		map.put("realityName", getPara("realityName", "唐丽"));
		map.put("mobile",getPara("mobile"));
		map.put("cardId",getPara("cardId"));
		map.put("email", getPara("email"));
		map.put("loginTime",new Date());
		boolean flag = User.updateUser(getParaToLong("userId",1L), map);*/
		
		//方式二
		User user = getModel(User.class); 
		boolean flag = User.updateUserOfModel(getParaToLong("userId",1L), user);
		if(flag){			
			setAttr("msg","修改成功！");
		}else{
			setAttr("msg", "修改失败！");
		}
		redirect(Constants.frontUrl+"/user/allUsers");
	}
}
