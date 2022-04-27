package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class CommandParserTest {

	@Test
	void testRun() {
		CommandParser cmdParser = new CommandParser("sample_input/input2.txt");
		PrintStream stdout = System.out;
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		cmdParser.run();
		//restore
		System.setOut(stdout);
		assertEquals(outContent.toString(),"2400 5215\n");
	}

	@Test
	void testCommandParserNoFile() {
		CommandParser cmdParser = new CommandParser("nofile");
		InputStream stdin = System.in;
		PrintStream stdout = System.out;
		PrintStream stderr = System.err;
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		ByteArrayOutputStream errContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
		String data = "ALLOT_WATER 2 1:2\nADD_GUESTS 10\nBILL\n";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		cmdParser.run();
		//restore
		System.setOut(stdout);
		System.setErr(stderr);
		System.setIn(stdin);
		assertEquals(errContent.toString(),"File not found\n");
	}
	
	@Test
	void testCommandParser() {
		CommandParser cmdParser = new CommandParser("sample_input/input1.txt");
		assertNotEquals(cmdParser, null);
	}

}
