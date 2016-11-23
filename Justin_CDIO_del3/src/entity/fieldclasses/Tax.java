package entity.fieldclasses;
import java.awt.Color;

import entity.Player;

/*
 * Man kan ikke eje tax og dens superklasse er derfor Field.	
 * Når man lander på dette felt,
 * skal man betale en pris.
 * Prisen er den mindste af enten
 * den faste betalingssum, eller skatteprocenten.
 */

//TODO: Meddelelse om skat betalt
public class Tax extends Field{
	private int taxAmount, taxRate;	
	public Tax(int fieldNumber, Color color, int taxAmount, int taxRate) {
		super(fieldNumber, color);
		this.taxAmount = taxAmount;
		this.taxRate = taxRate;
	}

	@Override
	public int landOnField(Player player) {
		int payment;
		if (taxRate <= 0) {
			payment = taxAmount;
		} else {	 				//else delen af denne kode er fra en tidligere version
			int balance = player.getBalance();
			//			Vi beregner assets som resterende penge på kontoen, det kunne have inkluderet værdien af ejendomme
			//			Dette kan evt. implementeres senere
			payment = taxRate*balance/100;
			if (taxAmount < payment) {
				payment = taxAmount;
			}
		}
		player.Transaction(-payment);
		return payment;
	}

	@Override
	public int getRent() {
		return 0;
	}

	@Override
	public int getPrice() {
		return 0;
	}

	@Override
	public int getType() {
		return 4;	// Tax
	}
	
	@Override
	public int[] getTax(int balance) {
		int[] tax = {0,0};
		tax[0] = taxAmount;
		tax[1] = taxRate;
		//tax[1] = taxRate*balance/100;
		return tax;
	}

}
