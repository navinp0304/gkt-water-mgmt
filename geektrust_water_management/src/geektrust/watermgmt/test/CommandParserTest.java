package geektrust.watermgmt.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import geektrust.watermgmt.src.ApartmentBase;
import geektrust.watermgmt.src.CommandParser;

class CommandParserTest {
	CommandParser cmd;
	ApartmentBase obj;

	@BeforeEach
	void setup() {
		cmd = new CommandParser();
		obj = null;
	}

	@Test
	void checkInput() {
		String data = "ALLOT_WATER 2 1:2\nADD_GUESTS 10\nBILL\n";
		InputStream stdin = System.in;
		PrintStream stdout = System.out;
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		cmd.run();

		System.setIn(stdin);
		System.setOut(stdout);
		assertEquals(outContent.toString().trim(), "3900 12700");
	}

	@Test
	void testParse() {
		try {
			obj = cmd.parse(null);
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "arg = null");
		}
		try {
			obj = cmd.parse("");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "arg = empty");
		}

		try {
			obj = cmd.parse("junk");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "Wrong Command : Ignoring");
		}
		try {
			obj = cmd.parse("BILL");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(),
					"Apartment not initialized with ALLOT_WATER command before calling BILL command");
		}

		try {
			obj = cmd.parse("ADD_GUESTS");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(),
					"Apartment not initialized with ALLOT_WATER command before calling ADD_GUESTS command");
		}
		try {
			obj = cmd.parse("ALLOC_WATER");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "Wrong Command : Ignoring");
		}
		try {
			obj = cmd.parse("ADD_GUESTS 10");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(),
					"Apartment not initialized with ALLOT_WATER command before calling ADD_GUESTS command");
		}
		try {
			obj = cmd.parse("BILL");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(),
					"Apartment not initialized with ALLOT_WATER command before calling BILL command");
		}
		try {
			obj = cmd.parse("ALLOT_WATER");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "string arg length!=3");
		}

		obj = cmd.parse("ALLOT_WATER 2 1:2");
		assertNotNull(obj);

		try {
			obj = cmd.parse("ALLOT_WATER 2 1:2");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(),
					"Apartment already initialized with ALLOT_WATER command, cannot multiple initialize.");
		}

		obj = cmd.parse("ADD_GUESTS 11");
		assertNotNull(obj);
		assertEquals(obj.getTotalLitres() / (obj.getDaysMonth() * obj.getLitresPerson()), 14);

		obj = cmd.parse("BILL");
		if(obj!=null) {
			assertEquals(obj.getTotalLitres(), 4200, 1e-4);
			assertEquals(obj.getCost(), 15100, 1e-4);
		}

	}

}
