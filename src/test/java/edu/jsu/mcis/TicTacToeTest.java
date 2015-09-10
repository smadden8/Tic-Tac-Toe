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
		assertEquals('X', t.getMarkAt(2, 1));
		assertEquals('O', t.getMarkAt(2, 2));
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
		t.setMarkAt(0, 0);
		t.setMarkAt(0, 1);
		t.setMarkAt(0, 2);
		t.setMarkAt(1, 0);
		t.setMarkAt(1, 1);
		t.setMarkAt(1, 2);
		t.setMarkAt(2, 0);
		t.setMarkAt(2, 1);
		t.setMarkAt(2, 2);
		assertEquals(true, t.gameIsOver());
	}
	
	
	@Test
	public void gameWinnerIsX() {
		t.setMarkAt(0, 0);
		t.setMarkAt(0, 1);
		t.setMarkAt(1, 0);
		t.setMarkAt(0, 2);
		t.setMarkAt(2, 0);
		assertEquals('X', t.getMarkAt(0, 0));
		assertEquals('X', t.getMarkAt(1, 0));
		assertEquals('X', t.getMarkAt(2, 0));
		assertEquals('X', t.gameWinner());
	}
	
	
	@Test
	public void gameWinnerisO() {
		t.setMarkAt(0, 0);
		t.setMarkAt(0, 1);
		t.setMarkAt(1, 0);
		t.setMarkAt(1, 1);
		t.setMarkAt(0, 2);
		t.setMarkAt(1, 2);
		assertEquals('O', t.gameWinner());
	}
	
}
