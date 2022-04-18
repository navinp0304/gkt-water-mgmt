package com.example.geektrust;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public @Data class RateSummary {
	@NonNull
	private Double litres;
	@NonNull
	private Double cost;
	public RateSummary add(RateSummary a,RateSummary b) {
		return new RateSummary(a.getLitres()+b.getLitres(),a.getCost()+b.getCost());
	}
}
