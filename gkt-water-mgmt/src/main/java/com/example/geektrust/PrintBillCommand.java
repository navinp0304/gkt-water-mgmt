package com.example.geektrust;

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

	public void parseCommand() {

		CorporationCalculator corpCalc = new CorporationCalculator(aptconfig, apt);
		BorewellCalculator boreCalc = new BorewellCalculator(aptconfig, apt);
		TankerCalculator tankerCalc = new TankerCalculator(aptconfig, apt);

		RateSummary rateCorp = corpCalc.getCost();
		RateSummary rateBore = boreCalc.getCost();
		RateSummary rateTanker = tankerCalc.getCost();

		int totlitres = rateCorp.getLitres() + rateBore.getLitres() + rateTanker.getLitres();
		int totcost = rateCorp.getCost() + rateBore.getCost() + rateTanker.getCost();
		System.out.println(totlitres + " " + totcost);
		return;
	}
}