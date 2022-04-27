package com.example.geektrust;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public class RateSummary {
	@Getter
	private Double litres;
	@Getter
	private Double cost;
	
	RateSummary(Double litres,Double cost){
		this.litres=litres;
		this.cost=cost;
	}

	public void add(@NotNull RateSummary a) {
	 this.litres += a.getLitres();
	 this.cost += a.getCost();
	}
}
