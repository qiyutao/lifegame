package start;

import java.awt.EventQueue;

import javax.swing.JDialog;

import qytdq.lifegame.algo.GameMatrix;
import qytdq.lifegame.view.Dialog;

public class Main {

	private static boolean controller = true;

	public static void PrintMatrix(boolean[][] matrix) {
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j) {
				System.out.print(matrix[i][j] ? "*" : "-");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		if (controller) {
			GameMatrix gameMatrix = new GameMatrix(40, 30, 40);
			gameMatrix.init();
			while (true) {
				try {
					gameMatrix.nextMatrix();
					Main.PrintMatrix(gameMatrix.getMatrix());
					Thread.sleep(400);
					Runtime.getRuntime().exec("clear");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				// 1. Java事件分发线程
				EventQueue.invokeLater(() -> {
					Dialog dialog = new Dialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					
				});
			} catch (Exception e) {
			}
		}
	}
}