package com.example.geektrust;

import org.jetbrains.annotations.NotNull;

public class PrintBillCommand {
	final @NotNull IRateCalculator rateCalcs;

	public PrintBillCommand() {
		rateCalcs = new RateCalculators();
	}

	public Apartment parseCommand(Apartment apt) {

		Double[] total = rateCalcs.getCost(apt);

		WaterMgmtLogger logger = new WaterMgmtLogger();
		logger.writeFirstLine(Math.round(total[0]) + " " + Math.round(total[1]));

		// System.out.println(Math.round(total[0]) + " " + Math.round(total[1]));
		return apt;
	}
}