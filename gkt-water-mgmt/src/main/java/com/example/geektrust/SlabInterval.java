package com.example.geektrust;

public class SlabInterval {
	private final int start;
	private final int end;
	private final int rate;

	SlabInterval(int start, int end, int rate) {
		this.start = Math.max(start, 1);
		this.end = end;
		this.rate = rate;
	}

	public int getCost(int litres) {
		int newend = Math.min(litres, end);
		int totlit = Math.max(0, newend - start + 1);
		return totlit * rate;
	}
}