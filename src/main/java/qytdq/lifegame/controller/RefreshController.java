package qytdq.lifegame.controller;

import qytdq.lifegame.view.AlgoFrame;

public class RefreshController implements Runnable {

	public static final int DEFAULT_SPEED = 100;

	private AlgoFrame algoFrame;

	private int refreshPeriod;

	private GameController gameController;

	public RefreshController(AlgoFrame algoFrame, int timePeriod, GameController controller) {
		this.algoFrame = algoFrame;
		this.refreshPeriod = timePeriod == 0 ? DEFAULT_SPEED : (11 - timePeriod) * 20;
		System.out.println(refreshPeriod);
		this.gameController = controller;
	}

	@Override
	public void run() {
		while (true) {
			gameController.nextStep();
			algoFrame.repaint();
			try {
				Thread.sleep(refreshPeriod);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public int getRefreshPeriod() {
		return refreshPeriod;
	}

	public void setRefreshPeriod(int refreshPeriod) {
		this.refreshPeriod = refreshPeriod;
	}

}
