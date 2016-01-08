package com.shitian.modules.front.route;

import com.jfinal.config.Routes;
import com.shitian.modules.front.controller.UserController;

public class FrontRoutes extends Routes{

	@Override
	public void config() {
		add("/front/user", UserController.class);
	}

}
