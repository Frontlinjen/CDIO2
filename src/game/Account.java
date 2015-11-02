package game;

public class Account {

	public Account(){
		gold = 0;
	}
	
	private int gold;

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
}
