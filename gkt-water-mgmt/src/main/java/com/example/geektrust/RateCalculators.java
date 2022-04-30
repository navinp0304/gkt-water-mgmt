package com.example.geektrust;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RateCalculators implements IRateCalculator {

	private @NotNull final List<IRateCalculator> allCalculators = List.of(new BorewellCalculator(),
			new CorporationCalculator(),new TankerCalculator());
	@Override
	public @NotNull Double[] getCost(Apartment apt) {
		Double[] total = {0.0, 0.0};
		for (IRateCalculator rateCalc : allCalculators) {
			Double[] tmp = rateCalc.getCost(apt);
			total[0] += tmp[0];
			total[1] += tmp[1];
		}
		return total;
	}
	
	

}
