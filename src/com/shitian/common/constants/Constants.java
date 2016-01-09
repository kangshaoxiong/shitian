package com.shitian.common.constants;

import com.jfinal.kit.PropKit;

/**
 * 系统常量设置
 * @author Administrator
 *
 */
public class Constants {
	static{
		 PropKit.use("applicationConfig.properties");		
	}
	
	public static final String viewPath = "/WEB-INF/view";
	
	/***
	 * 配置系统各个模块的访问路径
	 */
	public static final String frontUrl = PropKit.get("sys_frontUrl","/front");
	public static final String supervisorUrl = PropKit.get("sys_supervisorUrl","/supervisor");
	public static final String appUrl = PropKit.get("sys_appUrl","/app");
	public static final String bbsUrl = PropKit.get("sys_bbsUrl","/front/bbs");
	public static final String wechatUrl = PropKit.get("sys_wechatUrl","/wechat");
}
