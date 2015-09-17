package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	
	private TicTacToe t;
	
	@Before
	public void setUp() {
		t = new TicTacToe();
	}
	@Test
	public void testInitialBoardIsEmpty() {
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				assertEquals(' ', t.getMarkAt(row, col));
			}
		}
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		t.setMarkAt(0, 2);
		assertEquals('X', t.getMarkAt(0, 2));
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		t.setMarkAt(1, 2);
		t.setMarkAt(2, 0);
		assertEquals('X', t.getMarkAt(1, 2));
		assertEquals('O', t.getMarkAt(2, 0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testUnableToMarkOverExistingMark() {
		t.setMarkAt(1, 2);
		t.setMarkAt(1, 2);
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		t.setMarkAt(2, 1);
		t.setMarkAt(2, 2);
		t.setMarkAt(1, 1);
		t.setMarkAt(1, 2);
		assertEquals('X', t.getMarkAt(2, 1));
		assertEquals('O', t.getMarkAt(2, 2));
		assertEquals('X', t.getMarkAt(1, 1));
		assertEquals('O', t.getMarkAt(1, 2));
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		t.setMarkAt(0, 0);
		t.setMarkAt(1, 0);
		t.setMarkAt(0, 1);
		t.setMarkAt(2, 0);
		t.setMarkAt(0, 2);
		assertEquals('X', t.getMarkAt(0, 0));
		assertEquals('X', t.getMarkAt(0, 1));
		assertEquals('X', t.getMarkAt(0, 2));
		assertEquals(true, t.gameIsWon());
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		t.setMarkAt(1, 1);
		t.setMarkAt(1, 2);
		t.setMarkAt(2, 0);
		t.setMarkAt(2, 1);
		t.setMarkAt(2, 2);
		
		t.setMarkAt(1, 0);
		t.setMarkAt(0, 0);
		
		t.setMarkAt(0, 1);
		t.setMarkAt(0, 2);
		
		assertEquals('X', t.getMarkAt(1, 1));
		assertEquals('O', t.getMarkAt(1, 2));
		assertEquals('X', t.getMarkAt(2, 0));
		assertEquals('O', t.getMarkAt(2, 1));
		assertEquals('X', t.getMarkAt(2, 2));
		
		assertEquals('O', t.getMarkAt(1, 0));
		assertEquals('X', t.getMarkAt(0, 0));
		
		assertEquals('O', t.getMarkAt(0, 1));
		assertEquals('X', t.getMarkAt(0, 2));
		
		assertEquals(true, t.gameIsOver());
	}
	
	
	@Test
	public void gameWinnerIsX() {
		t.setMarkAt(0, 0);
        // t.setTurn();
		t.setMarkAt(1, 1);
		t.setMarkAt(1, 0);
		t.setMarkAt(0, 2);
		t.setMarkAt(2, 0);
		assertEquals('X', t.getMarkAt(0, 0));
		assertEquals('O', t.getMarkAt(1, 1));
		assertEquals('X', t.getMarkAt(1, 0));
		assertEquals('O', t.getMarkAt(0, 2));
		assertEquals('X', t.getMarkAt(2, 0));
		assertEquals(TicTacToe.GameStatus.XWIN, t.gameWinner());
		
		
		// t.setMarkAt(2, 0);
		// t.setMarkAt(2, 2);
		// t.setMarkAt(1, 1);
		// t.setMarkAt(1, 2);
		// assertEquals('X', t.getMarkAt(2, 0));
		// assertEquals('O', t.getMarkAt(2, 2));
		// assertEquals('X', t.getMarkAt(1, 1));
		// assertEquals('O', t.getMarkAt(1, 2));
		// assertEquals(TicTacToe.GameStatus.XWIN, t.gameWinner());
	}
	
	
	@Test
	public void gameWinnerisO() {
		t.setMarkAt(1, 1);
		t.setMarkAt(0, 0);
		t.setMarkAt(0, 2);
		t.setMarkAt(1, 0);
		t.setMarkAt(2, 1);
		t.setMarkAt(2, 0);
		assertEquals('X', t.getMarkAt(1, 1));
		assertEquals('O', t.getMarkAt(0, 0));
		assertEquals('X', t.getMarkAt(0, 2));
		assertEquals('O', t.getMarkAt(1, 0));
		assertEquals('X', t.getMarkAt(2, 1));
		assertEquals('O', t.getMarkAt(2, 0));
		assertEquals(TicTacToe.GameStatus.OWIN, t.gameWinner());
	}
    
    @Test
    public void setNextTurn() {
        // assertEquals('O', t.setTurn());
        // assertEquals('X', t.setTurn());
        // assertEquals('O', t.setTurn());
        
        // t.getMarkAt(0, 0);
        char c = t.setTurn();
        char d = t.setTurn();
        char e = t.setTurn();
        char f = t.setTurn();
        char g = t.setTurn();
        char h = t.setTurn();
        char i = t.setTurn();
        char j = t.setTurn();
        char k = t.setTurn();
        assertEquals('X', c);
        assertEquals('O', d);
        assertEquals('X', e);
        assertEquals('O', f);
        assertEquals('X', g);
        assertEquals('O', h);
        assertEquals('X', i);
        assertEquals('O', j);
        assertEquals('X', k);
    }
	
}
