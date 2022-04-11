package com.example.geektrust;

import lombok.Data;

public @Data class RateSummary {
	private double litres;
	private double cost;
	RateSummary(double litres,double cost){
		this.litres=litres;
		this.cost=cost;
	}
}
