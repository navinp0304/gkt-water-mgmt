package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import main.WaterManagement;

class WaterManagementTest {
	
	

	@Test
	void testMain() {
		WaterManagement obj = new WaterManagement();
		String[] args= {"dummy arg1","dummy arg2"};
		
		String data = "ALLOT_WATER 2 1:2\nADD_GUESTS 10\nBILL\n";
		InputStream stdin = System.in;
		PrintStream stdout = System.out;
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		
		
		obj.main(args);
		System.setIn(stdin);
		System.setOut(stdout);
		assertEquals(outContent.toString().trim(), "3900 12700");

	}

}
