package com.js.abgame.bean;
/**
 * 管理员封装类
 * @author Abeni
 *
 */
public class AdminBean {
	private String loginname;//管理员账号
	private String password;//管理员密码
	private int logintimes;//登录次数
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLogintimes() {
		return logintimes;
	}
	public void setLogintimes(int logintimes) {
		this.logintimes = logintimes;
	}
	
}
