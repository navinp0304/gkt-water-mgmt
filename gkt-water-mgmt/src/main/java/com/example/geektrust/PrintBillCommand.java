package com.example.geektrust;

import java.util.List;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class PrintBillCommand {
	@NonNull
	Apartment apt;
	@NonNull
	ApartmentConfig aptconfig;
	@NonNull
	List<IRateCalculator> costCalcs;

	public void parseCommand() {

		RateSummary tot=new RateSummary(0.0,0.0);
		for(IRateCalculator obj: costCalcs) {
			tot=tot.add(obj.getCost());
		}

		System.out.println(tot.getLitres() + " " + tot.getCost());
		return;
	}
}