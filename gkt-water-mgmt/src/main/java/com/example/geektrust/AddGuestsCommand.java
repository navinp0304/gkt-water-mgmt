package com.example.geektrust;

import lombok.RequiredArgsConstructor;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Data
public class AddGuestsCommand implements ICommand {
	@NonNull
	Apartment apt;
	@NonNull
	String cmd;

	public Apartment parseCommand() {
		Integer guests = Integer.valueOf(cmd);
		apt.addGuests(guests);
		return apt;
	}
}
