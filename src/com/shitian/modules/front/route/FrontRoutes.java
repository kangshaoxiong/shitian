package com.shitian.modules.front.route;

import com.jfinal.config.Routes;
import com.shitian.common.constants.Constants;
import com.shitian.modules.front.controller.UserController;

public class FrontRoutes extends Routes{

	@Override
	public void config() {
		//param1:请求路径  param2:请求方法  param3:视图存放路径
		add(Constants.frontUrl+"/user", UserController.class);
	}

}
