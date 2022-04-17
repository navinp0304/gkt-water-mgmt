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
}
