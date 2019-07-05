package com.js.abgame.bird;

import com.js.abgame.help.InputHelp;

/**
 * 测试
 * @author Abeni
 *
 */
public class Test1 {
	public void play(Bird b) {
		//调用展示的方法
		b.show();
		//调用攻击的方法
		b.birdAttact();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1 ts=new Test1();
		Bird [] birds=new Bird[3];
		System.out.println("1.红色小鸟 2.黑色小鸟 3.蓝色小鸟");
		for (int j = 0; j < 3; j++) {
			switch (InputHelp.getInt("小鸟的编号")) {
			case 1:
				birds[j]=new RedBird();
				break;
			case 2:
				birds[j]=new BlackBird();
				break;
			case 3:
				birds[j]=new BlueBird();
				break;

			default:
				System.out.println("不存在的小鸟");
				j--;
				break;
			}
		}
		for (Bird bird : birds) {
			ts.play(bird);
		}
	}

}
