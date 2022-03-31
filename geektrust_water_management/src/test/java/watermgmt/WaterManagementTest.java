package test.java.watermgmt;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.junit.jupiter.api.Test;

import main.java.watermgmt.WaterManagement;

class WaterManagementTest {
	
	

	@Test
	void testMain() {
		WaterManagement obj = new WaterManagement();
		String filename="";
		
		String data = "ALLOT_WATER 2 1:2\nADD_GUESTS 10\nBILL\n";
		File tempFile;
		try {
			tempFile = File.createTempFile("watermgmt-gkt-", ".tmp");
			tempFile.deleteOnExit();
			FileWriter fileWriter = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fileWriter);
		    bw.write(data);
		    bw.close();
		    filename=tempFile.getAbsolutePath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] args= {filename};
		
		
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
