package com.example.geektrust;


import org.jetbrains.annotations.NotNull;

public class AllotCommand {


	private @NotNull Apartment createApartment(int type, double ratio) {
		return new Apartment(type, ratio, 0);
	}

	private @NotNull Double parseRatio(@NotNull String s) {
		String[] tokens = s.split(":");
		int num = Integer.parseInt(tokens[0]);
		int den = Integer.parseInt(tokens[1]);
		return num * 1.0 / (num + den);
	}

	public @NotNull Apartment parseCommand(@NotNull String command) {
		String[] tokens = command.split(" ");
		int type = Integer.parseInt(tokens[1]);
		String ratioStr = tokens[2];
		Double ratio = parseRatio(ratioStr);
		return createApartment(type, ratio);
	}

}
