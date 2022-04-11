package com.example.geektrust;

public class PrintBillCommand {
	private PrintBillCommand() {}
	public static void executePrintBillCommand(Apartment apt) {
		int totlitres = ApartmentCalculator.getTotalLitres(apt);
		int totcost = ApartmentCalculator.getTotalCost(apt);
		System.out.println(totlitres+" "+totcost);
	}
}