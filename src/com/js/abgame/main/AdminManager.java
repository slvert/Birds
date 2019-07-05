package com.js.abgame.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.js.abgame.bean.AdminBean;
import com.js.abgame.bean.GameBean;
import com.js.abgame.bean.PlayerBean;
import com.js.abgame.bird.Bird;
import com.js.abgame.dao.GameDao;
import com.js.abgame.dao.PlayerDao;
import com.js.abgame.exception.AppException;
import com.js.abgame.exception.SysException;
import com.js.abgame.help.BirdHelp;
import com.js.abgame.help.InputHelp;
import com.js.abgame.help.PlayerHelp;
import com.js.abgame.ui.Menu;
import com.js.abgame.util.DataInit;
import com.js.abgame.util.ValidationUtil;
import com.js.abgame.util.XmlGetAdmin;
import com.js.abgame.util.XmlUpdateAdmin;

import sun.net.www.content.image.x_xpixmap;
/**
	 * 管理员类
	 * @author Administrator
	 *
	 */
public class AdminManager {
	
	/**
	 * 检测管理员登录的方法
	 * @return
	 */
	public boolean chkAdminLogin() {
		//账号
		String loginname=InputHelp.getString("账号");
		//密码
		String password=InputHelp.getString("密码");
		//判断
		if (loginname.equals(DataInit.admin.getLoginname())&&password.equals(DataInit.admin.getPassword())) {
			System.out.println("登录成功");
			return true;
		}else {
			//登录失败
			return false;
		}
	}
	/**
	 * 管理员操作方法
	 */
	public void adminOp(){
		//管理员登录循环 
		for (int i = 0; i <DataInit.admin.getLogintimes(); i++) {
			//账号 调用输入帮助类接收字符串方法
			String loginname=InputHelp.getString("管理员账号");
			//密码  调用输入帮助类接收字符串方法
			String password=InputHelp.getString("管理员密码");
			//判断管理员账号密码正确与否
			if (loginname.equals(DataInit.admin.getLoginname())&&password.equals(DataInit.admin.getPassword())) {
				System.out.println("管理员登录成功");
				//定义开关
				boolean flag=true;
				//管理员菜单循环
				while (flag) {
					//调用管理员操作菜单
					Menu.adminMunu();
					//选择
					int choose=InputHelp.getInt("数字");
					switch (choose) {
					case 1://新增玩家
						//调用新增玩家方法
						this.addPlayer();
						break;
					case 2://修改玩家信息
						//调用本类修改玩家的方法
						this.updatePlayer();
						break;
					case 3://删除玩家信息同时删除游戏信息
						try {
							//调用本类删除方法
							this.deletePlayer();
						} catch (SysException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 4://查询玩家
						//调用本类查询玩家方法
						this.queryAll();
						break;
					case 5://查询游戏
						//调用本类查询游戏方法
						this.queryGame();
						break;
					case 6://分数统计
						//调用本类分数统计方法
						this.scoreStatistics();
						break;
					case 7://参数设置
						//调用本类参数设置方法
						this.setParameter();
						break;
					case 0://退出管理员菜单，返回首页面
						//关闭管理员菜单循环
						flag=false;
						//关闭管理员登录循环
						i=10;
						break;

					default:
						System.out.println("你输入的不正确请重新输入");
						break;
					}
				}
			} else {
				//判断最后一次输入错误，关闭程序
				if (i==DataInit.admin.getLogintimes()-1) {
					System.out.println("输入错误，程序结束");
					System.exit(0);
				}
				System.out.println("输入错误，请重新输入，还有"+(DataInit.admin.getLogintimes()-1-i)+"次");
			}
		}
	}
	/**
	 * 1.新增玩家的方法
	 */
	public void addPlayer(){
		//定义开关
		boolean flag=true;
		//新增玩家循环
		while (flag) {
			//	创建玩家帮助类对象		
				PlayerHelp phHelp=new PlayerHelp();
				//获得玩家信息
				PlayerBean player=phHelp.getPlayer();
				//创建PlayerDao类对象
				PlayerDao pd=new PlayerDao();
				//调用新增玩家到数据库的方法
				int a=pd.addPlayer(player);
				if (a==1) {
					System.out.println("成功");
				} else {
					System.out.println("失败");
					return;
				}
				System.out.println("新增成功， 1继续新增  0返回上级");
				int choose=InputHelp.getInt("数字");
				//判断
				if (choose==1) {
					System.out.println("请继续新增");
				} else {
					//关闭新增玩家循环
					flag=false;
					System.out.println("返回上级");
				}
			}
		}
	/**
	 * 查询一个玩家的方法
	 * @param id 编号
	 * @return
	 * @throws SysException
	 */
	public PlayerBean queryOne(int id) throws SysException {
		//创建PlayerDao类对象
		PlayerDao pd=new PlayerDao();
		//接收查询一个id的方法
		List<PlayerBean> queryById = pd.queryById(id);
		//判断是否有这个玩家
		if (queryById.size()==1) {
			
			return queryById.get(0);
		}
		throw new SysException(202, "没有该玩家");
	}
	
	/**
	  * 2.修改玩家的方法
	  */
	 public void updatePlayer(){
		//创建PlayerDao类对象
		PlayerDao pd=new PlayerDao();
		 //调用本类查询玩家的方法
			this.queryAll();
			int choose1=InputHelp.getInt("你要修改的玩家编号");
			try {
				//调用本类查询一个玩家的方法
				PlayerBean p = queryOne(choose1);
				//定义开关
				boolean flag=true;
				//循环修改玩家信息
				while (flag) {						
					//调用修改玩家信息的菜单
					Menu.updatePlayer();
					int choose2=InputHelp.getInt("你要修改的选项");
					switch (choose2) {
					case 1://修改密码
						System.out.println("原密码"+p.getPassword());
						//设置新密码
						p.setPassword(InputHelp.getString("新密码 (不能纯数字或字母 最少6位最多16位)",ValidationUtil.CHKPASSWORD));
						//调用DBUtil修改的方法
						pd.updatePlayer(p);
						System.out.println("修改成功");
						break;
					case 2://修改昵称
						System.out.println("原昵称"+p.getNickname());
						//设置新昵称
						p.setNickname(InputHelp.getString("新昵称	(必须汉字 最少2位 最多4位)",ValidationUtil.CHKNICKNAME));
						//调用DBUtil修改的方法
						pd.updatePlayer(p);
						System.out.println("修改成功");
						break;
					case 3://修改性别
						System.out.println("原性别"+p.getSex());
						//设置新性别
						p.setSex(InputHelp.getString("新性别	(必须是男或女)",ValidationUtil.CHKSEX));
						//调用DBUtil修改的方法
						pd.updatePlayer(p);
						System.out.println("修改成功");
						break;
					case 4://修改年龄
						System.out.println("原年龄"+p.getAge());
						//设置新性别
						p.setAge(Integer.parseInt((InputHelp.getString("新年龄 (年龄最小18岁最大69岁)",ValidationUtil.CHKAGE))));
						//调用DBUtil修改的方法
						pd.updatePlayer(p);
						System.out.println("修改成功");
						break;
					case 0://返回上级
						//关闭循环修改玩家
						flag=false;
						//跳出方法
						return;
						
					default:
						break;
					}
				}
			} catch (SysException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMsg());
			} catch (AppException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMsg());
			}
		}
	 /**
	  * 3.删除玩家和玩家游戏信息的方法
	  */
	 public void deletePlayer() throws SysException {
		 //创建PlayerDao的对象
		 PlayerDao pd=new PlayerDao();
		 //创建GameDao的对象
		 GameDao gd=new GameDao();
		//调用本类查询玩家的方法
			this.queryAll();
			int choose2=InputHelp.getInt("你要删除的玩家编号");
			try {
				//调用GameDao类通过玩家id获取用户名来删除游戏信息的方法
				int deleteGames = gd.deleteGames(choose2);
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//调用PlayerDao类删除玩家的方法
			int a=pd.deletePlayer(choose2);
			if (a==1) {
				System.out.println("删除成功");
			}else {
				System.out.println("没有该玩家");
			}
	 }
	/**
	 * 4.查询玩家方法
	 */
	public void queryAll(){
		PlayerDao pd=new PlayerDao();
		System.out.println("编号"+"\t"+"玩家账号"+"\t"+"密码"+"\t"+"昵称"+"\t"+"性别"+"\t"+"年龄");
		//调用查询所有玩家信息的方法
		List<PlayerBean> list=pd.queryAll();
		//遍历集合
		for (PlayerBean p : list) {
			//输出玩家信息
			System.out.println(p.getId()+"\t"+p.getUsername()+"\t"+p.getPassword()+"\t"+p.getNickname()+"\t"+p.getSex()+"\t"+p.getAge());
			
		}
		
	}
	/**
	 * 5.查询游戏方法
	 */
	public void queryGame() {
		System.out.println("玩家账号"+"\t"+"\t"+"玩家分数"+"\t"+"\t"+"游戏时间");
		//创建GameDao类 对象
		GameDao gd=new GameDao();
		List<GameBean> queryAll = gd.queryAll();
		//遍历玩家存入游戏信息的数组
		//  数组类型 元素明  容器 数组名
		for (GameBean game : queryAll) {
			System.out.println(game.getPlayername()+"\t"+"\t"+game.getScore()+"\t"+"\t"+game.getTime());
		}
	}
	/**
	 * 6.分数统计方法
	 */
	public void scoreStatistics() {
		//创建GameDao类 对象
		GameDao gd=new GameDao();
		for (Map<String, String> map : gd.queryScore()) {
			System.out.println("玩家:"+map.get("playername")+"\t"+"\t"+"总分:"+map.get("SUM(score)")+"\t"+"\t"+"平均分:"+Math.round(Double.parseDouble(map.get("AVG(score)")))+"\t"+"\t"+"总局数:"+map.get("time"));
		}
	}
	/**
	 * 7.参数设置方法
	 */
	public void setParameter() {
		//调出参数设置菜单
		Menu.setparmmeter();
		int num=InputHelp.getInt("编号");
		switch (num) {
		case 1://修改红色小鸟
			//调用BirdHelp类修改一只鸟的方法
			try {
				BirdHelp.setOneBird(1);
				//修改完后重新初始化数据
				DataInit.update();
			} catch (SysException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMsg());
			}
			break;
		case 2://修改黑色小鸟
			try {
				BirdHelp.setOneBird(2);
				//修改完后重新初始化数据
				DataInit.update();
			} catch (SysException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMsg());
			}
			break;
		case 3://修改蓝色小鸟
			try {
				BirdHelp.setOneBird(3);
				//修改完后重新初始化数据
				DataInit.update();
			} catch (SysException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMsg());
			}
			break;
		case 4://管理员账号修改
			System.out.println("原账号:"+DataInit.admin.getLoginname());
			XmlUpdateAdmin.updateLoginname(InputHelp.getString("新账号"));
			//重新调用修改后的信息
			DataInit.update();
			break;
		case 5://管理员密码修改
			System.out.println("原密码:"+DataInit.admin.getPassword());
			XmlUpdateAdmin.updatePassword(InputHelp.getString("新密码"));
			DataInit.update();
			break;
		case 6://管理员登录次数
			System.out.println("原次数:"+DataInit.admin.getLogintimes());
			XmlUpdateAdmin.updateLogintimes(InputHelp.getInt("新次数")+"");
			DataInit.update();
			break;
		case 0://返回上级
			//跳出方法
			return;

		default:
			break;
		}
	}
}
