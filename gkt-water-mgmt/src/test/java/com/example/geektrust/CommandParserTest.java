package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.Test;

class CommandParserTest {

	@Test
	void testRun() {
		CommandParser cmdParser = new CommandParser("sample_input/input2.txt");
		PrintStream stdout = System.out;
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		cmdParser.run();
		// restore
		System.setOut(stdout);
		assertEquals(outContent.toString(), "2400 5215\n");
	}

	@Test
	void testCommandParserNoFile() throws IOException {
		CommandParser cmdParser = new CommandParser("nofile");
		InputStream stdin = System.in;
		PrintStream stderr = System.err;

		try (ByteArrayOutputStream errContent = new ByteArrayOutputStream();
				PrintStream newStdErr = new PrintStream(errContent)) {
			System.setErr(newStdErr);
			String data = "ALLOT_WATER 2 1:2\nADD_GUESTS 10\nBILL\n";
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			cmdParser.run();
			// restore
			System.setErr(stderr);
			System.setIn(stdin);
			assertEquals(errContent.toString(), "FILE NOT FOUND\n");
		} catch (IOException ex) {
			throw ex;
		}

	}

	@Test
	void testCommandParser() {
		CommandParser cmdParser = new CommandParser("sample_input/input1.txt");
		assertNotEquals(cmdParser, null);
	}

}
