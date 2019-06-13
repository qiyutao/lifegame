package qytdq.lifegame.controller;

import qytdq.lifegame.algo.GameMatrix;
import qytdq.lifegame.model.LifeCircle;

public class GameController {

	private LifeCircle[][] lives;
	private int dimensionX;
	private int dimensionY;
	
	private GameMatrix matrix;
	
	private int initImage;

	private boolean[][] initLife;

	public GameController(int clusterInit, int resolutionX, int resolutionY,int initImage) {
		dimensionX = resolutionX / 2;
		dimensionY = resolutionY / 2;
		
		this.initImage = initImage;
		
		matrix = new GameMatrix(dimensionX, dimensionY, clusterInit);
		lives = new LifeCircle[dimensionY][dimensionX];
		initLife = matrix.init();
		
		if (initImage != 0) {
			setImage();
		}
		
		for (int i = 0; i < this.dimensionY; i++) {
			for (int j = 0; j < this.dimensionX; j++) {
				lives[i][j] = new LifeCircle((1 + 2 * i) * LifeCircle.R, (1 + 2 * j) * LifeCircle.R,
						initLife[i][j] ? true : false);
			}
		}
	}

	public LifeCircle[][] getLives() {
		return lives;
	}

	public LifeCircle[][] nextStep() {
		matrix.nextMatrix();
		this.updateLives(matrix.getMatrix());
		return lives;
	}
	
	public void updateLives(boolean[][] life) {
		for (int i = 0; i < this.dimensionY; i++) {
			for (int j = 0; j < this.dimensionX; j++) {
				LifeCircle curLife = lives[i][j];
				boolean pastState = lives[i][j].isAlive();
				curLife.setAlive(life[i][j] ? true : false);
				if (!pastState && curLife.isAlive())
					curLife.setLongivity(1);
				else if (curLife.isAlive())
					curLife.setLongivity(curLife.getLongivity() + 1);
				else if (pastState && !curLife.isAlive()) 
					curLife.setLongivity(0);
			}
		}
	}
	
	private void setImage() {
		for (int i = 0; i < initLife.length; i++) {
			for (int j = 0; j < initLife[0].length; j++) {
				initLife[i][j] = false;
			}
		}
		//[y][x]
		// 机枪
		if (initImage == 1) {
			initLife[5][1] = true;
			initLife[5][2] = true;
			initLife[6][1] = true;
			initLife[6][2] = true;
			initLife[6][11] = true;
			initLife[5][12] = true;
			initLife[6][12] = true;
			initLife[7][12] = true;
			initLife[4][13] = true;
			initLife[5][13] = true;
			initLife[6][13] = true;
			initLife[7][13] = true;
			initLife[8][13] = true;
			initLife[3][14] = true;
			initLife[4][14] = true;
			initLife[8][14] = true;
			initLife[9][14] = true;
			initLife[4][15] = true;
			initLife[5][15] = true;
			initLife[6][15] = true;
			initLife[7][15] = true;
			initLife[8][15] = true;
			initLife[4][16] = true;
			initLife[8][16] = true;
			initLife[5][17] = true;
			initLife[7][17] = true;
			initLife[6][18] = true;
			initLife[4][21] = true;
			initLife[2][22] = true;
			initLife[3][22] = true;
			initLife[5][22] = true;
			initLife[6][22] = true;
			initLife[1][24] = true;
			initLife[7][24] = true;
			initLife[1][26] = true;
			initLife[2][26] = true;
			initLife[4][26] = true;
			initLife[6][26] = true;
			initLife[7][26] = true;
			initLife[3][35] = true;
			initLife[4][35] = true;
			initLife[3][36] = true;
			initLife[4][36] = true;
		} else if (initImage == 2) {
			// 飞船

			initLife[dimensionY - 1][dimensionX/2+9] = true;
			initLife[dimensionY - 1][dimensionX/2+10] = true;
			initLife[dimensionY - 1][dimensionX/2+12] = true;
			initLife[dimensionY - 1][dimensionX/2+13] = true;
			initLife[dimensionY - 2][dimensionX/2+3] = true;
			initLife[dimensionY - 2][dimensionX/2+19] = true;
			initLife[dimensionY - 3][dimensionX/2+3] = true;
			initLife[dimensionY - 3][dimensionX/2+4] = true;
			initLife[dimensionY - 3][dimensionX/2+5] = true;
			initLife[dimensionY - 3][dimensionX/2+9] = true;
			initLife[dimensionY - 3][dimensionX/2+10] = true;
			initLife[dimensionY - 3][dimensionX/2+12] = true;
			initLife[dimensionY - 3][dimensionX/2+13] = true;
			initLife[dimensionY - 3][dimensionX/2+17] = true;
			initLife[dimensionY - 3][dimensionX/2+18] = true;
			initLife[dimensionY - 3][dimensionX/2+19] = true;
			initLife[dimensionY - 4][dimensionX/2+3] = true;
			initLife[dimensionY - 4][dimensionX/2+4] = true;
			initLife[dimensionY - 4][dimensionX/2+5] = true;
			initLife[dimensionY - 4][dimensionX/2+8] = true;
			initLife[dimensionY - 4][dimensionX/2+10] = true;
			initLife[dimensionY - 4][dimensionX/2+12] = true;
			initLife[dimensionY - 4][dimensionX/2+14] = true;
			initLife[dimensionY - 4][dimensionX/2+17] = true;
			initLife[dimensionY - 4][dimensionX/2+18] = true;
			initLife[dimensionY - 4][dimensionX/2+19] = true;
			initLife[dimensionY - 5][dimensionX/2+2] = true;
			initLife[dimensionY - 5][dimensionX/2+4] = true;
			initLife[dimensionY - 5][dimensionX/2+10] = true;
			initLife[dimensionY - 5][dimensionX/2+12] = true;
			initLife[dimensionY - 5][dimensionX/2+18] = true;
			initLife[dimensionY - 5][dimensionX/2+20] = true;
			initLife[dimensionY - 6][dimensionX/2+2] = true;
			initLife[dimensionY - 6][dimensionX/2+4] = true;
			initLife[dimensionY - 6][dimensionX/2+10] = true;
			initLife[dimensionY - 6][dimensionX/2+12] = true;
			initLife[dimensionY - 6][dimensionX/2+18] = true;
			initLife[dimensionY - 6][dimensionX/2+20] = true;
			initLife[dimensionY - 7][dimensionX/2+2] = true;
			initLife[dimensionY - 7][dimensionX/2+3] = true;
			initLife[dimensionY - 7][dimensionX/2+4] = true;
			initLife[dimensionY - 7][dimensionX/2+10] = true;
			initLife[dimensionY - 7][dimensionX/2+12] = true;
			initLife[dimensionY - 7][dimensionX/2+18] = true;
			initLife[dimensionY - 7][dimensionX/2+19] = true;
			initLife[dimensionY - 7][dimensionX/2+20] = true;
			initLife[dimensionY - 8][dimensionX/2+8] = true;
			initLife[dimensionY - 8][dimensionX/2+10] = true;
			initLife[dimensionY - 8][dimensionX/2+12] = true;
			initLife[dimensionY - 8][dimensionX/2+14] = true;
			initLife[dimensionY - 9][dimensionX/2+7] = true;
			initLife[dimensionY - 9][dimensionX/2+8] = true;
			initLife[dimensionY - 9][dimensionX/2+10] = true;
			initLife[dimensionY - 9][dimensionX/2+12] = true;
			initLife[dimensionY - 9][dimensionX/2+14] = true;
			initLife[dimensionY - 9][dimensionX/2+15] = true;
			initLife[dimensionY - 10][dimensionX/2+6] = true;
			initLife[dimensionY - 10][dimensionX/2+9] = true;
			initLife[dimensionY - 10][dimensionX/2+13] = true;
			initLife[dimensionY - 10][dimensionX/2+16] = true;
			initLife[dimensionY - 11][dimensionX/2+6] = true;
			initLife[dimensionY - 11][dimensionX/2+7] = true;
			initLife[dimensionY - 11][dimensionX/2+8] = true;
			initLife[dimensionY - 11][dimensionX/2+14] = true;
			initLife[dimensionY - 11][dimensionX/2+15] = true;
			initLife[dimensionY - 11][dimensionX/2+16] = true;
		} else if (initImage == 3) {
			// 蝴蝶

			initLife[dimensionY/2+4][4] = true;
			initLife[dimensionY/2+5][4] = true;
			initLife[dimensionY/2+6][4] = true;
			initLife[dimensionY/2+4][5] = true;
			initLife[dimensionY/2+5][5] = true;
			initLife[dimensionY/2+6][5] = true;
			initLife[dimensionY/2+5][6] = true;
			initLife[dimensionY/2+2][8] = true;
			initLife[dimensionY/2+4][8] = true;
			initLife[dimensionY/2+6][8] = true;
			initLife[dimensionY/2+8][8] = true;
			initLife[dimensionY/2+1][9] = true;
			initLife[dimensionY/2+9][9] = true;
			initLife[dimensionY/2+1][10] = true;
			initLife[dimensionY/2+9][10] = true;
			initLife[dimensionY/2+1][11] = true;
			initLife[dimensionY/2+9][11] = true;
			initLife[dimensionY/2+4][11] = true;
			initLife[dimensionY/2+6][11] = true;
			initLife[dimensionY/2+1][12] = true;
			initLife[dimensionY/2+2][12] = true;
			initLife[dimensionY/2+3][12] = true;
			initLife[dimensionY/2+7][12] = true;
			initLife[dimensionY/2+8][12] = true;
			initLife[dimensionY/2+9][12] = true;
		} else if (initImage == 4) {
			// 转轮
			initLife[dimensionY/2+1][dimensionX/2+4] = true;
			initLife[dimensionY/2+2][dimensionX/2+4] = true;
			initLife[dimensionY/2+2][dimensionX/2+6] = true;
			initLife[dimensionY/2+3][dimensionX/2+2] = true;
			initLife[dimensionY/2+5][dimensionX/2+1] = true;
			initLife[dimensionY/2+5][dimensionX/2+2] = true;
			initLife[dimensionY/2+7][dimensionX/2+3] = true;
			initLife[dimensionY/2+7][dimensionX/2+5] = true;
			initLife[dimensionY/2+8][dimensionX/2+5] = true;
			initLife[dimensionY/2+4][dimensionX/2+7] = true;
			initLife[dimensionY/2+4][dimensionX/2+8] = true;
			initLife[dimensionY/2+6][dimensionX/2+7] = true;
		} else {
			// 子弹
			initLife[dimensionY/2+3][dimensionX - 1] = true;
			initLife[dimensionY/2+5][dimensionX - 1] = true;
			initLife[dimensionY/2+2][dimensionX - 2] = true;
			initLife[dimensionY/2+2][dimensionX - 3] = true;
			initLife[dimensionY/2+2][dimensionX - 4] = true;
			initLife[dimensionY/2+2][dimensionX - 5] = true;
			initLife[dimensionY/2+2][dimensionX - 6] = true;
			initLife[dimensionY/2+2][dimensionX - 7] = true;
			initLife[dimensionY/2+3][dimensionX - 7] = true;
			initLife[dimensionY/2+4][dimensionX - 7] = true;
			initLife[dimensionY/2+5][dimensionX - 6] = true;
			initLife[dimensionY/2+6][dimensionX - 4] = true;
		}
	}
}
