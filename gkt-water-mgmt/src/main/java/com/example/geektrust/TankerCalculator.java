package com.example.geektrust;

import java.util.List;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TankerCalculator implements IRateCalculator {
	private static final List<SlabInterval> slabList = List.of(new SlabInterval(0, 500, 2), new SlabInterval(501, 1500, 3),
			new SlabInterval(1501, 3000, 5), new SlabInterval(3001, Integer.MAX_VALUE, 8));



	public RateSummary getCost(Apartment apt) {

		Double totcost = 0.0;
		Integer slablitres = apt.getGuests() * Apartment.getPERSONLITRESMONTH();
		for (SlabInterval s : slabList) {
			totcost = totcost + s.getCost(slablitres);
		}
		return new RateSummary(slablitres * 1.0, totcost);
	}
}
