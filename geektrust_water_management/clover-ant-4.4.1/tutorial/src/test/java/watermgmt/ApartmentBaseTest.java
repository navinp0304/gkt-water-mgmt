package test.java.watermgmt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.watermgmt.Apartment2BHK;
import main.java.watermgmt.Apartment3BHK;
import main.java.watermgmt.ApartmentBase;

class ApartmentBaseTest {
	ApartmentBase apt2bhk, apt3bhk;

	@BeforeEach
	void setup() {
		apt2bhk = new Apartment2BHK(3, 3, "1:2");
		apt3bhk = new Apartment3BHK(5, 5, "2:3");
	}

	@Test
	void testHashCode() {
		assertEquals(apt2bhk.hashCode(), 13636);
		apt2bhk.addPeople(7);
		assertEquals(apt2bhk.hashCode(), 14336);

		assertEquals(apt3bhk.hashCode(), 14505);
		apt3bhk.addPeople(15);
		assertEquals(apt3bhk.hashCode(), 16005);
	}


	@Test
	void testApartmentBaseIntegerInteger() {
		
		try {
			new Apartment2BHK(-1,-3,"1:2");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(),"nPeople < 0");
		}
		
		try {
			new Apartment2BHK(-1,-3,"1:2");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(),"nPeople < 0");
		}
		
		try {
			new Apartment2BHK(1,-3,"1:2");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(),"dPeople <= 0");
		}
		
		try {
			new Apartment2BHK(1,3,"1:2");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(),"nPeople < dPeople");
		}
		
		try {
			new Apartment2BHK(1,3,1.2);
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(),"nPeople < dPeople");
		}
		
		try {
			new Apartment2BHK(3,3,-1.2);
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(),"ratio not between [0,1]");
		}

	}

	@Test
	void testApartmentBaseIntegerIntegerString() {

	}

	@Test
	void testApartmentBaseIntegerIntegerDouble() {

	}

	@Test
	void testGetDefaultLitres() {
		assertEquals(apt2bhk.getDefaultLitres(), 900.0, 1e-4);
		assertEquals(apt3bhk.getDefaultLitres(), 1500.0, 1e-4);

		apt2bhk.addPeople(10);
		assertEquals(apt2bhk.getDefaultLitres(), 900.0, 1e-4);

		apt3bhk.addPeople(11);
		assertEquals(apt3bhk.getDefaultLitres(), 1500.0, 1e-4);
	}

	@Test
	void testClone() {
		ApartmentBase apt2bhkclone = apt2bhk.clone();
		ApartmentBase apt3bhkclone = apt3bhk.clone();

		assertEquals(apt2bhk, apt2bhkclone);
		assertEquals(apt3bhk, apt3bhkclone);

		apt2bhk.addPeople(13);
		assertEquals(apt2bhk.getTotalLitres(), 4800);
		assertEquals(apt2bhk.getCost(), 19900.0, 1e-4);

		apt3bhk.addPeople(15);
		assertEquals(apt3bhk.getTotalLitres(), 6000);
		assertEquals(apt3bhk.getCost(), 25450.0, 1e-4);

		assertNotEquals(apt2bhk, apt2bhkclone);
		assertNotEquals(apt3bhk, apt3bhkclone);

		apt2bhkclone = apt2bhk.clone();
		apt3bhkclone = apt3bhk.clone();

		assertEquals(apt2bhk, apt2bhkclone);
		assertEquals(apt3bhk, apt3bhkclone);
	}

	@Test
	void testGetCost() {
		assertEquals(apt2bhk.getCost(), 1200.0, 1e-4);
		assertEquals(apt3bhk.getCost(), 1950.0, 1e-4);
		apt2bhk.addPeople(13);
		assertEquals(apt2bhk.getTotalLitres(), 4800);
		assertEquals(apt2bhk.getCost(), 19900.0, 1e-4);

		apt3bhk.addPeople(15);
		assertEquals(apt3bhk.getTotalLitres(), 6000);
		assertEquals(apt3bhk.getCost(), 25450.0, 1e-4);

		apt2bhk.addPeople(17);
		assertEquals(apt2bhk.getTotalLitres(), 9900);
		assertEquals(apt2bhk.getCost(), 60700.0, 1e-4);

		apt3bhk.addPeople(35);
		assertEquals(apt3bhk.getTotalLitres(), 16500);
		assertEquals(apt3bhk.getCost(), 109450.0, 1e-4);

		apt2bhk.addPeople(108);
		assertEquals(apt2bhk.getTotalLitres(), 42300);
		assertEquals(apt2bhk.getCost(), 319900.0, 1e-4);

		apt2bhk.addPeople(144);
		assertEquals(apt2bhk.getTotalLitres(), 85500);
		assertEquals(apt2bhk.getCost(), 665500.0, 1e-4);

		apt3bhk.addPeople(200);
		assertEquals(apt3bhk.getTotalLitres(), 76500);
		assertEquals(apt3bhk.getCost(), 589450.0, 1e-4);

		apt3bhk.addPeople(250);
		assertEquals(apt3bhk.getTotalLitres(), 151500);
		assertEquals(apt3bhk.getCost(), 1189450.0, 1e-4);
	}

	@Test
	void testEqualsObject() {
		assertEquals(apt2bhk.equals(null),false);
		assertEquals(apt3bhk.equals(null),false);
		assertEquals(apt2bhk.equals(apt3bhk),false);
		assertEquals(apt3bhk.equals(apt3bhk),true);
		assertEquals(apt3bhk.clone(),apt3bhk);
		assertNotEquals(apt3bhk.clone(apt3bhk.getRatio()+0.01),apt3bhk);
		
		try {
			ApartmentBase obj=new Apartment2BHK(3,3,"1:2:3");
		} catch(IllegalArgumentException ex) {
			assertEquals(ex.getMessage(),"Ratio arr.length after split on : should be 2");
		}
		try {
			ApartmentBase obj=new Apartment3BHK(5,5,"-1:2");
		} catch(IllegalArgumentException ex) {
			assertEquals(ex.getMessage(),"numerator is < 0");
		}
		try {
			ApartmentBase obj=new Apartment3BHK(5,5,"1:-2");
		} catch(IllegalArgumentException ex) {
			assertEquals(ex.getMessage(),"denominator is <= 0");
		}
	
	}

	@Test
	void testGetDaysMonth() {
		assertEquals(apt2bhk.getDaysMonth(), 30.0, 1e-4);
		assertEquals(apt3bhk.getDaysMonth(), 30.0, 1e-4);
	}

	@Test
	void testGetLitresPerson() {
		assertEquals(apt2bhk.getLitresPerson(), 10.0, 1e-4);
		assertEquals(apt3bhk.getLitresPerson(), 10.0, 1e-4);
	}

	@Test
	void testGetDefaultPeople() {
		assertEquals(apt2bhk.getDefaultPeople(), 3);
		assertEquals(apt3bhk.getDefaultPeople(), 5);
	}

	@Test
	void testAddPeople() {
		apt2bhk.addPeople(11);
		assertEquals(apt2bhk.getTotalLitres(), 4200);
		assertEquals(apt2bhk.getCost(), 15100.0, 1e-4);

		apt3bhk.addPeople(10);
		assertEquals(apt3bhk.getTotalLitres(), 4500);
		assertEquals(apt3bhk.getCost(), 13450.0, 1e-4);

		apt2bhk.addPeople(6);
		assertEquals(apt2bhk.getTotalLitres(), 6000);
		assertEquals(apt2bhk.getCost(), 29500.0, 1e-4);

		apt3bhk.addPeople(5);
		assertEquals(apt3bhk.getTotalLitres(), 6000);
		assertEquals(apt3bhk.getCost(), 25450.0, 1e-4);

		apt2bhk.addPeople(8);
		assertEquals(apt2bhk.getTotalLitres(), 28 * 300);
		assertEquals(apt2bhk.getCost(), 48700.0, 1e-4);

		apt2bhk.addPeople(2);
		assertEquals(apt2bhk.getTotalLitres(), 9000);
		assertEquals(apt2bhk.getCost(), 53500.0, 1e-4);

		apt3bhk.addPeople(3);
		assertEquals(apt3bhk.getTotalLitres(), 23 * 300);
		assertEquals(apt3bhk.getCost(), 32650.0, 1e-4);

		apt3bhk.addPeople(7);
		assertEquals(apt3bhk.getTotalLitres(), 30 * 300);
		assertEquals(apt3bhk.getCost(), 49450.0, 1e-4);
	}

	@Test
	void testGetRatio() {
		assertEquals(apt2bhk.getRatio(), 1.0 / 3.0, 1e-4);
		assertEquals(apt3bhk.getRatio(), 2.0 / 5.0, 1e-4);
		assertEquals(new Apartment2BHK(3, 3, "3:1").getRatio(), 3.0 / 4.0, 1e-4);
		assertEquals(new Apartment3BHK(5, 5, "7:2").getRatio(), 7.0 / 9.0, 1e-4);

	}

	@Test
	void testGetRatioStr() {
		assertEquals(apt2bhk.getRatioStr(), "1:2");
		assertEquals(apt3bhk.getRatioStr(), "2:3");
		assertEquals(new Apartment2BHK(3, 3, "3:1").getRatioStr(), "3:1");
		assertEquals(new Apartment3BHK(5, 5, "7:2").getRatioStr(), "7:2");

	}

	@Test
	void testGetTotalLitres() {
		assertEquals(apt2bhk.getTotalLitres(), 900);
		assertEquals(apt3bhk.getTotalLitres(), 1500);
		assertEquals(new Apartment2BHK(3, 3, "3:1").getTotalLitres(), 900);
		assertEquals(new Apartment3BHK(5, 5, "7:2").getTotalLitres(), 1500);

		apt2bhk.addPeople(11);
		assertEquals(apt2bhk.getTotalLitres(), 4200);
		apt3bhk.addPeople(10);
		assertEquals(apt3bhk.getTotalLitres(), 4500);

	}

	@Test
	void testCheckValidType() {
		assertEquals(ApartmentBase.checkValidType(2), true);
		assertEquals(ApartmentBase.checkValidType(3), true);
		assertEquals(ApartmentBase.checkValidType(4), false);
		assertEquals(ApartmentBase.checkValidType(1), false);
	}

}
