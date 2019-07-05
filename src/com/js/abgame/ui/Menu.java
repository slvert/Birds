package com.js.abgame.ui;

import java.util.List;

import com.js.abgame.bird.Bird;
import com.js.abgame.dao.BirdDao;
import com.js.abgame.util.DataInit;

/**
	 * AbGame项目菜单类
	 * @author Abeni
	 *
	 */
public class Menu {
	/**
	 * 首页面菜单
	 */
		public static void loginMenu(){
			System.out.println("*************************");
			System.out.println("*	<<愤怒的小鸟>>	*");
			System.out.println("*	1、玩家登录	*");
			System.out.println("*	2、管理员登录 	*");
			System.out.println("*	0、退出游戏 	*");
			System.out.println("*************************");
		}
		/**
		 * 管理员操作菜单
		 */
		public static void adminMunu(){
			System.out.println("*************************");
			System.out.println();
			System.out.println("	系统管理		");
			System.out.println();
			System.out.println("	1、新增玩家");
			System.out.println();
			System.out.println("	2、修改玩家");
			System.out.println();
			System.out.println("	3、删除玩家");
			System.out.println();
			System.out.println("	4、查询玩家");
			System.out.println();
			System.out.println("	5、查询游戏");
			System.out.println();
			System.out.println("	6、分数统计");
			System.out.println();
			System.out.println("	7、参数设置");
			System.out.println();
			System.out.println("	0、返回上级");
			System.out.println();
			System.out.println("*************************");
		}
		/**
		 * 修改玩家信息的方法
		 */
		public static void updatePlayer() {
			System.out.println("*************************");
			System.out.println("\t"+"1.修改密码");
			System.out.println("\t"+"2.修改昵称");
			System.out.println("\t"+"3.修改性别");
			System.out.println("\t"+"4.修改年龄");
			System.out.println("\t"+"0.返回上级");
			System.out.println("*************************");
		}
		/**
		 * 玩家操作菜单
		 */
		public static void playerMeun() {
			System.out.println("*************************");
			System.out.println();
			System.out.println("	愤怒的小鸟		");
			System.out.println();
			System.out.println("	1、开始游戏");
			System.out.println();
			System.out.println("	2、查看成就");
			System.out.println();
			System.out.println("	0、返回上级");
			System.out.println();
			System.out.println("*************************");
		}
		/**
		 * 小鸟展示菜单
		 */
		public static void showBirds() {
			System.out.println("**************************************************");
			System.out.println();
			System.out.println("\t\t 请 选 择 小 鸟");
			//创建BireDao类的对象
			//BirdDao bd=new BirdDao();
			//调用查询全部小鸟的方法
		//	List<Bird> querAll = bd.querAll();
			//遍历数据库鸟表
			for (int i = 0; i < DataInit.birds.size(); i++) {
				//展示数据库里存的小鸟
				Bird birds=DataInit.birds.get(i);
				System.out.println(birds.getId()+"、"+birds.getColor()+"\t"+"攻击力"+birds.getAttact()+"\t"+"命中率"+birds.getHit()+"%");
			}
			System.out.println("0.返回上级");
			System.out.println("请选择：（五只小鸟发起攻击可以相同可以不同）");
			System.out.println("**************************************************");
		}
		/**
		 * 再来一局游戏的菜单
		 */
		public static void againGame() {
			System.out.println("1. 再来一局");
			System.out.println("0. 返回菜单");
			System.out.println("**************************************************");
		}
		/**
		 * 设置参数菜单
		 */
		public static void setparmmeter() {
			System.out.println("**************************************************");
			System.out.println("请 选 择 要 修 改 的 参 数");
			//创建BireDao类的对象
			//BirdDao bd=new BirdDao();
			//调用查询全部小鸟的方法
			//List<Bird> querAll = bd.querAll();
			for (int i = 0; i < DataInit.birds.size(); i++) {
				//展示集合里存的小鸟
				Bird birds=DataInit.birds.get(i);
				System.out.println(birds.getId()+"."+birds.getColor()+"\t"+"攻击力"+birds.getAttact()+"\t"+"命中率"+birds.getHit()+"%");
			}
			System.out.println("4.管理员登录名");
			System.out.println("5.管理员密码");
			System.out.println("6.管理员最多登录次数");
			System.out.println("0. 返 回 上 级");
		}
		public static void main(String[] args) {
			setparmmeter();
		}
}
