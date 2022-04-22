package com.example.geektrust;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class ApartmentConfig {
	private final Integer personLitresPerDay = 10;
	private final Integer daysPerMonth = 30;
	@Getter
	private final Integer personLitresMonth = personLitresPerDay * daysPerMonth;
	private Integer guests = 0;

	public Integer getAllGuestsLitersMonth() {
		return guests * personLitresMonth;
	}
}
