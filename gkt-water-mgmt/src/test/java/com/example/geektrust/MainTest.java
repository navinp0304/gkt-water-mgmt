package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void testMain() {
		String[] args = { "sample_input/input2.txt" };
		Main objMain = new Main();

		Main.main(args);

		WaterMgmtLogger logger = new WaterMgmtLogger();
		String firstLine = logger.readFirstLine();
		assertAll("Main test", () -> assertEquals(firstLine, "2400 5215"), () -> assertNotEquals(objMain, null));
	}

}
