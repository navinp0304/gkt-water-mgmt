package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RateCalculatorsTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetCost() {
		
		//ALLOT_WATER 2 3:7
		//ADD_GUESTS 2
		//ADD_GUESTS 3
		//BILL
		
		Apartment apt=new Apartment(2,0.3,5);
		RateCalculators rateCalcs=new RateCalculators();
		RateSummary rateSummary= rateCalcs.getCost(apt);
		RateSummary expSummary = new RateSummary(2400.0,5215.0);
		assertAll("Ratesummary for all RateCalculators",
				() -> assertEquals(rateSummary.getCost(),expSummary.getCost(),1.0e-6),
				() -> assertEquals(rateSummary.getLitres(),expSummary.getLitres(),1.0e-6)
				);
	}

}
