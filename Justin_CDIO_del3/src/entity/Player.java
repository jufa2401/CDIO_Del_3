package entity;
public class Player {

	private String name;
	private int balance, currentField, d1, d2, fleetsOwned,LaborCampsOwned, Identifier;
	private boolean hasLost;
	private static int AvailableIdentifer = 0;
	/**
	 * Den private int anvendes til at give hver spiller et unikt id
	 * 
	 * @param name
	 * @param balance
	 */
	public Player (String name, int balance){
		this.name = name;
		this.balance = balance;
		fleetsOwned = 0;
		LaborCampsOwned = 0;
		hasLost = false;
		currentField = 0;
		Identifier = AvailableIdentifer++;
	}
	public Player() {
	}
	//getters and setters for navn og balance 
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 	 metode der tjekker om en spiller har tabt
	 * @return
	 */
	public boolean hasLost() {
		if (balance <= 0) {
			hasLost = true;
		}
		return hasLost;
	}
	// nedenstående metode bliver ikke brugt, og kan fjernes
	public void setHasLost(boolean hasLost) {
		this.hasLost = hasLost;
	}
	public int getBalance() {
		return balance;
	}
	//	Getters og setters til fleets
	public int getFleetsOwned() {
		return fleetsOwned;
	}
	public void setFleetsOwned(int fleetsOwned) {
		this.fleetsOwned = fleetsOwned;
	}
	public int getLaborCampsOwned() {
		return LaborCampsOwned;
	}
	public void setLaborCampsOwned(int laborCampsOwned) {
		this.LaborCampsOwned = laborCampsOwned;
	}

	/**
	 *  Vi laver metode til at gemme terningsummen, denne metode er lavet specifikt 
	 *  med hensyn til felter hvor aktionen er bestemt af terningsummen.
	 */
	public void SaveDiceRoll(DiceCup dice){
		int[] d = dice.getDiceValue();
		this.d1 = d[0];
		this.d2 = d[1];
	}
	public int getDiceSum() {
		return d1 + d2;
	}

	/**
	 * Metode til overførsel af penge
	 * Hvis balancen ryger under nul bliver balancen sat til 0
	 * @param amount
	 * @return
	 */
	public int Transaction(int amount){
		balance = balance + amount;
		if(balance < 0){
			balance = 0;
		}
		return balance;
	}	

	/**
	 * 	Giver muligheden for at betale til andre spillere, afslutter med at returnere den ændrede balance
	 *  Hvis en spiller lander på sit eget felt, trækker man i princippet fra sin egen konto, men de bliver tilført igen med det samme.
	 * @param recipient
	 * @param amount
	 * @return
	 */
	public int payTo (Player recipient, int amount) {
		recipient.Transaction(amount);
		Transaction(-amount);
		return balance;
	}

	//	Getters and setters for fieldnumber
	public int getCurrentField() {
		return currentField;
	}
	/**
	 * 	Når vi rykker os udover arraylængden ruller vi rundt ved at trække arraylængden fra.
	 * @param roll
	 * @param gb
	 * @return
	 */
	public int moveToField(int roll, GameBoard gb) {
		int length = gb.getNumberOfFields();
		this.currentField += roll;
		while(this.currentField >= length)
			this.currentField -= length;
		return this.currentField;
	}

	public int getPlayerID() {
		return this.Identifier;
	}



}






