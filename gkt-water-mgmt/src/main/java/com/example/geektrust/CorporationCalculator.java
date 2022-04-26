package com.example.geektrust;

import lombok.NoArgsConstructor;

@NoArgsConstructor 
public class CorporationCalculator implements IRateCalculator {

	private static final double CORPORATIONRATE = 1.0;

	public RateSummary getCost(Apartment apt) {
		Double litres = apt.getResidents() * Apartment.getPERSONLITRESMONTH() * apt.getRatioCORPORATIONBOREWELL();
		Double cost = litres * CORPORATIONRATE;
		return new RateSummary(litres, cost);
	}
}