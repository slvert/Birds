package com.js.abgame.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.js.abgame.bean.GameBean;
import com.js.abgame.bird.Bird;
import com.js.abgame.exception.SysException;
import com.js.abgame.util.BirdFactory;
import com.js.abgame.util.DBUtil;

/**
 * 对小鸟表 进行操作
 * @author Abeni
 *
 */
public class BirdDao {
	//创建DBUtil类对象
	DBUtil db=new DBUtil();
	/**
	 * 处理查询结果
	 * @param sql
	 * @param obj
	 * @return
	 */
	public List<Bird> query(String sql,Object [] obj) {
		//建立Bird类 list集合
		List<Bird> list=new ArrayList<Bird>();
		try {
			//调用DBUtil类方法
			List<Map<String, String>>	query = db.query(sql, obj);
			for (Map<String, String> map : query) {
				//创建父类鸟
				Bird bird=null;
				int id=Integer.parseInt(map.get("id"));
				//通过小鸟工厂生产对应的鸟类
				bird=BirdFactory.getOneBird(id);
				//设置值
				bird.setId(id);
				bird.setColor(map.get("color"));
				bird.setAttact(Integer.parseInt(map.get("attack")));
				bird.setHit(Integer.parseInt(map.get("hit")));
				list.add(bird);
			}
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 查询数据库全部小鸟
	 * @return
	 */
	public List<Bird> querAll() {
		//查询小鸟表sql语句
		String sql="SELECT * FROM birds;";
		//调用本类查询方法
		List<Bird> query = query(sql, null);
		//返回
		return query;
	}
	/**
	 * 根据id查询一只鸟的方法
	 * @param id
	 * @return
	 */
	public List<Bird> queryById(int id) {
		//查询指定id的小鸟
		String sql="SELECT * FROM birds WHERE id=?;";
		//数组传参 id
		Object [] obj= {id};
		//调用本类查询方法
		List<Bird> query = query(sql, obj);
		//返回
		return query;
	}
	/**
	 * 修改小鸟参数的方法
	 * @param b
	 * @return
	 */
	public int updateBird(Bird b) throws SysException {
		//修改小鸟表的sql语句
		String sql="UPDATE birds SET color=?,attack=?,hit=? WHERE id=?;";
		//数组传参 一一对应
		Object [] obj= {b.getColor(),b.getAttact(),b.getHit(),b.getId()};
		int a=0;
		try {
			//调用DBUtil类 更新 方法
			db.update(sql, obj);
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SysException(203, "修改失败");
		}
		return a;
	}
}
