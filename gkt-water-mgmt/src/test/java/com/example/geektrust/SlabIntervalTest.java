package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SlabIntervalTest {

	@Test
	void testSlabInterval() {
		SlabInterval slabInterval = new SlabInterval(0,5,10);
		assertNotEquals(slabInterval, null);

	}

	@Test
	void testGetCost() {
		SlabInterval slabInterval = new SlabInterval(0,10,10);
		assertEquals(slabInterval.getCost(10),100.0,1.0e-6);
		
	}

}
