package com.example.geektrust;

import java.util.List;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
public class TankerCalculator implements IRateCalculator {
	private @NotNull final List<SlabInterval> slabList = List.of(new SlabInterval(0, 500, 2), new SlabInterval(501, 1500, 3),
			new SlabInterval(1501, 3000, 5), new SlabInterval(3001, Integer.MAX_VALUE, 8));



	public @NotNull Double[] getCost(@NotNull Apartment apt) {

		double totcost = 0.0;
		int slablitres = apt.getGuests() * apt.getPERSONLITRESMONTH();
		for (SlabInterval s : slabList) {
			totcost = totcost + s.getCost(slablitres);
		}
		return new Double[]{slablitres * 1.0, totcost};
	}
}
