package com.example.geektrust;

import org.jetbrains.annotations.NotNull;

public class AddGuestsCommand {

	public @NotNull Apartment parseCommand(@NotNull Apartment apt, @NotNull String command) {
		String[] tokens = command.split(" ");
		Integer guests = Integer.valueOf(tokens[1]);
		Integer totalguests = apt.getGuests() + guests;
		apt.setGuests(totalguests);
		return apt;
		
	}
}
