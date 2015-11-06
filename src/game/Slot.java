package game;


public class Slot {

	private int value;
	private int id;
	
	public Slot(int i, int val){
		value = val;
		id = i;
	}

	public int getValue() {
		return value;
	}
	public String getName() {
		return Translator.getString("SLOT" + id);
	}
	public String getDescription() {
		return Translator.getString("SLOTDSC" + id);
	}

	@Override
	public String toString() {
		return "Slot [value=" + value + ", id=" + id + ", title" + getName() + "]";
	}
	
	
}
