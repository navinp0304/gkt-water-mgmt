package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddGuestsCommandTest {

	@Test
	void testParseCommand() {
		AddGuestsCommand command = new AddGuestsCommand();
//		Apartment apt = new Apartment(2,0.5, 0);
		Apartment apt=new AllotCommand().parseCommand("ALLOT_WATER 2 1:1");

		command.parseCommand(apt,"ADD_GUESTS 6");
		assertEquals(apt.getGuests(),6);
	}

	@Test
	void testAddGuestsCommand() {
		AddGuestsCommand command = new AddGuestsCommand();
		assertNotEquals(command, null);
	}

}
