package com.js.abgame.bird;
/**
 * 鸟的父类
 * @author Abeni
 *
 */
public abstract class Bird {
	//小鸟编号
	protected int id;
	//颜色
	protected String color;
	//攻击力
	protected int attact;
	//命中率
	protected int hit;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAttact() {
		return attact;
	}
	public void setAttact(int attact) {
		this.attact = attact;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	//小鸟展示的方法
	public abstract void show();
	//小鸟攻击的方法
	public int birdAttact() {
		int random=(int)(Math.random()*100);
		if (hit>=random) {
			System.out.println("''BOOM!''打中了野猪大王！Lucky!(命中目标)");
			return attact;
		}else {
			System.out.println("额····没命中");
			return 0;
		}
	}
}
