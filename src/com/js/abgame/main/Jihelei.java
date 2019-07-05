package com.js.abgame.main;

import java.util.ArrayList;
import java.util.List;

import com.js.abgame.bean.PlayerBean;
import com.js.abgame.help.InputHelp;

public class Jihelei {
	List<PlayerBean> players2=new ArrayList<PlayerBean>();
	//PlayerBean playerBean=new PlayerBean(InputHelp.getInt("id"), InputHelp.getString("玩家姓名"), InputHelp.getString("密码"), InputHelp.getString("昵称"), InputHelp.getString("性别"), InputHelp.getInt("年龄"));
	/**
	 * 向集合增加新玩家的方法
	 */
	 
	public void addplay() {
		//定义循环开关
		boolean flag=true;
		while (flag) {
		//	players2.add(playerBean);
			System.out.println("1.继续添加 0.退出添加");
			int choose=InputHelp.getInt("选择");
			if (choose==1) {
				System.out.println("请继续添加");
			} else {
				flag=false;
				System.out.println("已退出");
				}
			}
		}
	/**
	 * 修改玩家的方法
	 */
	public void updatePlaye() {
		for (PlayerBean playerBean : players2) {
			System.out.println(playerBean);
		}
		int choose=InputHelp.getInt("玩家id");
		for (int i = 0; i < players2.size(); i++) {
			if (choose==players2.get(i).getId()) {
				players2.get(i);
				System.out.println("删除成功");
			}
		//	if (i==list.size()-1){
				System.out.println("没有该学生");
				
			}
		}
	
}
