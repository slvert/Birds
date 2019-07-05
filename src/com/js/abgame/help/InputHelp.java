package com.js.abgame.help;

import java.util.Scanner;

import com.js.abgame.util.ValidationUtil;

/**
	 * 获得控制台输入帮助类的方法
	 * @author Administrator
	 *
	 */
public class InputHelp {
	/**
	 * 获得控制台数字输入的方法
	 * @param s 形式参数
	 * @return 返回值
	 */
	public static int getInt(String s){
		//循环输入
		while (true) {
			//创建控制台输入
			Scanner sc=new Scanner(System.in);
			System.out.println("请输入"+s);
			//判断
			if (sc.hasNextInt()) {
				//获取控制台输入
				int a=sc.nextInt();
				return a; //返回值
			} else {
				System.out.println("你输入的不是数字，请重新输入");
			}
		}
	}
	/**
	 * 获得控制台字符串输入的方法
	 * @param s 形式参数
	 * @return
	 */
	public static String getString(String s){
		//创建控制台输入
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入"+s);
		String aString=sc.next();
		return aString;
	}
	/**
	 * 获得控制台字符串输入的方法带正则
	 * @param s 提示语
	 * @param regex	正则表达式
	 * @return
	 */
	public static String getString(String s,String regex){
		//循环输入
		while (true) {
			//创建控制台输入
			Scanner sc=new Scanner(System.in);
			System.out.println("请输入"+s);
			String aString=sc.next();
			if (aString.matches(regex)) {
				return aString;
			} else {
				System.out.println("请输入正确的"+s);
			}
		}
	}
	
	
}
