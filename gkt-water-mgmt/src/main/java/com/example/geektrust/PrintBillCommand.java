package com.example.geektrust;

import org.jetbrains.annotations.NotNull;

public class PrintBillCommand {
	
	final @NotNull IRateCalculator rateCalcs;
	public PrintBillCommand() {
		rateCalcs=new RateCalculators();
	}
	
	public Apartment parseCommand(Apartment apt) {
		RateSummary total = rateCalcs.getCost(apt);
		System.out.println(Math.round(total.getLitres()) + " " + Math.round(total.getCost()));
		return apt;
	}
}