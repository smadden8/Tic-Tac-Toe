package edu.jsu.mcis;

public class TicTacToe {

	public enum Mark {XMARK, OMARK, EMPTY};
	public enum GameStatus {XWIN, OWIN, TIE, INPROGRESS};
	private Mark[][] board;
	private GameStatus status;
	private int a;
	private int b;
	private char nextTurn;
	private char mark;
	private Mark m;
	
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
	
	public char setTurn() {
		
		char currentTurn = this.getMarkAt(a, b);
		if(currentTurn == 'X') {
			nextTurn = 'O';
		}
		else if(currentTurn == 'O') {
			nextTurn = 'X';
		}
        else if(currentTurn == 'O' && nextTurn == 'X') {
			currentTurn = 'O';
			nextTurn = 'X';
		}
		else if(currentTurn == 'X' && nextTurn == 'O') {
			currentTurn = 'X';
			nextTurn = 'O';
		}
		
		else if(currentTurn == ' ' && nextTurn != 'X' && nextTurn != 'O') {
			currentTurn = 'X';
			nextTurn = 'O';
			return currentTurn;
		}
        
		else if(currentTurn == ' ' && nextTurn == 'X') {
			currentTurn = 'X';
			nextTurn = 'O';
			return currentTurn;
		} 
		else if(currentTurn == ' ' && nextTurn == 'O') {
			currentTurn = 'O';
			nextTurn = 'X';
			return currentTurn;
		}
		
		
		return currentTurn;
	}
	
	public void setMarkAt(int row, int col) {
		if (board[row][col] == Mark.XMARK || board[row][col] == Mark.OMARK) {
			throw new IllegalArgumentException("Cannot put mark over existing mark.");
		}
		char mark = this.setTurn();
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
	
	public GameStatus gameWinner() {
		
		char winner = this.getMarkAt(a, b);
		if(winner == 'X') {
			status = GameStatus.XWIN;
			return status;
		} else if(winner == 'O') {
			status = GameStatus.OWIN;
			return status;
		} else if(winner != 'X' && winner != 'O' && gameIsOver() == true) {
			status = GameStatus.TIE;
			return status;
		} else return GameStatus.INPROGRESS;
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
		if(gameWinner() == GameStatus.XWIN) {
			n = true;
		}
		else if(gameWinner() == GameStatus.OWIN) {
			n = true;
		}
		else if(gameWinner() == GameStatus.TIE) {
			n = true;
		}
		return n;
	}
	
	
	
}
