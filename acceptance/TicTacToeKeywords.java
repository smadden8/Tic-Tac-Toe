import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	private TicTacToe t;
	
	public void startNewGame() {
		t = new TicTacToe();
	}
	
	public void markLocation(int row, int col, char mark) {
		t.setMarkAt(row, col, mark);
	}
	
	public String getMark(int row, int col) {
		char m = t.getMarkAt(row, col);
		if(m == 'X') return "X";
		else if(m == 'O') return "O";
		else return "";

	}
    
	public String getWinner() {
		char theWinner = t.gameWinner();
		if(theWinner == 'X') return "X";
		else if(theWinner == 'O') return "O";
		else return "";
	}
}
