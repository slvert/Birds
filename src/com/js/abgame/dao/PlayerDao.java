package com.js.abgame.dao;
/**
 * 对玩家表进行操作
 * @author Abeni
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.metal.MetalBorders.PaletteBorder;

import com.js.abgame.bean.PlayerBean;
import com.js.abgame.exception.AppException;
import com.js.abgame.exception.SysException;
import com.js.abgame.util.DBUtil;
import com.sun.java.swing.plaf.windows.WindowsBorders.DashedBorder;

public class PlayerDao {
	//创建DBUtil对象
	DBUtil db=new DBUtil();
	/**
	 * 处理查询结果 返回list集合 bean类型
	 * @param sql
	 * @param obj
	 * @return
	 */
	public List<PlayerBean> query(String sql,Object[] obj){
		//建立list集合
		List<PlayerBean> list=new ArrayList<PlayerBean>();
		try {
			//调用查询的方法
			List<Map<String, String>> map=db.query(sql, obj);
			//遍历
			for (Map<String, String> map2 : map) {
				//创建封装类对象
				PlayerBean player=new PlayerBean();
				player.setId(Integer.parseInt(map2.get("id")));//id
				player.setUsername(map2.get("loginname"));//登录名
				player.setPassword(map2.get("password"));//密码
				player.setNickname(map2.get("nickname"));//昵称
				player.setSex(map2.get("sex"));//性别
				player.setAge(Integer.parseInt(map2.get("age")));//年龄
				//存入集合
				list.add(player);
				
			}
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回结果
		return list;
	}
	/**
	 * 检测玩家登录 的方法
	 * @param p 封装类参数
	 * @return	返回封装类
	 */
	public List<PlayerBean> chklogin(PlayerBean p){
		//检测玩家登录sql语句，条件登录名和密码
		String sql="SELECT * FROM players WHERE loginname=? AND `password`=?;";
		//object 数组 存入封装类的数据 根据条件对应存入的数据
		Object [] obj= {p.getUsername(),p.getPassword()};
		//调用本类查询的方法
		List<PlayerBean> list=query(sql, obj);
		//返回查询到的集合
		return list;
	}
	/**
	 * 新增玩家到数据库的方法
	 * @param p 封装类
	 * @return 返回为int类型
	 */
	public int addPlayer(PlayerBean p) {
		//新增玩家的sql语句 ?表示占位符 null属于主键自增
		String sql="INSERT INTO players VALUES(NULL,?,?,?,?,?);";
		//object 数组 存入封装类的数据 要与列名一一对应 null不写
		Object [] obj= {p.getUsername(),p.getPassword(),p.getNickname(),p.getSex(),p.getAge()};
		//判断返回类型结果
		int a=0;
		try {
			//调用DBUtil方法 实现新增玩家到数据库
			a=db.update(sql, obj);
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//如果a=1表示成功
		return a;
	}
	/**
	 * 删除数据库玩家的方法
	 * @param id 参数 指定的id
	 * @return 
	 */
	public int deletePlayer(int id) {
		//删除玩家的sql语句  条件id
		String sql="DELETE FROM players WHERE id=?;";
		//数组里获取 传的参 也就是传的id
		Object [] obj= {id};
		//判断返回类型结果
		int a=0;
		try {
			//调用DBUtil的方法 实现指定id删除数据库玩家信息
			a = db.update(sql, obj);
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//结果为1 表示成功
		return a;
	}
	
	/**
	 * 修改数据库指定玩家信息方法
	 * @param p
	 * @return
	 */
	public int updatePlayer(PlayerBean p) throws AppException {
		//修改玩家信息的sql语句
		String sql="update players set password=?,nickname=?,sex=?,age=? where id=?;";
		//object数组 存入封装类对应的数据
		Object [] obj= {p.getPassword(),p.getNickname(),p.getSex(),p.getAge(),p.getId()};
		//判断返回类型结果
		int a=0;
		try {
			//调用DBUtil的方法 实现修改指定 id 玩家信息
			a=db.update(sql, obj);
		} catch (SysException e) {
			// TODO Auto-generated catch block
			throw new AppException(201, "修改失败");
		}
		//结果为1 表示成功
		return a;
	}
	/**
	 * 查询数据库玩家表的所有信息
	 * @return
	 */
	public List<PlayerBean> queryAll() {
		//查询所有玩家信息的sql语句
		String sql="SELECT * FROM players;";
		//调用本类查询方法
		List<PlayerBean> list=query(sql, null);
		//返回结果集
		return list;
	}
	
	/**
	 * 指定id查询玩家信息
	 * @param id
	 * @return
	 */
	public List<PlayerBean>	queryById(int id)  {
		//指定id查找玩家信息的sql语句
		String sql="SELECT * FROM players WHERE id=?;";
		//object 数组 传参id
		Object [] obj= {id};
		//调用本类查询方法
		List<PlayerBean> list=query(sql, obj);
		//返回为1 表示有 否则
		return list;
	}
	/**
	 * 检测输入的用户名是否重复
	 * @param name 传参的登录名
	 * @return
	 */
	public boolean chkloginname(String name) {
		//指定玩家登录名查询
		String sql="SELECT * FROM players WHERE loginname=?;";
		//数组传参用户名
		Object [] obj= {name};
		//调用本类查询方法
		List<PlayerBean> list=query(sql, obj);
		//判断 集合内是否有相同名字	集合为空或元素数为0 表示没有相同的
		if (list==null||list.size()==0) {
			return true;//表示可用
		}
		//表示不可用
		return false;
	}
}


