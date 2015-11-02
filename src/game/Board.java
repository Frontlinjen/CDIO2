package game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import desktop_fields.Tax;
import desktop_resources.GUI;

public class Board {
	private Slot[] slot;
	private Tax[] fields;
	private List<Player> players = new ArrayList<Player>();
	
	private Player currentPlayer;
	
	public Player getCurrentPlayer()
	{
		return currentPlayer;
	}
	public void createPlayer(String name)
	{
		Player newPlayer = new Player(name);
		players.add(newPlayer);
		GUI.addPlayer(name, 1000);
		desktop_board.Board.getInstance().updatePlayers();
	}
	
	private void setupPlayers(){
		String user1 = GUI.getUserString("Velkommen!\nIndtast navn p� spiller 1:");
		createPlayer(user1);
		String user2 = GUI.getUserString("Indtast navn p� spiller 2:");
		//Player2 cannot be called the same as player1
		while(user2.equals(user1))
		{
			user2 = GUI.getUserString("Navnet kan ikke v�re det samme som spiller 1. Pr�v igen!");
		}
		createPlayer(user2);
	}
	
	public void evaluateRoll(int val)
	{
		
	}
	
	/**
	 * Advances to the next player. 
	 */
	private void swapPlayers()
	{
		int pos = players.indexOf(currentPlayer);
		//Checks to see if we will surpass the bonds 
		if(pos+1 >= players.size())
		{
			//If it does, then we have reached the end of the list and shall therefore start over
			currentPlayer = players.get(0);

		}
		else
		{
			//If it doesn't, then advance to the next player. 
			currentPlayer = players.get(pos+1);
		}
	}
	private void initializeBoard()
	{
		slot = new Slot[] {new Slot(1,250), new Slot(2,-100), new Slot(3,100), new Slot(4,-20), new Slot(5,180), new Slot(6,0), new Slot(7,-70), new Slot(8,60), new Slot(9, -80), new Slot(10,-50), new Slot(11,650)};
		fields = new Tax[11];
		for (int i = 0; i < fields.length; i++) {
			Color col;
			if (i%2 == 0)
			{
				col = new Color(212, 109, 6);
			}
			else
			{
				col = new Color(79, 161, 131);
			}
			Tax t = new Tax.Builder().setBgColor(col).build();
			fields[i] = t;
		}
		for (int i = 0; i < 11; i++){
			fields[i].setDescription(slot[i].getDescription());
			fields[i].setTitle(slot[i].getName());
			fields[i].setSubText(slot[i].getValue()+"");
		}
		GUI.create(fields);
	}
	public void AdvanceGame(BaseDice dice)
	{
		int tempResult = dice.result()-2;
		GUI.removeAllCars(currentPlayer.getName());
		GUI.setCar(tempResult+1, currentPlayer.getName());
		currentPlayer.addPoints(slot[tempResult].getValue());
		fields[tempResult].displayOnCenter();
		
	}
	public void startGame(){
		initializeBoard();
		setupPlayers();
		boolean running = true;
		while(running)
		{
			currentPlayer = players.get(0);
			
			while(true){
				GUI.showMessage("Det er: " + currentPlayer.getName()+ "'s tur!");
				BaseDice tempDice = currentPlayer.getDice();
				tempDice.rollDice();
				AdvanceGame(tempDice);
				if(currentPlayer.getPoints() >= 3000){
					break;
				}
				else{
					swapPlayers();
				}	
				
			}
			if(GUI.getUserLeftButtonPressed(currentPlayer.getName() + " har vundet.", "Retry", "Stop Game")) {
				for(Player player : players) {
					player.setPoints(1000);
					GUI.removeAllCars(player.getName());
				}

			}
			else {
				running = false;
			}
		}
		GUI.close();

	}
	public static void main(String[] args) {
		Board board = new Board();
		board.startGame();
	}
	

}
