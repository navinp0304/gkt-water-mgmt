package com.example.geektrust;

import lombok.Data;

@Data public class BorewellCalculator implements IRateCalculator {
	private BorewellCalculator() {}
	private static final double BOREWELL_RATE = 1.5;
	public  RateSummary getCost(Apartment apt) {
		return new RateSummary(BOREWELL_RATE,1);
	}
}
