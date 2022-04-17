package com.example.geektrust;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class BorewellCalculator  {

	public static RateSummary getCost(Apartment apt) {
		Double litres = apt.getResidents() * ApartmentConfig.getPersonLitresMonth()
				* (1.0 - apt.getRatioCORPORATIONBOREWELL());
		Double cost = litres * ApartmentConfig.getAptConfig().getBorewellRate();
		return new RateSummary(litres, cost);
	}
}
