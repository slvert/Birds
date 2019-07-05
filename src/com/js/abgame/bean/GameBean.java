package com.js.abgame.bean;
/**
 * 游戏封装类
 * @author Abeni
 *
 */
public class GameBean {
	private int id;//编号
	private String playername;//玩家名字
	private int score;//分数
	private String time;//时间
	/**
	 * 生产get set方法
	 * @return
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlayername() {
		return playername;
	}
	public void setPlayername(String playername) {
		this.playername = playername;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
