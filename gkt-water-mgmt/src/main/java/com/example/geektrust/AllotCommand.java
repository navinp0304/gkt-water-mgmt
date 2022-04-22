package com.example.geektrust;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class AllotCommand implements ICommand {
	@NonNull
	Apartment apt;
	@NonNull
	String cmd;

	private Apartment createApartment(int type, double ratio) {
		return new Apartment(type, ratio, 0);
	}

	private Double parseRatio(String s) {
		String[] tokens = s.split(":");
		Integer num = Integer.valueOf(tokens[0]);
		Integer den = Integer.valueOf(tokens[1]);
		return num * 1.0 / (num + den);
	}

	public Apartment parseCommand() {
		String[] tokens = cmd.split(" ");
		Integer type = Integer.valueOf(tokens[1]);
		String ratioStr = tokens[2];
		Double ratio = parseRatio(ratioStr);
		return createApartment(type, ratio);
	}

}
