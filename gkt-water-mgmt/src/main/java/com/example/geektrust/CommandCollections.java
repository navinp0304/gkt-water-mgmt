package com.example.geektrust;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

public class CommandCollections {
	@NotNull
	private final Map<String, BiFunction<Apartment, String, Apartment>> commandsLookup = new ConcurrentHashMap<>() {
		private static final long serialVersionUID = 1L;

		{

			put("ALLOT_WATER", (Apartment apt, String cmd) -> new AllotCommand().parseCommand(cmd));
			put("ADD_GUESTS", (Apartment apt, String cmd) -> new AddGuestsCommand().parseCommand(apt, cmd));
			put("BILL", (Apartment apt, String cmd) -> new PrintBillCommand().parseCommand(apt));

		}
	};

	public Apartment parseCommand(Apartment apt, @NotNull String fullCommand) {
		String[] command = fullCommand.split(" ");
		return commandsLookup.get(command[0]).apply(apt, fullCommand);
	}

}
