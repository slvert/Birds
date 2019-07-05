package com.js.abgame.bean;
/**
 * 玩家分装类
 * @author Administrator
 *
 */
public class PlayerBean {
/*
 * 私有化属性
 */
	private int id;//编号
	private String username;//用户名
	private String password;//密码
	private String nickname;//昵称
	private String sex;//性别
	private int age;//年龄
	/*
	 * 生成set get 方法
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
