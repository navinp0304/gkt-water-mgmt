package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.AddGuestsCommand;
import main.AllotWaterCommand;
import main.Apartment2BHK;
import main.Apartment3BHK;
import main.ApartmentBase;
import main.BillCommand;

class AddGuestsCommandTest {
	ApartmentBase apt2BHK, apt3BHK, obj;
	AddGuestsCommand allotCmd;

	@BeforeEach
	void setup() {
		apt2BHK = new Apartment2BHK(3, 3, "1:2");
		apt3BHK = new Apartment3BHK(5, 5, "2:3");
		allotCmd = new AddGuestsCommand();
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
	void testParseCommand() {
		AddGuestsCommand addCmd = new AddGuestsCommand();
		obj = null;
		try {
			obj = addCmd.parseCommand(obj, "ADD_GUESTS ");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "apartment base null not initialized with allot_water command");
		}

		try {
			apt2BHK = addCmd.parseCommand(apt2BHK, null);
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "command string is null");
		}

		try {
			apt3BHK = addCmd.parseCommand(apt3BHK, "");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "command string is empty");
		}

		try {
			apt3BHK = addCmd.parseCommand(apt3BHK, "ADD_GUESTS");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "command string split on space should be of size 2");
		}

		try {
			apt3BHK = addCmd.parseCommand(apt3BHK, "ADD_GUESTS 20 30");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "command string split on space should be of size 2");
		}

		try {
			apt3BHK = addCmd.parseCommand(apt3BHK, "ADD_NONE");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "command should be ADD_GUESTS");
		}

		try {
			apt3BHK = addCmd.parseCommand(apt3BHK, "ADD_NONE 12");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "command should be ADD_GUESTS");
		}

		try {
			apt3BHK = addCmd.parseCommand(apt3BHK, "");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "command string is empty");
		}

		try {
			apt3BHK = addCmd.parseCommand(apt3BHK, "ADD_GUESTS -1");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "arg1 should be unsigned int");
		}
	}

}
