package com.example.geektrust;

import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddGuestsCommand  {
	private static Apartment executeAddGuestsCommand(Apartment obj,int guests) {
		obj.addGuests(guests);
		return obj;
	}
	public static Apartment parseCommand(Apartment apt,String cmd) {
		Integer guests = Integer.valueOf(cmd);
		return executeAddGuestsCommand(apt,guests);
	}
}
