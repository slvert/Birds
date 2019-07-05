package com.js.abgame.util;

import com.js.abgame.bird.Bird;
import com.js.abgame.bird.BlackBird;
import com.js.abgame.bird.BlueBird;
import com.js.abgame.bird.RedBird;

/**
 * 用于生产小鸟
 * @author Abeni
 *
 */
public class BirdFactory {
	/**
	 * 生产小鸟方法
	 * @param id 用于选择小鸟的参数
	 * @return
	 */
	public static Bird getOneBird(int id) {
		switch (id) {
		case 1://红色小鸟
			//返回创建新的红色小鸟
			return new RedBird();
		case 2://黑色小鸟
			//返回创建新的黑色小鸟
			return new BlackBird();
		case 3://蓝色小鸟
			//返回创建新的蓝色小鸟
			return new BlueBird();

		default:
			return null;
		}
	}
}
