package com.shitian.modules.front.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.jetty.util.StringUtil;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.mchange.lang.StringUtils;

/**
 * 用户Model：相当于entity+dao+service层
 * @author kangshaoxiong
 * 1)数据库字段名建议使用驼峰命名规则，便于与 java 代码保持一致，如字段名： userName
 * 2)所有 sql 与业务逻辑写在 Model 或 Service 中，不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
 */
public class User extends Model<User>{
	
	private static final long serialVersionUID = 2764189175186729813L;
	
	//保证所有线程获取到一个User实例
	public static final User dao = new User();
	
	/**
	 * 注册/添加用户
	* @Title: addUser
	* @Description: 所有的添加更新删除操作必须添加事物管理：此处使用声明式事物
	* @param @param userMap    
	* @return void  
	* @throws
	 */
	@Before(Tx.class)
	public static boolean addUser(Map<String,Object> userMap){
		return new User()._setAttrs(userMap).save();
	}
	
	/**
	 * 更新用户信息
	* @Title: updateUser
	* @Description: TODO
	* @param @param id
	* @param @param userMap
	* @return boolean  
	* @throws
	 */
	@Before(Tx.class)
	public static boolean updateUser(long id,Map<String,Object> userMap){
		return User.dao.findById(id)._setAttrs(userMap).update();
	}
	
	/**
	 * 删除用户
	* @Title: deleteUser
	* @Description: TODO
	* @param @param id
	* @param @return    
	* @return boolean  
	* @throws
	 */
	@Before(Tx.class)
	public static boolean deleteUser(long id){
		return User.dao.deleteById(id);
	}
	
	/***
	 * 用户信息列表
	* @Title: getUserPage
	* @Description: TODO
	* @param @param currPage
	* @param @param pageSize
	* @param @param name
	* @param @param realityName
	* @param @return    
	* @return Page<User>  
	* @throws
	 */
	public static Page<User> getUserPage(int currPage,int pageSize,String name,String realityName){
	   StringBuffer sql = new StringBuffer("select * from t_user where 1=1 ");
	   List<Object> params = new ArrayList<Object>();
	   if(name!=null&&!"".equals(name)){
		   sql.append(" and name like ? ");
		   params.add("%"+name+"%");
	   }
	   if(realityName!=null&&!"".equals(realityName)){
		   sql.append(" and realityName like ? ");
		   params.add("%"+realityName+"%");
	   }
	   
	   Page<User> userPage = User.dao.paginate(currPage,pageSize,sql.toString(),params.toArray());
	   return userPage;
	}
}
