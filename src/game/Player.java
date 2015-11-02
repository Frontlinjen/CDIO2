package game;

import desktop_resources.GUI;

public class Player {
	private String name;
	/**
	 * Each player has their own set of dice which keeps track of their rolls. 
	 */
	private BaseDice dice = new DicePair();
	private Account account = new Account();
	
	public Player(String s)
	{
		name = s;
		setPoints(1000);
	}
	public String getName()
	{
		return name;	
	}
	public int getPoints()
	{
		return account.getGold();
	}
	public void setPoints(int p)
	{
		//GUI.removeAllCars(name);
		account.setGold(p);
		//GUI.setCar(Math.min(points, 40), name);
		GUI.setBalance(name, getPoints());
	}
	public void addPoints(int p)
	{
		setPoints(getPoints()+p);
	}
	public BaseDice getDice()
	{
		return dice;
	}
	private Player()
	{}
	
	
}
 