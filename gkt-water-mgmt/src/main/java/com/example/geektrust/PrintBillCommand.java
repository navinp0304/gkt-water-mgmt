package com.example.geektrust;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PrintBillCommand {

	public static Apartment parseCommand(Apartment apt,String s) {
		int totlitres = 0;
		int totcost = 0;
		System.out.println(totlitres+" "+totcost);
		return apt;
	}
}