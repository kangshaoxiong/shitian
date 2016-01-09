package com.shitian.common.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.shitian.common.model._MappingKit;
import com.shitian.modules.app.route.AppRoutes;
import com.shitian.modules.bbs.route.BBSRoutes;
import com.shitian.modules.front.route.FrontRoutes;
import com.shitian.modules.supervisor.route.SupervisorRoutes;
import com.shitian.modules.wechat.route.WeChatRoutes;
/**
 * API引导式配置
 * @author kangshaoxiong
 *
 */
public class ApplicationConfig extends JFinalConfig {

	/**
	 * 配置常量
	 */
	@Override
	public void configConstant(Constants me) {
		// 加载少量必要配置，随后可用PropKit.get(...)获取值
		PropKit.use("applicationConfig.properties");
		// 配制运行模式
		me.setDevMode(PropKit.getBoolean("devMode", false));
		// 系统视图模型(默认使用FREE_MARKER)
		//me.setViewType(ViewType.FREE_MARKER);
		// 视图存放路径
		me.setBaseViewPath("/WEB-INF/view");
	}

	/**
	 *  配置路由
	 */
	@Override
	public void configRoute(Routes me) {
		// 前台路由
		me.add(new FrontRoutes());
		// 前台BBS路由
		me.add(new BBSRoutes());
		// 后台路由
		me.add(new SupervisorRoutes());
		// 微信路由
		me.add(new WeChatRoutes());
		// app路由
		me.add(new AppRoutes());
	}

	/**
	 * 配置插件
	 */
	@Override
	public void configPlugin(Plugins me) {
		// 配置C3p0数据库连接池插件
		C3p0Plugin C3p0Plugin = createC3p0Plugin();
		me.add(C3p0Plugin);
		
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(C3p0Plugin);
		me.add(arp);
		
		// 配置mysql方言
		arp.setDialect(new MysqlDialect());
		
		// 所有配置在 MappingKit 中搞定
		_MappingKit.mapping(arp);
	}

	/**
	 * 配置全局拦截器
	 */
	@Override
	public void configInterceptor(Interceptors me) {

	}

	/**
	 * 配置处理器
	 */
	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 获取c3p0数据源
	 * @return
	 */
	public static C3p0Plugin createC3p0Plugin() {
		return new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
	}
	
	/**
	 * 建议使用 JFinal 手册推荐的方式启动项目
	 * 运行此 main 方法可以启动项目，此main方法可以放置在任意的Class类定义中，不一定要放于此
	 */
	public static void main(String[] args) {
		JFinal.start("WebRoot", 80, "/", 5);
	}
}
