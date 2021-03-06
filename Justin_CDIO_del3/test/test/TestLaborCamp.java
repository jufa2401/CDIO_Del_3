package test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import entity.fieldclasses.*;
import entity.*;

public class TestLaborCamp {

	private Player player;
	private LaborCamp feltlabor;
	private Player ejer = new Player("ejer", 10000);
	private DiceCup d12;
	
	@Before
	public void setUp() throws Exception {
		this.player = new Player("Doland Dak", 10000);
		this.feltlabor = new LaborCamp(1, Color.BLACK, 2000);
		this.d12 = new DiceCup();
	}

	@After
	public void tearDown() throws Exception {
		this.player = new Player("Doland Dak", 10000);	
	}

//	@Test
//	public void testGetRent() {
//		fail("Not yet implemented"); // TODO
//	}

//	@Test
//	public void testGetPrice() {
//		fail("Not yet implemented"); // TODO
//	}

//	@Test
//	public void testGetType() {
//		fail("Not yet implemented"); // TODO
//	}

	@Test
	public void testEntities() {
		Assert.assertNotNull(this.player);
		Assert.assertNotNull(this.feltlabor);
		
		Assert.assertTrue(this.feltlabor instanceof LaborCamp);
	}
	
	@Test
	public void testLandOnField() {
		int expected = 10000;
		int actual = this.player.getBalance();
		Assert.assertEquals(expected, actual);
		
		//Tester om når der er én ejer af af laborcampen og en anden spiller lander derpå om balancen bliver påvirket korrekt.
		d12.rollDiceCup();
		this.player.SaveDiceRoll(d12);
		ejer.setLaborCampsOwned(1);
		this.feltlabor.setOwner(ejer);
		this.feltlabor.landOnField(this.player);
		
		expected = 10000 - (100 * d12.getDiceSum());
		actual = this.player.getBalance();
		
		Assert.assertTrue(this.feltlabor.getOwner() == ejer);
		Assert.assertEquals(expected, actual);
		}

	@Test
	public void testLandOnField2() {
		int expected = 10000;
		int actual = this.player.getBalance();
		Assert.assertEquals(expected, actual);
		
		//Tester om når der er én ejer af af laborcampen og en anden spiller lander derpå om balancen bliver påvirket korrekt.
		d12.rollDiceCup();
		this.player.SaveDiceRoll(d12);
		ejer.setLaborCampsOwned(2);
		this.feltlabor.setOwner(ejer);
		this.feltlabor.landOnField(this.player);
		
		expected = 10000 - (100 * d12.getDiceSum() * 2);
		actual = this.player.getBalance();
		
		Assert.assertTrue(this.feltlabor.getOwner() == ejer);
		Assert.assertEquals(expected, actual);
		}

}
