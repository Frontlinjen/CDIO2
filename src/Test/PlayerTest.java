package Test;
import game.BaseDice;
import game.Player;
import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testPlayer() {
		Player player = new Player("Sara");
		assertTrue(1000 == player.getPoints());
		assertTrue("Sara"==player.getName());
	}

	@Test
	public void testSetPoints() {
		Player player = new Player("Sara");
		player.setPoints(1500);
		assertTrue(1500 == player.getPoints());
		//Tester at brugerens acc ikke går i negativ
		player.setPoints(-500);
		assertFalse(player.getPoints()==-500);
	}

	@Test
	public void testGetDice() {
		Player player = new Player("Sara");
		BaseDice dice = player.getDice();
		assertTrue(dice!=null);
		dice.rollDice();
		assertTrue(dice.result() != 0);

	}

	@Test
	public void testCorrectPoints(){
		Player player1 = new Player("Sara1");
		Player player2 = new Player("Sara2");
		player1.setPoints(650);
		assertFalse(650 == player2.getPoints());

	}
}
