package com.example.geektrust;

import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class AddGuestsCommand  {
	private  Apartment executeAddGuestsCommand(Apartment obj,int guests) {
		obj.addGuests(guests);
		return obj;
	}
	public Apartment parseCommand(Apartment apt,String cmd) {
		Integer guests = Integer.valueOf(cmd);
		return executeAddGuestsCommand(apt,guests);
	}
}
