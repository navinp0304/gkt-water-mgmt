package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.Test;

class CommandParserTest {

	@Test
	void testRun() {
		CommandParser cmdParser = new CommandParser("sample_input/input2.txt");

		cmdParser.run();
		
		WaterMgmtLogger logger = new WaterMgmtLogger();
		String firstLine = logger.readFirstLine();
		// restore
		assertEquals(firstLine, "2400 5215");
	}

	@Test
	void testCommandParserNoFile() throws IOException {
		CommandParser cmdParser = new CommandParser("nofile");
		cmdParser.run();
		WaterMgmtLogger logger= new WaterMgmtLogger();
		String firstLine=logger.readFirstLine();
		assertEquals(firstLine, "FILE NOT FOUND");
	}

	@Test
	void testCommandParser() {
		CommandParser cmdParser = new CommandParser("sample_input/input1.txt");
		assertNotEquals(cmdParser, null);
	}

}
