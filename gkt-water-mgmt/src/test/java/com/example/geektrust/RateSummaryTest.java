package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RateSummaryTest {

	@Test
	void testAdd() {
		RateSummary rate1 = new RateSummary(2.0, 3.0);
		RateSummary rate2 = new RateSummary(4.0, 6.0);
		rate1.add(rate2);
		assertAll("Rate addition test", 
				() -> assertEquals(rate1.getLitres(), 6.0, 1.0e-6),
				() -> assertEquals(rate1.getCost(), 9.0, 1.0e-6));
	}

	@Test
	void testGetLitres() {
		RateSummary rate = new RateSummary(2.0, 3.0);
		assertEquals(rate.getLitres(), 2.0, 1.0e-6);
	}

	@Test
	void testGetCost() {
		RateSummary rate = new RateSummary(2.0, 3.0);
		assertEquals(rate.getCost(), 3.0, 1.0e-6);
	}

	@Test
	void testRateSummary() {
		RateSummary rate = new RateSummary(2.0, 3.0);
		assertNotEquals(rate, null);
	}

}
