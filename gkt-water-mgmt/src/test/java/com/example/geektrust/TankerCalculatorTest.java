package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TankerCalculatorTest {

	@Test
	void testGetCost() {
		TankerCalculator tankerCalc = new TankerCalculator();
		Apartment apt = new Apartment(2,0.3,5);
		RateSummary rate= tankerCalc.getCost(apt);
		RateSummary exp = new RateSummary(1500.0,4000.0);
		assertAll("tanker calc get cost",
				() -> assertEquals(rate.getLitres(), exp.getLitres(),1.0e-6),
				() -> assertEquals(rate.getCost(),exp.getCost(),1.0e-6)
				);
	}

	@Test
	void testTankerCalculator() {
		TankerCalculator tankerCalc = new TankerCalculator();
		assertNotEquals(tankerCalc,null);
	}

}
