package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Apartment2BHK;
import main.ApartmentBase;

class Apartment2BHKTest {
	ApartmentBase apt2Bhk;

	@BeforeEach
	void setUp() {
		apt2Bhk = new Apartment2BHK(3, 3, "1:2");
	}

	@Test
	void testAllCommands() {
		ApartmentBase obj = apt2Bhk.clone();
		assertEquals(obj.getTotalLitres(), 900, 1e-4);
		assertEquals(obj.getCost(), 1200, 1e-4);
		obj.addPeople(10); // equivalent to add guests 10
		assertEquals(obj.getTotalLitres(), 3900, 1e-4);
		assertEquals(obj.getCost(), 12700, 1e-4);
		obj.addPeople(17); // equivalent to add guests 17
		assertEquals(obj.getTotalLitres(), 9000, 1e-4);
		assertEquals(obj.getCost(), 53500, 1e-4);
		assertEquals(obj.clone(),obj);
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
		assertEquals(apt2Bhk.getDefaultLitres(), 900, 1e-4);
	}

	@Test
	void testApartment2BHKDefaultCost() {
		assertEquals(apt2Bhk.getCost(), 1200, 1e-4);
	}

	@Test
	void testCloneIntegerDouble() {
		Apartment2BHK obj = (Apartment2BHK) apt2Bhk.clone();
		assertEquals(obj, apt2Bhk);

	}

	@Test
	void testApartment2BHKIntegerDouble() {
		Apartment2BHK obj = new Apartment2BHK(apt2Bhk.getDefaultPeople(), apt2Bhk.getDefaultPeople(),
				apt2Bhk.getRatio());
		assertEquals(obj, apt2Bhk);

		// obj = new Apartment2BHK(-1,0.25);
		// assertNull(obj,"Negative people should return null");

		try {
			obj = new Apartment2BHK(3, apt2Bhk.getDefaultPeople(), 1.25);
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "ratio not between [0,1]");
		}

		try {
			obj = new Apartment2BHK(3, apt2Bhk.getDefaultPeople(), "1:0");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "denominator is <= 0");
		}
	}

	@Test
	void testApartment2BHKIntegerString() {
		Apartment2BHK obj = new Apartment2BHK(apt2Bhk.getDefaultPeople(), apt2Bhk.getDefaultPeople(),
				apt2Bhk.getRatioStr());
		assertEquals(obj, apt2Bhk);
	}
}
