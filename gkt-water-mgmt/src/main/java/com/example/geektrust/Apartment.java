package com.example.geektrust;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public class Apartment {
	private final Map<Integer, Integer> residentLookup = Map.of(2, 3, 3, 5);

	private final Integer PERSONLITRESPERDAY = 10;
	private final Integer DAYSPERMONTH = 30;
	@Getter
	private final Integer PERSONLITRESMONTH = PERSONLITRESPERDAY * DAYSPERMONTH;

	
	private Integer id;

	@Getter
	private Integer residents;

	@Getter
	private Double ratioCORPORATIONBOREWELL;

	@Getter @Setter
	private Integer guests;

	Apartment(Integer id, Double ratio, Integer guests) {
		this.id = id;
		residents = residentLookup.get(id);
		this.ratioCORPORATIONBOREWELL = ratio;
		this.guests = guests;
	}
	
	

}
