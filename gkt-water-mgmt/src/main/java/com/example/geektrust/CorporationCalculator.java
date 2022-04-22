package com.example.geektrust;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class CorporationCalculator implements IRateCalculator {
	@NonNull
	ApartmentConfig aptConfig;
	@NonNull
	Apartment apt;
	@Getter private double corporationRate=1.5;

	public RateSummary getCost() {
		Double litres = apt.getResidents() * aptConfig.getPersonLitresMonth() * apt.getRatioCORPORATIONBOREWELL();
		Double cost = litres * corporationRate;
		return new RateSummary(litres, cost);
	}
}