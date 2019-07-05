package com.js.abgame.main;

import java.util.List;

import com.js.abgame.bean.GameBean;
import com.js.abgame.bean.PlayerBean;
import com.js.abgame.bird.Bird;
import com.js.abgame.bird.BlackBird;
import com.js.abgame.bird.BlueBird;
import com.js.abgame.bird.RedBird;
import com.js.abgame.bird.Test1;
import com.js.abgame.dao.GameDao;
import com.js.abgame.dao.PlayerDao;
import com.js.abgame.help.InputHelp;
import com.js.abgame.ui.Menu;
/**
	 * 玩家管理类
	 * @author Administrator
	 *
	 */
public class PlayerManager {
	//接收 管理员类玩家数组
	//List<PlayerBean> players=AdminManager.players;
	//创建游戏管理类对象
	GameManager gameManager=new GameManager();
	/**
	 * 玩家类操作方法
	 */
	public void playOp(){
		//调出检测玩家登录的方法
		PlayerBean player =chkPlayerLogin();
		if ( player != null) {
			System.out.println("登录成功");
		//定义开关
		boolean flag=true;
		//玩家游戏操作循环
		while (flag) {
		//调出玩家菜单
		Menu.playerMeun();
		//获取输入
		int choose=InputHelp.getInt("你的选择是什么");
		//判断
		switch (choose) {
		case 1://开始游戏
			gameManager.startGame(player.getUsername());
			break;
		case 2://查看成绩
			showScore(player.getUsername());
			break;
		case 0:
			//跳出while循环
			flag=false;
			break;
		default:
			System.out.println("请输入0-2的数字");
			break;
			}//switch结点
			}
		}else {
			System.out.println("你输入的账号或密码不正确");
		}
	}
	
	/**
	 * 查看玩家成绩的方法
	 */
	public void showScore(String string) {
		//创建GameDao类 对象
		GameDao gd=new GameDao();
		System.out.println("玩家登录名"+"\t"+"玩家分数"+"\t"+"游戏时间");
		//调用查询该玩家的游戏信息
		List<GameBean> queryByName = gd.queryByName(string);
		//遍历玩家存入游戏信息的集合
		//  数组类型 元素明  容器 数组名
		for (GameBean game : queryByName) {
			if (game.getPlayername().equals(string)) {
				System.out.println(game.getPlayername()+"\t"+game.getScore()+"\t"+game.getTime());
			}
		}
	}
	/**
	 * 检测玩家登录的方法
	 */
	public PlayerBean chkPlayerLogin() {
		//玩家账号输入
		String username=InputHelp.getString("玩家账号");
		//玩家密码输入
		String password=InputHelp.getString("玩家密码");
		//创建封装类对象
		PlayerBean player=new PlayerBean();
		//账号密码存入封装类
		player.setUsername(username);
		player.setPassword(password);
		//创建PlayerDao对象
		PlayerDao pd=new PlayerDao();
		// 调用检测玩家登录的方法 返回类型为集合
		List<PlayerBean> list=pd.chklogin(player);
		//判断 表示找到唯一一个玩家
		if (list.size()==1) {
			//返回集合中的第一位
			return list.get(0);
		}
		//否则返回空
		return null;
	}
}

