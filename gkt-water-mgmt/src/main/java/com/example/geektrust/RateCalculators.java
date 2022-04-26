package com.example.geektrust;

import java.util.List;

public class RateCalculators implements IRateCalculator {
	private static final List<IRateCalculator> allCalculators = List.of(new BorewellCalculator(), 
			new CorporationCalculator(),new TankerCalculator());
	@Override
	public RateSummary getCost(Apartment apt) {
		RateSummary total = new RateSummary(0.0, 0.0);
		for (IRateCalculator rateCalc : allCalculators) {
			total.add(rateCalc.getCost(apt));
		}
		return total;
	}
	
	

}
