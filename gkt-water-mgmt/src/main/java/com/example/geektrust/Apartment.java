package com.example.geektrust;

import java.util.Map;

import lombok.Getter;

public class Apartment {
	private final Map<Integer, Integer> residentLookup = Map.of(2, 3, 3, 5);

	@Getter
	private Integer id;

	@Getter
	private Integer residents;

	@Getter
	private Double ratioCORPORATIONBOREWELL;

	@Getter
	private Integer guests;

	Apartment(Integer id, Double ratio, Integer guests) {
		this.id = id;
		residents = residentLookup.get(id);
		this.ratioCORPORATIONBOREWELL = ratio;
		this.guests = guests;
	}

}
