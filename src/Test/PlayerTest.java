package Test;
import game.Player;
import game.
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
		
	}

	@Test
	public void testCorrectPoints(){
		Player player1 = new Player("SD1");
		Player player2 = new Player("SD2");
		
	}
}
