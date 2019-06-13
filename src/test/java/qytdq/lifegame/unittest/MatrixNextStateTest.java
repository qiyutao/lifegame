package qytdq.lifegame.unittest;

import static org.junit.Assert.*;

import org.junit.Test;

import qytdq.lifegame.algo.GameMatrix;


public class MatrixNextStateTest {

	@SuppressWarnings("unused")
	private static void printMatrix(boolean[][] matrix) {
		for (int i = 0;i < matrix.length; ++ i) {
			for (int j = 0; j < matrix[0].length; ++ j) {
				System.out.print(matrix[i][j] ? "true  " : "false ");
			}
			System.out.println();
		}
	}
	
	@Test
	public void testNextStatusCase1() {
		boolean[][] graph = {
				{false, false, false, false, false, false, false },
				{false, false, false, false, false, false, false },
				{false, false, false, true , false, false, false },
				{false, false, false, true , true , false, false },
				{false, false, true , false, true , false, false },
				{true , false, false, false, false, false, true  },
		};
		boolean[][] nextGraph = {
				{false, false, false, false, false, false, false },
				{false, false, false, false, false, false, false },
				{false, false, false, true , true, false, false },
				{false, false, true , false, true , false, false },
				{false, false, false, false, true , true , false },
				{false, false, false, false, false, false, false },
		};
		GameMatrix game = new GameMatrix(7, 6, 2);
		game.setMatrix(graph);
		game.nextMatrix();
		assertArrayEquals(nextGraph, game.getMatrix());
	}

	@Test
	public void testNextStatusCase2() {
		boolean[][] graph = {
				{true , false, true , false, false, false, false },
				{true , false, false, false, false, true , true  },
				{false, false, false, false, false, true , false },
				{false, false, false, false, false, false, true  },
				{false, false, false, false, false, false, false },
				{false, false, false, false, false, false, false },
		};
		boolean[][] nextGraph = {
				{false, true , false, false, false, false, false },
				{false, true , false, false, false, true , true  },
				{false, false, false, false, false, true , false },
				{false, false, false, false, false, false, false },
				{false, false, false, false, false, false, false },
				{false, false, false, false, false, false, false },
		};

		GameMatrix game = new GameMatrix(7, 6, 2);
		game.setMatrix(graph);
		game.nextMatrix();
		assertArrayEquals(nextGraph, game.getMatrix());
	}

	@Test
	public void testNextStatusCase3() {
		boolean[][] graph = {
				{false, false, false, false, false, false, false },
				{false, false, true , false, false, false, false },
				{false, false, true , true , true , false, false },
				{false, false, false, true , true , false, false },
				{false, false, false, false, false, false, false },
				{false, false, false, false, false, false, false },
		};
		boolean[][] nextGraph = {
				{false, false, false, false, false, false, false },
				{false, false, true , false, false, false, false },
				{false, false, true , false, true , false, false },
				{false, false, true , false, true , false, false },
				{false, false, false, false, false, false, false },
				{false, false, false, false, false, false, false },
		};
		GameMatrix game = new GameMatrix(7, 6, 2);
		game.setMatrix(graph);
		game.nextMatrix();
		assertArrayEquals(nextGraph, game.getMatrix());
	}
}
