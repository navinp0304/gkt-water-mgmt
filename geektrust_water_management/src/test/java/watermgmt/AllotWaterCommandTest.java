package test.java.mgmt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.watermgmt.AddGuestsCommand;
import main.java.watermgmt.AllotWaterCommand;
import main.java.watermgmt.Apartment2BHK;
import main.java.watermgmt.Apartment3BHK;
import main.java.watermgmt.ApartmentBase;
import main.java.watermgmt.BillCommand;

class AllotWaterCommandTest {
	ApartmentBase apt2BHK, apt3BHK, obj;
	AllotWaterCommand allotCmd;

	@BeforeEach
	void setup() {
		apt2BHK = new Apartment2BHK(3, 3, "1:2");
		apt3BHK = new Apartment3BHK(5, 5, "2:3");
		allotCmd = new AllotWaterCommand();
		obj = null;
	}

	@Test
	final void allCommands() {

		AllotWaterCommand allotCmd = new AllotWaterCommand();
		BillCommand billCmd = new BillCommand();
		ApartmentBase obj = allotCmd.parseCommand(null, "ALLOT_WATER 2 1:2");
		assertEquals(obj.getTotalLitres(), 900, 1e-4);
		assertEquals(obj.getCost(), 1200, 1e-4);
		AddGuestsCommand addCmd = new AddGuestsCommand();
		obj = addCmd.parseCommand(obj, "ADD_GUESTS 11");
		obj = billCmd.parseCommand(obj, "BILL");
		assertEquals(obj.getTotalLitres(), 4200, 1e-4);
		assertEquals(obj.getCost(), 15100, 1e-4);

		AllotWaterCommand allotCmd1 = new AllotWaterCommand();
		ApartmentBase obj1 = allotCmd1.parseCommand(null, "ALLOT_WATER 3 1:5");

		assertEquals(obj1.getTotalLitres(), 1500, 1e-4);
		assertEquals(obj1.getCost(), 2125, 1e-4);

		AddGuestsCommand addCmd1 = new AddGuestsCommand();
		obj1 = addCmd1.parseCommand(obj1, "ADD_GUESTS 10");
		BillCommand billCmd1 = new BillCommand();
		obj1 = billCmd1.parseCommand(obj1, "BILL");

		obj1.addPeople(10);

		assertEquals(obj1.getTotalLitres(), 7500, 1e-4);
		assertEquals(obj1.getCost(), 37625.0, 1e-4);

	}

	@Test
	void testParseCommand() {
		// public ApartmentBase parseCommand(ApartmentBase obj, String s)
		try {
			obj = allotCmd.parseCommand(apt2BHK, null);
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "string argument = null");
		}

		try {
			obj = allotCmd.parseCommand(new Apartment2BHK(3, 3, "1:2"), "ALLOT_WATER 2 1:2");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "base object already initialized obj!=null");
		}

		try {
			obj = allotCmd.parseCommand(null, "");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "wrong command start with ALLOT_WATER");
		}

		try {
			obj = allotCmd.parseCommand(null, "ALLOT_WATER");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "string arg length!=3");
		}

		try {
			obj = allotCmd.parseCommand(null, "ALLOT_WATER 2");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "string arg length!=3");
		}

		try {
			obj = allotCmd.parseCommand(null, "ALLOT_WATER 3 2:3 4");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "string arg length!=3");
		}

		try {
			obj = allotCmd.parseCommand(null, "BILL 2 1:3");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "command!=ALLOT_WATER");
		}
		try {
			obj = allotCmd.parseCommand(null, "BILL");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "wrong command start with ALLOT_WATER");
		}

	}

	@Test
	void testAllotAptType() {
		try {
			obj = allotCmd.parseCommand(null, "ALLOT_WATER 2:3 1:2");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "apartment type should be unsigned int");
		}

		try {
			obj = allotCmd.parseCommand(null, "ALLOT_WATER 1 1:2");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "apartment type is 2 or 3");
		}

		try {
			obj = allotCmd.parseCommand(null, "ALLOT_WATER -1 1:2");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "apartment type should be unsigned int");
		}
	}

	@Test
	void testAllotRatio() {
		try {
			obj = allotCmd.parseCommand(null, "ALLOT_WATER 2 1#2");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "Ratio string should be of format uint:uint like 2:3 or 1:2");
		}

		try {
			obj = allotCmd.parseCommand(null, "ALLOT_WATER 2 -1:2");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "ratio 1st arg != unsigned int");
		}

		try {
			obj = allotCmd.parseCommand(null, "ALLOT_WATER 2 1:0");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "ratio 2nd arg=0");
		}

		try {
			obj = allotCmd.parseCommand(null, "ALLOT_WATER 2 1:-2");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "ratio 2nd arg != unsigned int");
		}
	}

}
