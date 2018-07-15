package com.coding.codechef.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MaxRooksOnChessboard {
	private static List<Chessboard> chessboards = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int row = Integer.parseInt(scanner.next());
		int column = Integer.parseInt(scanner.next());
		MaxRooksOnChessboard max = new MaxRooksOnChessboard();
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				Chessboard chessboard = max.new Chessboard(row, column);
				chessboard.startAt(i,j);
				chessboards.add(chessboard);
			}
		}
		
		Comparator<Chessboard> maxPieces = new Comparator<Chessboard> () {
			@Override
			public int compare(Chessboard o1, Chessboard o2) {
				return o2.numberOfPieces - o1.numberOfPieces;
			}
		};
		
		Collections.sort(chessboards, maxPieces);
		printChessboardStates(chessboards);
		
		scanner.close();
	}
	
	private static void printChessboardStates(List<Chessboard> chessboards) {
		for (Chessboard currentBoardState : chessboards) {
			if (chessboards.get(0).numberOfPieces == currentBoardState.numberOfPieces) {
				printChessboard(currentBoardState);
				System.out.println("==============================");
			} else {
				return;
			}
		}
	}

	private static void printChessboard(Chessboard chessboard) {
		for (int row=0; row< chessboard.chessboard.length; row++) {
			for (int column=0; column< chessboard.chessboard[row].length; column++) {
				System.out.print("| " + chessboard.chessboard[row][column] + " |");
			}
			
			System.out.println("");
		}
	}
	
	private class Chessboard {
		private int numberOfPieces;
		
		private String uniqueIdentifier;
		
		private Character[][] chessboard;
		
		private int row;
		
		private int column;
		
		public Chessboard(int row, int column) {
			this.row = row;
			this.column = column;
			this.chessboard = new Character[row][column];
		}
		
		public void startAt(int row, int column) {
			setPiece(row,column);
			setAttackPosition(row,column);
			while (boardIsFree()) {
				Position nextPos = findNextFreePosition(row,column);
				if (nextPos != null) {
					startAt(nextPos.getRow(), nextPos.getColumn());
				}
			}
			return;
		}

		private void setAttackPosition(int row, int column) {
			setAttackPositionQuadrantOne(row,column);
			setAttackPositionQuadrantTwo(row,column);
			setAttackPositionQuadrantThree(row,column);
			setAttackPositionQuadrantFour(row,column);
		}
		
		private void setAttackPositionQuadrantOne(int row, int column) {
			if (row != this.row -1 && column != this.column -1) {
				this.chessboard[row+1][column+1] = '*';
				setAttackPositionQuadrantOne(row+1, column+1);
			}
		}

		private void setAttackPositionQuadrantTwo(int row, int column) {
			if (row != 0 && column != this.column - 1) {
				this.chessboard[row-1][column+1] = '*';
				setAttackPositionQuadrantTwo(row-1, column+1);
			}
		}

		private void setAttackPositionQuadrantThree(int row, int column) {
			if (row != 0 && column != 0) {
				this.chessboard[row-1][column-1] = '*';
				setAttackPositionQuadrantThree(row-1, column-1);
			}
		}

		private void setAttackPositionQuadrantFour(int row, int column) {
			if (row != this.row -1 && column != 0) {
				this.chessboard[row+1][column-1] = '*';
				setAttackPositionQuadrantFour(row+1, column-1);
			}
		}

		private boolean boardIsFree() {
			for (int row = 0; row < chessboard.length; row++) {
				for (int column = 0; column < chessboard[row].length; column++) {
					if (chessboard[row][column] == null) {
						return true;
					}
				}
			}
			return false;
		}

		private void setPiece(int row, int column) {
			this.chessboard[row][column] = 'B';
			this.numberOfPieces++;
		}

		private Position findNextFreePosition(int i, int j) {
			for (int row=i; row<this.chessboard.length; row++) {
				for (int column=j; column<this.chessboard[row].length; column++) {
					if (chessboard[row][column] == null) {
						Position pos = new Position(row, column);
						return pos;
					}
				}
			}
			return crossCheck();
		}
		
		private Position crossCheck() {
			for (int row=0; row<this.chessboard.length; row++) {
				for (int column=0; column<this.chessboard[row].length; column++) {
					if (chessboard[row][column] == null) {
						Position pos = new Position(row, column);
						return pos;
					}
				}
			}
			return null;
		}

		private class Position {
			private int row;
			
			private int column;
			
			public Position(int row, int column) {
				this.row = row;
				this.column = column;
			}
			
			public int getRow() {
				return row;
			}

			public int getColumn() {
				return column;
			}
		}
	}
}
