package com.example.geektrust;

import java.util.List;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class PrintBillCommand implements ICommand {
	@NonNull
	Apartment apt;
	@NonNull
	String cmd;
	@NonNull
	List<IRateCalculator> costCalcs;

	public Apartment parseCommand() {

		RateSummary tot = new RateSummary(0.0, 0.0);
		for (IRateCalculator obj : costCalcs) {
			tot = tot.add(obj.getCost());
		}

		System.out.println(tot.getLitres() + " " + tot.getCost());
		return apt;
	}
}