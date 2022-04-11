package com.example.geektrust;

import java.util.List;

import lombok.Data;

public @Data class TankerCalculator {
	private static final List<SlabInterval> slabList = 
			List.of(new SlabInterval(1,500,2),	  
					new SlabInterval(501,1500,3),					
					new SlabInterval(1501,3000,5),
					new SlabInterval(3001,Integer.MAX_VALUE,8)
					);
	public RateSummary getCost(Apartment apt) {
		int tot = 0;
		int litres=0;
		for(SlabInterval o: slabList ) {
			tot += o.getCost(litres);
		}
		return new RateSummary(tot,tot);
	}
}
