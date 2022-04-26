package com.example.geektrust;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public class Apartment {
	private static final Map<Integer, Integer> residentLookup = Map.of(2, 3, 3, 5);

	private static final Integer PERSONLITRESPERDAY = 10;
	private static final Integer DAYSPERMONTH = 30;
	@Getter
	private static final Integer PERSONLITRESMONTH = PERSONLITRESPERDAY * DAYSPERMONTH;

	@Getter
	private Integer residents;

	@Getter
	private Double ratioCORPORATIONBOREWELL;

	@Getter @Setter
	private Integer guests;

	Apartment(Integer id, Double ratio, Integer guests) {
		residents = residentLookup.get(id);
		this.ratioCORPORATIONBOREWELL = ratio;
		this.guests = guests;
	}
	
	

}
