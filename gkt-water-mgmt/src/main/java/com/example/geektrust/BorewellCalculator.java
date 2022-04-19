package com.example.geektrust;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Data
public class BorewellCalculator implements IRateCalculator {
	@NonNull
	ApartmentConfig aptConfig;
	@NonNull
	Apartment apt;


	public RateSummary getCost() {
		Double litres = apt.getResidents() * aptConfig.getPersonLitresMonth()
				* (1.0 - apt.getRatioCORPORATIONBOREWELL());
		Double cost = litres * aptConfig.getBorewellRate();
		return new RateSummary(litres, cost);
	}
}
