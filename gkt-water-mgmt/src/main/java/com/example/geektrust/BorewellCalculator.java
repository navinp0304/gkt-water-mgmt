package com.example.geektrust;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BorewellCalculator implements IRateCalculator {

	private static final double BOREWELLRATE = 1.5;

	public RateSummary getCost(Apartment apt) {
		Double litres = apt.getResidents() * Apartment.getPERSONLITRESMONTH() * (1.0 - apt.getRatioCORPORATIONBOREWELL());
		Double cost = litres * BOREWELLRATE;
		return new RateSummary(litres, cost);
	}

}
