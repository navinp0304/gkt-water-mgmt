package com.example.geektrust;

import lombok.NoArgsConstructor;

@NoArgsConstructor 
public class CorporationCalculator implements IRateCalculator {

	private final double CORPORATIONRATE = 1.0;

	public RateSummary getCost(Apartment apt) {
		Double litres = apt.getResidents() * apt.getPERSONLITRESMONTH() * apt.getRatioCORPORATIONBOREWELL();
		Double cost = litres * CORPORATIONRATE;
		return new RateSummary(litres, cost);
	}
}