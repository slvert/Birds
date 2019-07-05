package com.js.abgame.help;

import com.js.abgame.bean.PlayerBean;
import com.js.abgame.dao.PlayerDao;
import com.js.abgame.main.AdminManager;
import com.js.abgame.util.ValidationUtil;
/**
 * 用于新增玩家帮助类
 * @author Administrator
 *
 */
public class PlayerHelp {
	//定义玩家编号
	//public static int size=1;
	/**
	 * 获得玩家信息方法
	 * @return
	 */
	public PlayerBean getPlayer(){
		//创建玩家封装类对象
		PlayerBean pb=new PlayerBean();
		//设置用户名
		String loginname=null;
		//定义循环新增用户名开关
		boolean flag=true;
		while (flag) {
			loginname=InputHelp.getString("用户名 (必须有字母，最少1位)",ValidationUtil.CHKLOGINNAME);
			//创建PlayerDao对象
			PlayerDao pd=new PlayerDao();
			//调用检测玩家用户名是否重复的方法
			if (pd.chkloginname(loginname)) {
				//返回结果为真 表示可用 关闭循环
				flag=false;
			}else {
				System.out.println("用户名已存在，请重新输入");
			}
		}
		pb.setUsername(loginname);
		//设置密码
		pb.setPassword(InputHelp.getString("密码 (不能纯数字或字母 最少6位最多16位)",ValidationUtil.CHKPASSWORD));
		//设置昵称
		pb.setNickname(InputHelp.getString("昵称 (必须汉字 最少2位 最多4位)",ValidationUtil.CHKNICKNAME));
		//设置性别
		pb.setSex(InputHelp.getString("性别 (必须是男或女)",ValidationUtil.CHKSEX));
		//设置年龄
		pb.setAge(Integer.parseInt(InputHelp.getString("年龄 (年龄最小18岁最大69岁)",ValidationUtil.CHKAGE)));
		//返回该玩家信息
		return pb;
	}
}
