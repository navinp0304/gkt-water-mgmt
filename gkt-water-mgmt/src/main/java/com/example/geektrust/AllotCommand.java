package com.example.geektrust;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class AllotCommand  {
	private  Apartment createApartment(int type, double ratio) {
		ApartmentConfig aptConfig=new ApartmentConfig();
		return new Apartment(type, aptConfig.getResidentsLookup(type), ratio);
	}

	private  Double parseRatio(String s) {
		String[] tokens = s.split(":");
		Integer num = Integer.valueOf(tokens[0]);
		Integer den = Integer.valueOf(tokens[1]);
		return num * 1.0 / (num+den);
	}

	public   Apartment parseCommand(Apartment apt,String cmd) {
		String[] tokens = cmd.split(" ");
		Integer type = Integer.valueOf(tokens[1]);
		String ratioStr = tokens[2];
		Double ratio = parseRatio(ratioStr);
		return createApartment(type, ratio);
	}

}
