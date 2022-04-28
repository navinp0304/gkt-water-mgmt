package com.example.geektrust;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.function.BiFunction;

public class CommandCollections {
	@NotNull
	private final Map<String, BiFunction<Apartment, String, Apartment>> commandsLookup = Map.of(
				"ALLOT_WATER", (Apartment apt, String cmd) -> new AllotCommand().parseCommand(cmd),
				"ADD_GUESTS", Apartment::addGuests,
				"BILL",	(Apartment apt, String cmd) -> new PrintBillCommand().parseCommand(apt)
			);


	public Apartment parseCommand(Apartment apt, @NotNull String fullCommand) {
		String[] command = fullCommand.split(" ");
		return commandsLookup.get(command[0]).apply(apt, fullCommand);
	}

}
