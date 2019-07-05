package com.js.abgame.dao;
/**
 * 对游戏表进行操作
 * @author Abeni
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.js.abgame.bean.GameBean;
import com.js.abgame.exception.AppException;
import com.js.abgame.exception.SysException;
import com.js.abgame.util.DBUtil;

public class GameDao {
	//创建DBUtil类对象
	DBUtil db=new DBUtil();
	/**
	 * 处理查询的结果
	 * @param sql
	 * @param obj
	 * @return
	 */
	public List<GameBean> query(String sql,Object [] obj) {
		//建立游戏封装类 list集合
		List<GameBean> list=new ArrayList<GameBean>();
		try {
			//调用DBUtil类 查询的方法
			List<Map<String, String>> map2 = db.query(sql, obj);
			//遍历map2集合
			for (Map<String, String> map : map2) {
				//创建封装类对象
				GameBean gm=new GameBean();
				//获取游戏表的列名
				gm.setId(Integer.parseInt(map.get("id")));
				gm.setPlayername(map.get("playername"));
				gm.setScore(Integer.parseInt(map.get("score")));
				gm.setTime(map.get("time"));
				//存入list集合
				list.add(gm);
			}
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回list集合
		return list;
	}
	/**
	 * 新增的游戏信息到数据库的方法
	 * @param g
	 * @return
	 */
	public int addGame(GameBean g) {
		//新增游戏信息到游戏表的sql语句
		String sql="INSERT INTO games VALUES(NULL,?,?,?);";
		// 数组 传参 
		Object [] obj= {g.getPlayername(),g.getScore(),g.getTime()};
		//新增方法赋值0
		int update=0;
		try {
			//调用新增的方法
			 update = db.update(sql, obj);
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return update;
	}
	/**
	 * 查询全部游戏信息的方法
	 * @return
	 */
	public List<GameBean> queryAll() {
		//查询游戏信息的sql语句
		String sql="SELECT * FROM games;";
		//调用本类查询方法
		List<GameBean> query = query(sql, null);
		return query;
	}
	/**
	 * 查询指定玩家的游戏信息方法
	 * @param name
	 * @return
	 */
	public List<GameBean> queryByName(String name) {
		//指定玩家查询游戏信息
		String sql="SELECT * FROM games WHERE playername=?;";
		//数组 传参name
		Object [] obj= {name};
		//调用本类查询方法
		List<GameBean> query = query(sql, obj);
		//返回
		return query;
	}
	/**
	 * 查询游戏分数的方法
	 * @return
	 */
	public List<Map<String, String>> queryScore() {
		//求每个玩家的总分，平均分，总局数sql语句
		String sql="SELECT playername, SUM(score),AVG(score),COUNT(*)time FROM games GROUP BY playername;";
		//创建DBUtil类对象
		
		//返回类型为调用DBUtil类的查询方法
		try {
			 List<Map<String, String>> query = db.query(sql, null);
			 return query;
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 通过id查找玩家用户名然后删除改用户名的游戏信息
	 * @param id 玩家id
	 * @return
	 */
	public int  deleteGames(int id) throws AppException {
		//通过玩家id查找玩家用户名，删除该玩家游戏信息
		String sql="DELETE FROM games WHERE playername=(SELECT loginname FROM players WHERE id=?);";
		//数组里获取 传的参 也就是传的id
		Object [] obj= {id};
		//判断返回类型结果
		int a=0;
		try {
			//调用DBUtil的方法 实现指定id删除数据库玩家信息
				db.update(sql, obj);
			} catch (SysException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//结果为1 表示成功
				return a;
	}
	
}
