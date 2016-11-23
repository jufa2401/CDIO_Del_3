package entity;

public class PlayerList {
	//Tomt Playerarray
	private int playerCount;
	private Player[] players;


	public PlayerList (int playerCount) {
		this.players = new Player[playerCount];
		for (int c = 0; c < playerCount; c++)
			players[c] = new Player();
		this.playerCount = playerCount;
	}


	public void addPlayer(int ID, String name) {
		players[ID] = new Player(name, 30000);

	}
	


	public Player getPlayer(int ID) {
		
		return players[ID];
	}
	public int getNumberofPlayer() {
		return playerCount;
	}

/*
 *  Kunne ikke få GUI'en til at vise spillere med samme navn,
 *  og laver derfor kode som stopper brugeren for at gøre dette
*/
	public boolean isNameUsed(int numberOfDefinedPlayers, String name) {
		boolean isUsed = false;
		for (int i = 0; i < numberOfDefinedPlayers; i++) {
			if (players[i].getName().equalsIgnoreCase(name)){
				//TODO Der skal komme en besked til brugeren om at navnet er i brug og samme navn ikke kan benyttes igen.
				// ALternativt kunne man overskrive navnet ved at tilføje et tal til den første bruger af navnet og hvis flere med sammme navn tilføjes får de nummering derefter.
				isUsed = true;	
			}
		}
		return isUsed;
	}


	public boolean isWinner() {
		int n = 0;
		for (int c = 0; c < playerCount; c++) {
			if (!players[c].hasLost()) {
				n++;	
			} 
		}
		return (n == 1);
	}
	
	// Forudsætter at vi ved der er en vinder
	public String getWinner() {
		String name = "";
		for (int c = 0; c < playerCount; c++) {
			if (!players[c].hasLost()) {
				name = players[c].getName();	
			} 
		}
		return name;
	}


}

