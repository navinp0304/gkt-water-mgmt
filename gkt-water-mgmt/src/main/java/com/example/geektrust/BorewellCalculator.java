package com.example.geektrust;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class BorewellCalculator implements IRateCalculator {

	@NonNull
	private Apartment apt;
	@Getter
	private double borewellRate = 1.5;

	public RateSummary getCost() {
		Double litres = apt.getResidents() * apt.getPersonLitresMonth() * (1.0 - apt.getRatioCORPORATIONBOREWELL());
		Double cost = litres * borewellRate;
		return new RateSummary(litres, cost);
	}

}
