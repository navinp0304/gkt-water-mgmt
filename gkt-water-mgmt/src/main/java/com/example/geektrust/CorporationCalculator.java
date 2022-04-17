package com.example.geektrust;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CorporationCalculator  {

	public static RateSummary getCost(Apartment apt) {
		Double litres = apt.getResidents() * ApartmentConfig.getPersonLitresMonth() * apt.getRatioCORPORATIONBOREWELL();
		Double cost = litres * ApartmentConfig.getAptConfig().getCorporationRate();
		return new RateSummary(litres, cost);
	}
}
