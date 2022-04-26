package com.example.geektrust;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class RateSummary {
	@NonNull
	@Getter
	private Double litres;
	@NonNull
	@Getter
	private Double cost;

	public RateSummary add(RateSummary a) {
	 this.litres += a.getLitres();
	 this.cost += a.getCost();
	 return this;
	}
}
