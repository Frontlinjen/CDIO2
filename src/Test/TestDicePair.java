package Test;

import game.BaseDice;
import game.DicePair;

import static org.junit.Assert.*;

import org.junit.Test;

import game.BaseDice;

public class TestDicePair {

	@Test
	public void testRollDice() {
		BaseDice dice = new DicePair();
		double[] test = new double[11];
		double[] sandsynlighed = {(1.0d/36*100),(1.0d/18*100),(1.0d/12*100),(1.0d/9*100),(5.0d/36*100),(1.0d/6*100),(5.0d/36*100),(1.0d/9*100),(1.0d/12*100),(1.0d/18*100),(1.0d/36*100)};
		double[] slag = new double [11];
		for(int i = 0; i <= 5000; i++){
			dice.rollDice();
			test[dice.result()-2]++;
		}
		for(int j = 0; j < test.length; j++) {
			double percent = ((test[j] / 5000)*100);
			double afvigelse = Math.abs(percent - sandsynlighed[j]);
			double retur = 0;
			System.out.println("Hvis du slår " + (j+2) + " så er er sandsynligheden: " + percent + " %");
			System.out.println("Afvigelsen for den statistiske sandsynlighed for at slå " + (j+2) + " bliver: " + afvigelse);
			retur += afvigelse;
			assertTrue(2.5 > afvigelse);
		}
	}

}