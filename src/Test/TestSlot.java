package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Slot;
import game.Translator;

public class TestSlot {

	@Test
	public void testGetValue() {
			Slot slot = new Slot(0, 100);
			int a = slot.getValue();
			assertTrue(a==100);
			
			Slot slot2 = new Slot(0, -50);
			int b = slot2.getValue();
			assertTrue(b == -50);
	}
	
	@Test
	public void testGetName() {
		for(int i = 1; i <= 11; i++){
			Slot slot = new Slot(i, 0);
			String a = slot.getName();
			assertTrue(a != null && !a.isEmpty());
		}
	}

	@Test
	public void testGetDescription() {
		for(int i = 1; i <= 11; i++){
			Slot slot = new Slot(i, 0);
			String a = slot.getDescription();
			assertTrue(a != null && !a.isEmpty());
			
		}
	}

}
