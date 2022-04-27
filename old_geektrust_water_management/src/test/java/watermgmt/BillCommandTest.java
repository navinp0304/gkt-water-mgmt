package test.java.watermgmt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.watermgmt.AddGuestsCommand;
import main.java.watermgmt.AllotWaterCommand;
import main.java.watermgmt.Apartment2BHK;
import main.java.watermgmt.Apartment3BHK;
import main.java.watermgmt.ApartmentBase;
import main.java.watermgmt.BillCommand;

class BillCommandTest {
	BillCommand billCmd;

	@BeforeEach
	void setUp() {
		billCmd = new BillCommand();
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
		ApartmentBase obj1 = allotCmd1.parseCommand(null, "ALLOT_WATER 3 2:3");
		assertEquals(obj1.getTotalLitres(), 1500, 1e-4);
		assertEquals(obj1.getCost(), 1950, 1e-4);
		AddGuestsCommand addCmd1 = new AddGuestsCommand();
		obj1 = addCmd1.parseCommand(obj1, "ADD_GUESTS 10");
		BillCommand billCmd1 = new BillCommand();
		obj1 = billCmd1.parseCommand(obj1, "BILL");

		assertEquals(obj1.getTotalLitres(), 4500, 1e-4);
		assertEquals(obj1.getCost(), 13450, 1e-4);

	}

	@Test
	final void test2BHK() {
		ApartmentBase obj = new Apartment2BHK(3, 3, "1:2");
		obj = billCmd.parseCommand(obj, "BILL");
		assertEquals(obj.getTotalLitres(), 900, 1e-4);
		assertEquals(obj.getCost(), 1200, 1e-4);
		obj.addPeople(11); // equivalent to add guests 10
		obj = billCmd.parseCommand(obj, "BILL");
		assertEquals(obj.getTotalLitres(), 4200, 1e-4);
		assertEquals(obj.getCost(), 15100, 1e-4);

	}

	@Test
	final void test3BHK() {
		ApartmentBase obj = new Apartment3BHK(5, 5, "2:3");
		obj = billCmd.parseCommand(obj, "BILL");
		assertEquals(obj.getTotalLitres(), 1500, 1e-4);
		assertEquals(obj.getCost(), 1950, 1e-4);
		obj.addPeople(10); // equivalent to add guests 10
		obj = billCmd.parseCommand(obj, "BILL");
		assertEquals(obj.getTotalLitres(), 4500, 1e-4);
		assertEquals(obj.getCost(), 13450, 1e-4);
	}

	@Test
	final void testParseCommand() {
		assertNull(billCmd.parseCommand(null, "BILL"), "Apartment base object is null");
		assertNotNull(billCmd.parseCommand(ApartmentBase.validTypes.get(2), null), "2BHK string argument is null");
		assertNotNull(billCmd.parseCommand(ApartmentBase.validTypes.get(3), null), "3BHK string argument is null");
		try {
			billCmd.parseCommand(new Apartment3BHK(5, 5, "2:3"), "NOTBILL");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "BILL command expected");
		}
	}

}
