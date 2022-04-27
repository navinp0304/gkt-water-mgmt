package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ApartmentTest {

	@Test
	void testApartment() {
		Apartment apt = new Apartment(2, 0.5, 0);
	}

	@Test
	void testGetPERSONLITRESMONTH() {
		Apartment apt = new Apartment(3, 0.5, 0);
		assertEquals(apt.getPERSONLITRESMONTH(),300);
	}

	@Test
	void testGetResidents() {
		Apartment apt = new Apartment(3, 0.5, 0);
		assertEquals(apt.getResidents(),5);
	}

	@Test
	void testGetRatioCORPORATIONBOREWELL() {
		Apartment apt = new Apartment(3, 0.3, 0);
		assertEquals(apt.getRatioCORPORATIONBOREWELL(),0.3,1.0e-6);
	}

	@Test
	void testGetGuests() {
		Apartment apt = new Apartment(3, 0.3, 7);
		assertEquals(apt.getGuests(),7);
	}

	@Test
	void testSetGuests() {
		Apartment apt = new Apartment(3, 0.3, 7);
		apt.setGuests(10);
		assertEquals(apt.getGuests(),10);
	}

}
