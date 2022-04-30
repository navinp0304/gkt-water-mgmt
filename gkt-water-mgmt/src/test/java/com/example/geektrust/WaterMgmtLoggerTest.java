package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WaterMgmtLoggerTest {
	
	@Test
	void testReadFirstLine() {
		WaterMgmtLogger logger = new WaterMgmtLogger();
		String line = "This is first line\n";
		logger.writeFirstLine(line);
		String observed = logger.readFirstLine();
		assertEquals(line.trim(),observed);
	}

	@Test
	void testWriteFirstLine() {
		WaterMgmtLogger logger = new WaterMgmtLogger();
		String line = "This is first line\n";
		String secondLine = "This is second line\n";
		logger.writeFirstLine(line);
		logger.writeFirstLine(secondLine);
		String observed = logger.readFirstLine();
		assertEquals(secondLine.trim(),observed);

	}

}
