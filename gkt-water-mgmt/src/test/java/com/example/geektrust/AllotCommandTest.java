package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AllotCommandTest {

	@Test
	void testParseCommand() {
		AllotCommand command = new AllotCommand();
		Apartment apt=command.parseCommand("ALLOT_WATER 3 1:5");
		assertNotEquals(apt,null);
	}

	@Test
	void testAllotCommand() {
		AllotCommand command = new AllotCommand();
		assertNotEquals(command,null);
	}

}
