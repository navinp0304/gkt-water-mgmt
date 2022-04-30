package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TankerCalculatorTest {

	@Test
	void testGetCost() {
		TankerCalculator tankerCalc = new TankerCalculator();
		//Apartment apt = new Apartment(2,0.3,5);
		Apartment apt=new AllotCommand().parseCommand("ALLOT_WATER 2 3:7");
		apt = new AddGuestsCommand().parseCommand(apt,"ADD_GUESTS 5");

		Double[] rate= tankerCalc.getCost(apt);
		Double[] exp = {1500.0,4000.0};
		assertAll("tanker calc get cost",
				() -> assertEquals(rate[0], exp[0],1.0e-6),
				() -> assertEquals(rate[1],exp[1],1.0e-6)
				);
	}

	@Test
	void testTankerCalculator() {
		TankerCalculator tankerCalc = new TankerCalculator();
		assertNotEquals(tankerCalc,null);
	}

}
