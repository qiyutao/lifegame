package qytdq.lifegame.utils;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class AlgoVisHelper {
	
	private AlgoVisHelper() {}
	
	public static void setStrokeWidth(Graphics2D g2d, int w) {
		int strokeWidth = w;
		//第一个线条端点样子，第二个是线条拐点样子，一下CAP_ROUND都是圆滑类型
		g2d.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.CAP_ROUND));
	}

	/**
	 * x,y 为圆心，绘制半径为r
	 * @param g2d
	 * @param x
	 * @param y
	 * @param r
	 */
	public static void strokeCircle(Graphics2D g2d, int x, int y, int r) {
		Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2 * r, 2 * r);
		g2d.draw(circle);
	}
	

	/**
	 * x,y 为圆心，绘制半径为r
	 * @param g2d
	 * @param x
	 * @param y
	 * @param r
	 */
	public static void fillCircle(Graphics2D g2d, int x, int y, int r) {
		Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2 * r, 2 * r);
		g2d.fill(circle);
	}
}
