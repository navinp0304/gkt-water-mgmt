package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.Apartment2BHK;
import main.java.Apartment3BHK;
import main.java.ApartmentBase;
import main.java.BorewellRate;

class BorewellRateTest {
	BorewellRate obj;
	ApartmentBase apt2BHK, apt3BHK;

	@BeforeEach
	void setup() {
		obj = new BorewellRate();
		apt2BHK = new Apartment2BHK(3, 3, "1:2");
		apt3BHK = new Apartment3BHK(5, 5, "2:3");
	}

	@Test
	void testGetRate() {
		assertEquals(obj.getRate(0.0), 0, 1e-4);
		assertEquals(obj.getRate(1.0), 1.5, 1e-4);
		assertEquals(obj.getRate(10.0), 15, 1e-4);
	}

	@Test
	void testGetLitres() {
		assertEquals(obj.getLitres(apt2BHK), 600, 1e-4);
		assertEquals(obj.getLitres(apt3BHK), 900, 1e-4);
		try {
			obj.getLitres(null);
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "null argument");
		}
	}

}
