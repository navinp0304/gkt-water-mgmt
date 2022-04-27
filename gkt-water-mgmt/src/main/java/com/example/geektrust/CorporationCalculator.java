package com.example.geektrust;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor 
public class CorporationCalculator implements IRateCalculator {

	public @NotNull RateSummary getCost(@NotNull Apartment apt) {
		double litres = apt.getResidents() * apt.getPERSONLITRESMONTH() * apt.getRatioCORPORATIONBOREWELL();
		double CORPORATIONRATE = 1.0;
		Double cost = litres * CORPORATIONRATE;
		return new RateSummary(litres, cost);
	}
}