package com.js.abgame.util;
/**
* 数据初始化类 初始化小鸟和管理员信息
 * @author Abeni
 *
 */

import java.util.ArrayList;
import java.util.List;

import com.js.abgame.bean.AdminBean;
import com.js.abgame.bird.Bird;
import com.js.abgame.bird.BlackBird;
import com.js.abgame.bird.BlueBird;
import com.js.abgame.bird.RedBird;
import com.js.abgame.dao.BirdDao;

public class DataInit {
	/**
	 * 新建鸟类集合 用于存放三只鸟
	 */
	public static List<Bird> birds=new ArrayList<>();
	//初始化管理员信息
	public static AdminBean admin=null;
	/**
	 * 静态代码块  小鸟数据初始化
	 */
	static {
		//获取管理员信息
		admin=XmlGetAdmin.getAdminMsg();
		//创建BirdDao类对象
		BirdDao bd=new BirdDao();
		//小鸟集合等于查询数据库小鸟
		birds=bd.querAll();

	}
	/**
	 * 重新获取数据
	 */
	public static void update() {
		//重新获取
		admin=XmlGetAdmin.getAdminMsg();
		//创建BirdDao类对象
		BirdDao bd=new BirdDao();
		//小鸟集合等于查询数据库小鸟
		birds=bd.querAll();
	}
}
