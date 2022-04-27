package com.example.geektrust;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RateCalculators implements IRateCalculator {

	private @NotNull final List<IRateCalculator> allCalculators = List.of(new BorewellCalculator(),
			new CorporationCalculator(),new TankerCalculator());
	@Override
	public @NotNull RateSummary getCost(Apartment apt) {
		RateSummary total = new RateSummary(0.0, 0.0);
		for (IRateCalculator rateCalc : allCalculators) {
			total.add(rateCalc.getCost(apt));
		}
		return total;
	}
	
	

}
