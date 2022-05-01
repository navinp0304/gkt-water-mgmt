package com.example.geektrust;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WaterMgmtLogger {
	private static final String fileName = "logFile.txt";

	public String readFirstLine() {
		String firstLine = "";

		try (BufferedReader brRead = new BufferedReader(new FileReader(fileName))) {
			firstLine = brRead.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return firstLine;

	}

	public void writeFirstLine(String s) {

		try (BufferedWriter brWrite = new BufferedWriter(new FileWriter(fileName))) {
			brWrite.write(s);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
