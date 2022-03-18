package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Apartment2BHK;
import main.Apartment3BHK;
import main.ApartmentBase;
import main.CorporationRate;

class CorporationRateTest {
	CorporationRate obj;
	ApartmentBase apt2BHK, apt3BHK;

	@BeforeEach
	void setup() {
		obj = new CorporationRate();
		apt2BHK = new Apartment2BHK(3, 3, "1:2");
		apt3BHK = new Apartment3BHK(5, 5, "2:3");
	}

	@Test
	void testGetRate() {
		assertEquals(obj.getRate(0.0), 0, 1e-4);
		assertEquals(obj.getRate(1.0), 1, 1e-4);
		assertEquals(obj.getRate(10.0), 10, 1e-4);
	}

	@Test
	void testGetLitres() {
		assertEquals(obj.getLitres(apt2BHK), 300, 1e-4);
		assertEquals(obj.getLitres(apt3BHK), 600, 1e-4);
		try {
			obj.getLitres(null);
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "null argument");
		}
	}

}
