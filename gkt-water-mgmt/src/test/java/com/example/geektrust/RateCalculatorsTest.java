package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RateCalculatorsTest {

	@Test
	void testGetCost() {
		
		//ALLOT_WATER 2 3:7
		//ADD_GUESTS 2
		//ADD_GUESTS 3
		//BILL
		
		//Apartment apt=new Apartment(2,0.3,5);
		Apartment apt=new AllotCommand().parseCommand("ALLOT_WATER 2 3:7");
		apt = new AddGuestsCommand().parseCommand(apt,"ADD_GUESTS 5");

		RateCalculators rateCalcs=new RateCalculators();
		Double[] rateSummary= rateCalcs.getCost(apt);
		Double[] expSummary = {2400.0,5215.0};
		assertAll("Ratesummary for all RateCalculators",
				() -> assertEquals(rateSummary[0],expSummary[0],1.0e-6),
				() -> assertEquals(rateSummary[1],expSummary[1],1.0e-6)
				);
	}

}
