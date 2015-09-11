package edu.jsu.mcis;

public class TicTacToe {

	public enum Mark {XMARK, OMARK, EMPTY};
	private Mark[][] board;
	private int a;
	private int b;
	
	public TicTacToe() {
		board = new Mark[3][3];
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board.length; c++) {
				board[r][c] = Mark.EMPTY;
			}
		}
		
	}



	public static void main(String[] args) {
		
	}
	
	public char getMarkAt(int row, int col) {
		if(board[row][col] == Mark.XMARK) return 'X';
		else if(board[row][col] == Mark.OMARK) return 'O';
		else return ' ';
	}
	
	public void setMarkAt(int row, int col, char mark) {
		if (board[row][col] == Mark.XMARK || board[row][col] == Mark.OMARK) {
			throw new IllegalArgumentException("Cannot put mark over existing mark.");
		}
		
		Mark m = Mark.XMARK;
		if(mark == 'X') m = Mark.XMARK;
		else if(mark == 'O') m = Mark.OMARK;
		board[row][col] = m;
	}
	
	public boolean gameIsWon() {
		
		boolean isGameOver = false;
		int row = 0;
		for(int col = 0; col < board[row].length; col++) {
			if(board[row][col] == Mark.XMARK || board[row][col] == Mark.OMARK) {
				isGameOver = true;
				return isGameOver;
				
			} else isGameOver = false;

		}
		
		return isGameOver;
	}
	
	public boolean gameIsOver() {
		boolean n = false;
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board.length; col++) {
				if(board[row][col] == Mark.XMARK || board[row][col] == Mark.OMARK) {
					n = true;
					return n;
				} else n = false;
			}
		}
		return n;
	}
	
	public char gameWinner() {
		
		char winner = this.getMarkAt(a, b);
		if(winner == 'X') {
			return 'X';
		} else if(winner == 'O') {
			return 'O';
		} else return ' ';
	}
	
}
