package com.js.abgame.main;

import com.js.abgame.help.InputHelp;
import com.js.abgame.ui.Menu;

/**
	 * 作为主类
	 * @author Administrator
	 *
	 */
public class AbGame {
	/**
	 * 游戏开始的方法
	 */
	//创建管理员管理类对象
	AdminManager admin=new AdminManager();
	//创建玩家管理类对象
	PlayerManager pManager=new PlayerManager();
	public void start(){
		//定义开关
		boolean flag=true;
		//首页面循环
		while (flag) {
			//打印首页面菜单 调用首页面方法 类名.方法名(静态方法)
			Menu.loginMenu();
			//调用输入数字的方法，带返回值
			int choose=InputHelp.getInt("数字");
			//分支选择
			switch (choose) {
			case 1://玩家操作
				//调用玩家方法
				pManager.playOp();
				break;
			case 2://管理员操作
				//调用管理员操作类方法
				admin.adminOp();
				break;
			case 0://退出 关闭开关
				flag=false;
				break;

			default:
				System.out.println("请输入0-2之间的数字");
				break;
			}
		}
	}
	/**
	 * 程序的主入口
	 * @param args
	 */
	public static void main(String [] args){
		//创建本类对象
		AbGame ab=new AbGame();
		//调用开始游戏方法
		ab.start();
	}
}
	
