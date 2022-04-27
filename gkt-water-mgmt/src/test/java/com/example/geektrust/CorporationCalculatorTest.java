package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CorporationCalculatorTest {

	@Test
	void testGetCost() {
		CorporationCalculator calculator = new CorporationCalculator();
		Apartment apt = new Apartment(2,0.5,0);
		RateSummary rate = calculator.getCost(apt);
		RateSummary exp = new RateSummary(450.0,450.0);
		assertAll("RateSummary corporation",
				() -> assertEquals(rate.getCost(),exp.getCost(),1.0e-6),
				() -> assertEquals(rate.getLitres(),exp.getLitres())
				);
	}

	@Test
	void testCorporationCalculator() {
		CorporationCalculator calculator = new CorporationCalculator();
		assertNotEquals(calculator,null);
	}

}
