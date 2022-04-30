package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CorporationCalculatorTest {

	@Test
	void testGetCost() {
		CorporationCalculator calculator = new CorporationCalculator();
//		Apartment apt = new Apartment(2,0.5,0);
		Apartment apt=new AllotCommand().parseCommand("ALLOT_WATER 2 1:1");

		Double[] rate = calculator.getCost(apt);
		Double[] exp = {450.0,450.0};
		assertAll("RateSummary corporation",
				() -> assertEquals(rate[0],exp[0],1.0e-6),
				() -> assertEquals(rate[1],exp[1])
				);
	}

	@Test
	void testCorporationCalculator() {
		CorporationCalculator calculator = new CorporationCalculator();
		assertNotEquals(calculator,null);
	}

}
