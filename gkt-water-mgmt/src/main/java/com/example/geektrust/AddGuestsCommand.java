package com.example.geektrust;

import lombok.RequiredArgsConstructor;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class AddGuestsCommand implements ICommand {
	@NonNull
	@Getter Apartment apt;
	@NonNull
	@Getter String cmd;

	public Apartment parseCommand() {
		Integer guests = Integer.valueOf(cmd);
		Integer totalguests = apt.getGuests() + guests;
		return new Apartment(apt.getId(),apt.getRatioCORPORATIONBOREWELL(),totalguests);
	}
}
