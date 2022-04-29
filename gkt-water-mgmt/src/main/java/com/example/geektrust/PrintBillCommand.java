package com.example.geektrust;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

import org.jetbrains.annotations.NotNull;

public class PrintBillCommand {
	Logger logger;
	final @NotNull IRateCalculator rateCalcs;

	public PrintBillCommand() {
		rateCalcs = new RateCalculators();
	}

	public Apartment parseCommand(Apartment apt) {

		Double[] total = rateCalcs.getCost(apt);

		//logger.info( Math.round(total.getLitres()) + " " + Math.round(total.getCost()));
		System.out.println(Math.round(total[0]) + " " +		 Math.round(total[1]));
		return apt;
	}
}