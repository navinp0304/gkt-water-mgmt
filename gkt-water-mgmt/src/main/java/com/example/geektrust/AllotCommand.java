package com.example.geektrust;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AllotCommand  {
	private static Apartment createApartment(int type, double ratio) {
		return new Apartment(type, ApartmentConfig.getResidentsLookup(type), ratio);
	}

	private static Double parseRatio(String s) {
		String[] tokens = s.split(":");
		Integer num = Integer.valueOf(tokens[0]);
		Integer den = Integer.valueOf(tokens[1]);
		return num * 1.0 / (num+den);
	}

	public  static Apartment parseCommand(Apartment apt,String cmd) {
		String[] tokens = cmd.split(" ");
		Integer type = Integer.valueOf(tokens[1]);
		String ratioStr = tokens[2];
		Double ratio = parseRatio(ratioStr);
		return createApartment(type, ratio);
	}

}
