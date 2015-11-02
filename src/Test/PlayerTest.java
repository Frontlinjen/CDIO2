package Test;
import game.BaseDice;
import game.Player;
import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testPlayer() {
		Player player = new Player("SD");
		assertTrue(1000 == player.getPoints());
	}

	@Test
	public void testSetPoints() {
		Player player = new Player("SD");
		player.setPoints(1500);
		assertTrue(1500 == player.getPoints());

	}

	@Test
	public void testGetDice() {
		Player player = new Player("SD");
		BaseDice dice = player.getDice();
		assertTrue(dice!=null);
		dice.rollDice();
		assertTrue(dice.result() != 0);

	}

	@Test
	public void testCorrectPoints(){
		Player player1 = new Player("SD1");
		Player player2 = new Player("SD2");
		player1.setPoints(650);
		assertFalse(650 == player2.getPoints());

	}
}
