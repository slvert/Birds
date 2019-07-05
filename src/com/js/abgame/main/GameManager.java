package com.js.abgame.main;
/**
 *游戏管理类
 * @author Abeni
 *
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.js.abgame.bean.GameBean;
import com.js.abgame.bird.Bird;
import com.js.abgame.bird.BlackBird;
import com.js.abgame.bird.BlueBird;
import com.js.abgame.bird.RedBird;
import com.js.abgame.dao.GameDao;
import com.js.abgame.help.BirdHelp;
import com.js.abgame.help.InputHelp;
import com.js.abgame.ui.Menu;
import com.js.abgame.util.DataInit;
import com.js.abgame.util.DateUtil;

public class GameManager {
	//创建玩家游戏信息集合
	public static List<GameBean> gamesBeans=new ArrayList<GameBean>();
	//定义开关
	public  boolean flag;
	/**
	 * 开始游戏的方法
	 */
	public  void startGame(String name) {
		//循环游戏开关
		flag=true;
		//循环游戏
		while (flag) {
		//创建小鸟帮助类对象
		BirdHelp bHelp=new BirdHelp();
		//定义分数变量
		int sum=0;
		//调用开始游戏菜单
		Menu.showBirds();
		//调出循环选择小鸟的方法
		bHelp.chooseFive();
		//判断集合元素个数不满5时跳出方法
		if (bHelp.cBirds.size()<5) {
			//跳出当前方法
			return;
		}
		for (Bird bird : bHelp.cBirds) {
			//调出小鸟展示方法
			bird.show();
			//调出攻击的方法 接受攻击方法的返回值作为分数
			int score=bird.birdAttact();
			sum+=score;
		}
		System.out.println("攻击结束，你的分数为:"+sum);
		/**
		 * 开始存游戏记录
		 */
		//创建游戏封装类对象
		GameBean gameBean=new GameBean();
		//存入玩家分数
		gameBean.setScore(sum);
		//存入玩家昵称
		gameBean.setPlayername(name);
		//获取当前时间
		Date date=new Date();
		//调用时间转字符串的方法
		String time=DateUtil.getDateToString(date);
		//存入封装
		gameBean.setTime(time);
		//创建GameDao类 对象
		GameDao gd=new GameDao();
		//调用GameDao类新增方法  把玩家游戏信息存入集合
		gd.addGame(gameBean);
		//调出再玩一局的方法
		again();
		}
	}
	/**
	 * 是否再玩一局的方法
	 */
	public void again() {
		//循环选择
		while (flag) {
		//调出菜单
		Menu.againGame();
		switch (InputHelp.getInt("你的选择")) {
		case 1://再玩一局
			System.out.println("请继续游戏");
			return;
		case 0://返回上级
			flag=false;
			break;
		default:
			System.out.println("请输入0-1");
			break;
		}
	  }
	}
	
		
}
