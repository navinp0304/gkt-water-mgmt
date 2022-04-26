package com.example.geektrust;

import java.util.Map;
import java.util.function.BiFunction;

public class CommandCollections implements ICommand {
	private final Map<String, BiFunction<Apartment, String, Apartment>> commandsLookup = Map.of(
				"ALLOT_WATER", (Apartment apt, String cmd) -> new AllotCommand().parseCommand(apt, cmd), 
				"ADD_GUESTS", (Apartment apt, String cmd) -> new AddGuestsCommand().parseCommand(apt, cmd), 
				"BILL",	(Apartment apt, String cmd) -> new PrintBillCommand().parseCommand(apt, cmd)
			);

	@Override
	public Apartment parseCommand(Apartment apt, String fullCommand) {
		String[] command = fullCommand.split(" ");
		return commandsLookup.get(command[0]).apply(apt, fullCommand);
	}

}
