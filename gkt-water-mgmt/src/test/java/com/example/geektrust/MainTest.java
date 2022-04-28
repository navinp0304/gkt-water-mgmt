package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void testMain() {
		String[] args= {"sample_input/input2.txt"};
		PrintStream stdout = System.out;

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		Main.main(args);
		System.setOut(stdout);
		assertAll("Main test",
				() -> assertEquals(outContent.toString(),"2400 5215\n")
		);
	}

}
