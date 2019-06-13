package qytdq.lifegame.algo;

/**
 * 
 */
public class GameMatrix {
	// 随机点数目
	private int randomCluster;
	// 矩阵
	private boolean[][] matrix;
	// 矩阵维度
	private int width;
	private int height;

	/**
	 * @param width
	 * @param height
	 * @param randomCluster
	 */
	public GameMatrix(int width, int height, int randomCluster) {
		matrix = new boolean[height][width];

		this.width = width;
		this.height = height;
		this.randomCluster = randomCluster;
	}

	public boolean[][] init() {
		initRandomMat();
		return matrix;
	}

	// 随机初始化簇
	private void initRandomMat() {
		for (int i = 0; i < randomCluster; i++) {
			int col = (int) (width * Math.random());
			int row = (int) (height * Math.random());

			for (int j = col - 1; j < col + 2; j++) {
				for (int k = row - 1; k < row + 2; k++) {
					if ((j >= 0 && j < width) && (k >= 0 && k < height)) {
						if (Math.random() * 2 >= 1) {
							matrix[k][j] = true;
						}
					}
				}
			}
		}
	}

	// TODO:refactor
	public void nextMatrix() {
		boolean[][] newMat = new boolean[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int lifeNum = aroundLife(i, j);
				if (lifeNum < 2) {
					newMat[i][j] = false;
				} else if (lifeNum == 2 && matrix[i][j]) {
					newMat[i][j] = true;
				} else if (lifeNum == 3) {
					newMat[i][j] = true;
				} else {
					newMat[i][j] = false;
				}
			}
		}

		matrix = newMat;
	}

	private int aroundLife(int row, int col) {
		int lifeNum = 0;
		for (int i = col - 1; i < col + 2; i++) {
			for (int j = row - 1; j < row + 2; j++) {
				if ((i >= 0 && i < width) && (j >= 0 && j < height) && !(i == col && j == row)) {
					if (matrix[j][i])
						lifeNum += matrix[j][i] == false ? 0 : 1;
				}
			}
		}

		return lifeNum;
	}

	public void setMatrix(boolean[][] matrix) {
		this.matrix = matrix;
	}

	public boolean[][] getMatrix() {
		return matrix;
	}
}