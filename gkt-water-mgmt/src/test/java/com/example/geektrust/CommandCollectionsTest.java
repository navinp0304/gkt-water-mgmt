package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class CommandCollectionsTest {

	@Test
	void testParseCommandAllot() {
		CommandCollections command = new CommandCollections();
		Apartment apt;
		apt=command.parseCommand(null, "ALLOT_WATER 3 1:5");
		assertNotEquals(apt,null);
	}
	
	@Test
	void testParseCommandAddGuests() {
		CommandCollections command = new CommandCollections();
		Apartment apt;
		apt=command.parseCommand(null, "ALLOT_WATER 3 1:5");
		apt=command.parseCommand(apt, "ADD_GUESTS 10");
		assertEquals(apt.getGuests(),10);
	}
	
	@Test
	void testParseCommandBill() {
		CommandCollections command = new CommandCollections();
		Apartment apt;
		apt=command.parseCommand(null, "ALLOT_WATER 2 3:7");
		apt=command.parseCommand(apt, "ADD_GUESTS 5");
		apt=command.parseCommand(apt, "BILL");
		


		WaterMgmtLogger logger = new WaterMgmtLogger();
		String firstLine = logger.readFirstLine();
		//System.out.println("Firstline is "+firstLine);
		Double[] exp={2400.0,5215.0};
		String[] tokens = firstLine.split(" ");
		Double litres = Double.parseDouble(tokens[0]);
		Double cost = Double.parseDouble(tokens[1]);
		Double[] observed = {litres,cost};
		Apartment finalApt = apt;
		assertAll("Print Bill Command rate summary",
				() -> assertEquals(finalApt.getGuests(),5),
				() -> assertEquals(observed[0],exp[0],1.0e-6),
				() -> assertEquals(observed[1],exp[1],1.0e-6)
				);
		
	}

}
