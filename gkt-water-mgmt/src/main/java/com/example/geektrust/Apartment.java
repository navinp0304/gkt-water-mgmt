package com.example.geektrust;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public @Data class Apartment {
	@NonNull
	private Integer id;
	@NonNull
	private Integer residents;
	@NonNull
	private Double ratioCORPORATIONBOREWELL;

	private int guests = 0;

	public void addGuests(int guests) {
		this.setGuests(this.getGuests() + guests);
	}
}
