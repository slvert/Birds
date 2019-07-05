package com.js.abgame.help;

import java.util.ArrayList;
import java.util.List;

import com.js.abgame.bird.Bird;
import com.js.abgame.dao.BirdDao;
import com.js.abgame.exception.SysException;
import com.js.abgame.util.BirdFactory;
import com.js.abgame.util.DataInit;

/**
 * 选鸟帮助类
 * @author Abeni
 *
 */
public class BirdHelp {
	
	//用集合接收数据初始化类的小鸟数据 
	public  List<Bird> birds=DataInit.birds;
	//建立选鸟的集合 
	public  List<Bird> cBirds=new ArrayList<Bird>();
	/**
	 * 选一只小鸟的方法
	 */              // a代表下标  j代表循环次数
	public Bird chooseOne(int a,int j) {
		//选择集合里的三只鸟
		Bird b=birds.get(a);
		if (j==4) {
			System.out.println("你选择了一只"+b.getColor()+",选择完毕，开始游戏");
			return b;
		}else {
			System.out.println("你选择了一只"+b.getColor()+"你还有"+(4-j)+"次");
			return b;
		}
	}
	/**
	 * 选择五只鸟的方法
	 */
	public void chooseFive() {
		for (int j = 0; j < 5; j++) {
			switch (InputHelp.getInt("小鸟的编号")) {
			case 1://将红色小鸟存入cBirds集合
				cBirds.add(chooseOne(0, j));
				break;
			case 2://将黑色小鸟存入cBirds集合
				cBirds.add(chooseOne(1, j));
				break;
			case 3://将黑色小鸟存入cBirds集合
				cBirds.add(chooseOne(2, j));
				break;
			case 0:
				//返回上级
				return;
			default:
				System.out.println("不存在的小鸟,请输入0-3");
				j--;//补偿输错机会
				break;
			}
		}
	}
	//
	public static void setOneBird(int id) throws SysException {
		//用小鸟工厂生产一只鸟
		Bird bird=BirdFactory.getOneBird(id);
		//选择
		switch (id) {
		case 1://修改第一只鸟
			System.out.println("你正在修改"+DataInit.birds.get(0).getColor()+"的信息");
			break;
		case 2://修改第二只
			System.out.println("你正在修改"+DataInit.birds.get(1).getColor()+"的信息");
			break;
		case 3://修改第三只
			System.out.println("你正在修改"+DataInit.birds.get(2).getColor()+"的信息");
			break;
		default:
			System.err.println("你的选择有误，请重新选择");
			return;
		}
		bird.setId(id);
		bird.setColor(InputHelp.getString("新的小鸟颜色"));
		bird.setAttact(InputHelp.getInt("新的小鸟攻击力"));
		bird.setHit(InputHelp.getInt("新的小鸟命中率"));
		//创建BirdDao的对象
		BirdDao bd=new BirdDao();
		//调用修改小鸟的方法
		try {
			int updateBird = bd.updateBird(bird);
		} catch (SysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
