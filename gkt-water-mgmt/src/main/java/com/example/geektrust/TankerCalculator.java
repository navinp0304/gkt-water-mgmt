package com.example.geektrust;

import java.util.List;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class TankerCalculator implements IRateCalculator {
	private final List<SlabInterval> slabList = List.of(new SlabInterval(0, 500, 2), new SlabInterval(501, 1500, 3),
			new SlabInterval(1501, 3000, 5), new SlabInterval(3001, Integer.MAX_VALUE, 8));

	@NonNull
	private Apartment apt;

	public RateSummary getCost() {

		Double totcost = 0.0;
		Integer slablitres = apt.getGuests() * apt.getPersonLitresMonth();
		for (SlabInterval s : slabList) {
			totcost = totcost + s.getCost(slablitres);
		}
		return new RateSummary(slablitres * 1.0, totcost);
	}
}
