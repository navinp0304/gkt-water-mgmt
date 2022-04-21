package com.example.geektrust;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class BorewellCalculator implements IRateCalculator {
	@NonNull
	private ApartmentConfig aptConfig;
	@NonNull
	private Apartment apt;

	public RateSummary getCost() {
		Double litres = apt.getResidents() * aptConfig.getPersonLitresMonth()
				* (1.0 - apt.getRatioCORPORATIONBOREWELL());
		Double cost = litres * aptConfig.getBorewellRate();
		return new RateSummary(litres, cost);
	}

}
