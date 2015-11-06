package game;

public class Account {	
	private int gold = 0;

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
		if(getGold()<0)
		{
			setGold(0);
		}
	}
	
	public void addGold(int gold){
		setGold(gold+getGold());
	}

	@Override
	public String toString() {
		return "Currently contains: " + gold + " gold";
	}
}
