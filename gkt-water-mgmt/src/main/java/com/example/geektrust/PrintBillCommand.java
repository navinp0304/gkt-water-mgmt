package com.example.geektrust;

public class PrintBillCommand implements ICommand {
	
	IRateCalculator rateCalcs;
	public PrintBillCommand() {
		rateCalcs=new RateCalculators();
	}
	
	public Apartment parseCommand(Apartment apt, String command) {
		RateSummary total = rateCalcs.getCost(apt);
		System.out.println(Math.round(total.getLitres()) + " " + Math.round(total.getCost()));
		return apt;
	}
}