package com.example.geektrust;

import java.util.Map;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public class Apartment {

	@NotNull
	private final Integer PERSONLITRESPERDAY = 10;

	@NotNull
	private final Integer DAYSPERMONTH = 30;

	@Getter @NotNull
	private final Integer PERSONLITRESMONTH = PERSONLITRESPERDAY * DAYSPERMONTH;

	@Getter
	private final Integer residents;

	@Getter
	private final Double ratioCORPORATIONBOREWELL;

	@Getter 
	private Integer guests;

	Apartment(Integer id, Double ratio, Integer guests) {
		Map<Integer, Integer> residentLookup = Map.of(2, 3, 3, 5);
		residents = residentLookup.get(id);
		this.ratioCORPORATIONBOREWELL = ratio;
		this.guests = guests;
	}

	Apartment addGuests(String fullCmd){
		
		String[] tokens = fullCmd.split(" ");
		int newGuests = Integer.parseInt(tokens[1]);	
		this.guests += newGuests;
		return this;
	}
	
	

}
