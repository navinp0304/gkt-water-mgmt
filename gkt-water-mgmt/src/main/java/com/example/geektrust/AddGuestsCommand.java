package com.example.geektrust;

public class AddGuestsCommand implements ICommand {

	public Apartment parseCommand(Apartment apt,String command) {
		String[] tokens = command.split(" ");
		Integer guests = Integer.valueOf(tokens[1]);
		Integer totalguests = apt.getGuests() + guests;
		apt.setGuests(totalguests);
		return apt;
		
	}
}
