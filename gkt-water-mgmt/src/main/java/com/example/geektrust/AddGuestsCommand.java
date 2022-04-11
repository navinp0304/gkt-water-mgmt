package com.example.geektrust;

public class AddGuestsCommand {
	private AddGuestsCommand() {}
	public static Apartment executeAddGuestsCommand(Apartment obj,int guests) {
		obj.addGuests(guests);
		return obj;
	}
}
