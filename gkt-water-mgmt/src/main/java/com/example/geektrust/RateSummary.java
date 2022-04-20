package com.example.geektrust;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RateSummary {
	@NonNull
	@Getter private Double litres;
	@NonNull
	@Getter private Double cost;

	public RateSummary add(RateSummary a) {
		return new RateSummary(litres + a.getLitres(), cost + a.getCost());
	}
}
