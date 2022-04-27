package test.java.watermgmt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.watermgmt.Apartment3BHK;
import main.java.watermgmt.ApartmentBase;

class Apartment3BHKTest {
	ApartmentBase apt3Bhk;

	@BeforeEach
	void setUp() {
		apt3Bhk = new Apartment3BHK(5, 5, "2:3");
	}

	@Test
	void testAllCommands() {
		ApartmentBase obj = apt3Bhk.clone();
		assertEquals(obj.getTotalLitres(), 1500, 1e-4);
		assertEquals(obj.getCost(), 1950, 1e-4);
		obj.addPeople(10); // equivalent to add guests 10
		assertEquals(obj.getTotalLitres(), 4500, 1e-4);
		assertEquals(obj.getCost(), 13450, 1e-4);
		obj.addPeople(19); // equivalent to add guests 10
		assertEquals(obj.getTotalLitres(), 10200, 1e-4);
		assertEquals(obj.getCost(), 59050, 1e-4);
		
		assertNotEquals(obj.clone(4.0/5.0),obj);
		try {
			obj.clone(-1.0);
		} catch(IllegalArgumentException ex) {
			assertEquals(ex.getMessage(),"ratio < 0");
		}
		
		try {
			obj.clone(1.5);
		} catch(IllegalArgumentException ex) {
			assertEquals(ex.getMessage(),"ratio > 1");
		}
	}


	@Test
	void testGetDefaultLitres() {
		assertEquals(apt3Bhk.getDefaultLitres(), 1500, 1e-4);
	}

	@Test
	void testApartment3BHKDefaultCost() {
		assertEquals(apt3Bhk.getCost(), 1950, 1e-4);
	}

	@Test
	void testCloneIntegerDouble() {
		Apartment3BHK obj = null;
		obj = (Apartment3BHK) apt3Bhk.clone();
		assertEquals(obj, apt3Bhk);

	}

	@Test
	void testApartment3BHKIntegerDouble() {
		Apartment3BHK obj = new Apartment3BHK(apt3Bhk.getDefaultPeople(), apt3Bhk.getDefaultPeople(),
				apt3Bhk.getRatio());
		assertEquals(obj, apt3Bhk);

		// obj = new Apartment2BHK(-1,0.25);
		// assertNull(obj,"Negative people should return null");

		try {
			obj = new Apartment3BHK(5, apt3Bhk.getDefaultPeople(), 1.25);
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "ratio not between [0,1]");
		}

		try {
			obj = new Apartment3BHK(5, apt3Bhk.getDefaultPeople(), "1:0");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "denominator is <= 0");
		}
	}

	@Test
	void testApartment3BHKIntegerString() {
		Apartment3BHK obj = new Apartment3BHK(apt3Bhk.getDefaultPeople(), apt3Bhk.getDefaultPeople(),
				apt3Bhk.getRatioStr());
		assertEquals(obj, apt3Bhk);
	}
}
