package com.example.geektrust;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BorewellCalculator implements IRateCalculator {

	private final double BOREWELLRATE = 1.5;

	public RateSummary getCost(Apartment apt) {
		Double litres = apt.getResidents() * apt.getPERSONLITRESMONTH() * (1.0 - apt.getRatioCORPORATIONBOREWELL());
		litres = (double) Math.round(litres);
		Double cost = (double) (litres * BOREWELLRATE);
		return new RateSummary(litres, cost);
	}

}
