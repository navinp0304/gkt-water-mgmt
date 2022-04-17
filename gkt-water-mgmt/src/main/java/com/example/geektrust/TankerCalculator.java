package com.example.geektrust;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class TankerCalculator {
		private static final List<SlabInterval> slabList = 
			List.of(new SlabInterval(1,500,2),	  
					new SlabInterval(501,1500,3),					
					new SlabInterval(1501,3000,5),
					new SlabInterval(3001,Integer.MAX_VALUE,8)
					);

	public static RateSummary getCost(Apartment apt) {

		Double totcost = 0.0;
		Integer slablitres=apt.getGuests()*ApartmentConfig.getPersonLitresMonth();
		for(SlabInterval s: slabList ) {
			totcost = totcost + s.getCost(slablitres);
		}
		return new RateSummary(slablitres*1.0,totcost);
	}
}
