package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class PrintBillCommandTest {

	@Test
	void testPrintBillCommand() {
		PrintBillCommand command = new PrintBillCommand();
		assertNotEquals(command,null);
	}

	@Test
	void testParseCommand() {
		PrintBillCommand command = new PrintBillCommand();
		Apartment apt=new Apartment(2,0.3,5);
		PrintStream outStream = System.out;	
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		apt=command.parseCommand(apt);
		System.setOut(outStream);
		RateSummary exp=new RateSummary(2400.0,5215.0);
		String[] tokens = outContent.toString().trim().split(" ");
		Double litres = Double.parseDouble(tokens[0]);
		Double cost = Double.parseDouble(tokens[1]);
		RateSummary observed = new RateSummary(litres,cost);
		Apartment finalApt = apt;
		assertAll("Print Bill Command rate summary",
				() -> assertEquals(finalApt.getGuests(),5),
				() -> assertEquals(observed.getLitres(),exp.getLitres(),1.0e-6),
				() -> assertEquals(observed.getCost(),exp.getCost(),1.0e-6)
				);		
	}

}
