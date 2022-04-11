package com.example.geektrust;

import lombok.Data;
public @Data class SlabInterval {
	private int start;
	private int end;
	private int rate;
	SlabInterval(int start,int end,int rate){
		this.start=Math.max(start, 1);
		this.end=end;
		this.rate=rate;
	}
	
	public long getCost(long litres) {
		long newend   = Math.min(litres, end) ;
		long totlit   = Math.max(0,newend-start+1);
		return totlit*rate;
	}
}