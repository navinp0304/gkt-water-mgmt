package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BorewellCalculatorTest {

	@Test
	void testGetCost() {
		IRateCalculator boreCalculator = new BorewellCalculator();
		//Apartment apt=new Apartment(2,0.5,0);
		Apartment apt=new AllotCommand().parseCommand("ALLOT_WATER 2 1:1");
		Double[] rate = boreCalculator.getCost(apt);
		Double[] exp = new Double[]{450.0,675.0};
		assertAll("Checking rate Summaries ",
				() -> assertEquals(rate[0],exp[0],1.0e-6),
				() -> assertEquals(rate[1],exp[1],1.0e-6)
				);
				
				
	}

	@Test
	void testBorewellCalculator() {
		IRateCalculator boreCalculator = new BorewellCalculator();
		assertNotEquals(boreCalculator, null);
	}

}
