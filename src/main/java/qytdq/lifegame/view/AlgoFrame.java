package qytdq.lifegame.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import qytdq.lifegame.controller.GameController;
import qytdq.lifegame.controller.RefreshController;
import qytdq.lifegame.model.LifeCircle;
import qytdq.lifegame.utils.AlgoVisHelper;


/**
 * Customized Frame
 * 
 * @author DaiQing
 */
public class AlgoFrame extends JFrame implements KeyListener, MouseWheelListener {
	private static final long serialVersionUID = 1L;

	/**
	 * Frame 窗口大小
	 */
	private int canvasWidth;
	private int canvasHeight;

	// 生命circle
	private LifeCircle[][] circles;

	private GameController controller;
	// 刷新控制器
	private RefreshController refreshCtl;

	// 分辨率
	public static final int RESOLUTION_X = 1920;
	public static final int RESOLUTION_Y = 1080;

	public AlgoFrame(String title) {
		this(title, RESOLUTION_X, RESOLUTION_Y);
	}

	public AlgoFrame(String title, int speed, int initImage) {
		super(title);
		this.canvasWidth = RESOLUTION_X;
		this.canvasHeight = RESOLUTION_Y;
		AlgoCanvas canvas = new AlgoCanvas();

		// set frame basic info
		this.setSize(canvasWidth, canvasHeight);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		// set panel
		canvas.setPreferredSize(canvas.getPreferredSize());
		this.setContentPane(canvas);
		this.pack();

		
		int clusterInit = 3000;
		// start Controller
		controller = new GameController(clusterInit, RESOLUTION_X / LifeCircle.R, RESOLUTION_Y / LifeCircle.R,
				initImage);
		circles = controller.getLives();

		// add listener
		this.addKeyListener(this);
		this.addMouseWheelListener(this);
		// fresh thread
		refreshCtl = new RefreshController(this, speed, controller);
		new Thread(refreshCtl).start();
	}

	/**
	 * 根据传入内容绘制
	 * 
	 * @param circles
	 */
	public void render(LifeCircle[][] circles) {
		this.circles = circles;
		this.repaint();
	}

	public int getCanvasWidth() {
		return canvasWidth;
	}

	public int getCanvasHeight() {
		return canvasHeight;
	}

	/**
	 * 
	 * @author DaiQing
	 */
	private class AlgoCanvas extends JPanel {

		private static final long serialVersionUID = 1L;

		public AlgoCanvas() {
			// 设置双缓存
			super(true);
		}

		/**
		 * g:绘制的上下文环境
		 */
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D graphics2d = (Graphics2D) g;
			// 设置渲染，抗锯齿
			RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			graphics2d.addRenderingHints(hints);

			// 设置笔刷信息
			AlgoVisHelper.setStrokeWidth(graphics2d, 10);
			// 实心
			for (int i = 0; i < circles.length; ++i) {
				for (int j = 0; j < circles[0].length; ++j) {
					LifeCircle circle = circles[i][j];
					if (circle.isAlive()) {
						graphics2d.setColor(circle.getColor());
						AlgoVisHelper.fillCircle(graphics2d, circle.getY(), circle.getX(), LifeCircle.R);
					}
				}
			}
			this.removeAll();
		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(canvasWidth, canvasHeight);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		switch (e.getKeyChar()) {
		case 'c':

			// speed up
			refreshCtl.setRefreshPeriod(refreshCtl.getRefreshPeriod() < 10 ? refreshCtl.getRefreshPeriod()
					: refreshCtl.getRefreshPeriod() - 10);
			break;
		case 'x':

			// speed down
			refreshCtl.setRefreshPeriod(refreshCtl.getRefreshPeriod() + 10);
			break;
		case 'z':
			// default speed
			refreshCtl.setRefreshPeriod(RefreshController.DEFAULT_SPEED);
			break;
		case ' ':
			// pause
			refreshCtl.setRefreshPeriod(1000000);
			break;
		default:
			break;
		}
//		if (e.getKeyChar() == 'c') {
//			// speed up
//			refreshCtl.setRefreshPeriod(refreshCtl.getRefreshPeriod() < 10 ? refreshCtl.getRefreshPeriod()
//					: refreshCtl.getRefreshPeriod() - 10);
//		} else if (e.getKeyChar() == 'x') {
//			// speed down
//			refreshCtl.setRefreshPeriod(refreshCtl.getRefreshPeriod() + 10);
//		} else if (e.getKeyChar() == 'z') {
//			// default speed
//			refreshCtl.setRefreshPeriod(RefreshCtl.DEFAULT_SPEED);
//		} else if (e.getKeyChar() == ' ') {
//			// pause
//			refreshCtl.setRefreshPeriod(1000000);
//		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getWheelRotation() == 1) {
			LifeCircle.R = LifeCircle.R == 15 ? 15 : LifeCircle.R + 1;
		} else if (e.getWheelRotation() == -1) {
			LifeCircle.R = LifeCircle.R == 1 ? 1 : LifeCircle.R - 1;
		}
	}
}