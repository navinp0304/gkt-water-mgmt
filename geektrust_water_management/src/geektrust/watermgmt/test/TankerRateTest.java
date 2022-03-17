package geektrust.watermgmt.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import geektrust.watermgmt.src.Apartment2BHK;
import geektrust.watermgmt.src.Apartment3BHK;
import geektrust.watermgmt.src.ApartmentBase;
import geektrust.watermgmt.src.TankerRate;

class TankerRateTest {
	TankerRate trate;
	ApartmentBase apt2Bhk, apt3Bhk;

	@BeforeEach
	void setup() {
		trate = new TankerRate();
		apt2Bhk = new Apartment2BHK(3, 3, "1:2");
		apt3Bhk = new Apartment3BHK(5, 5, "2:3");
		apt3Bhk.addPeople(10);
	}

	/*
	 * new SlabInterval(0.0, 500.0, 2.0), new SlabInterval(501.0, 1500.0, 3.0), new
	 * SlabInterval(1501.0, 3000.0, 5.0), new SlabInterval(3001.0, Double.MAX_VALUE,
	 * 8.0)
	 */
	@Test
	void testGetRate() {
		try {
			trate.getRate(-2.0);
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "litres < 0");
		}

		assertEquals(trate.getRate(250.0), 500.0);
		assertEquals(trate.getRate(1000.0), 2500.0);
		assertEquals(trate.getRate(2500.0), 9000.0);
		assertEquals(trate.getRate(3500.0), 15500.0);
	}

	@Test
	void testGetLitres() {
		try {
			trate.getLitres(null);
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "aptObj argument is null");
		}
		assertEquals(trate.getLitres(apt2Bhk), 0);
		assertEquals(trate.getLitres(apt3Bhk), 3000);
	}

}
