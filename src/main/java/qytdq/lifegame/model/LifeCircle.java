package qytdq.lifegame.model;

import java.awt.Color;

import qytdq.lifegame.utils.ColorUtils;

/**
 * 以圆点来表示每一个生命
 * @author DaiQing
 *
 */
public class LifeCircle {
	
	// 圆心坐标
	private int x,y;
	
	// 圆的半径大小
	public static int R = 5;
	
	// 是否存活
	private boolean alive;
	
	// 已经存活的周期
	private int longivity;
	
	private Color color;
	
	public LifeCircle(int x, int y, boolean alive) {
		super();
		this.x = x;
		this.y = y;
		this.alive = alive;
		color = ColorUtils.GREEN;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getLongivity() {
		return longivity;
	}

	public void setLongivity(int longivity) {
		this.longivity = longivity;
		switch (longivity) {
		case 1:
			color = ColorUtils.GREEN;
			break;
		case 2:
			color = ColorUtils.YELLOW;
			break;
		case 3:
			color = ColorUtils.DARK_YELLOW;
			break;
		case 4:
			color = ColorUtils.RED;
			break;
		default:
			color = ColorUtils.PURPLE;
			break;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Color getColor() {
		return color;
	}
	
}
