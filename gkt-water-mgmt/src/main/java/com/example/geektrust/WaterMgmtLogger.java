package com.example.geektrust;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WaterMgmtLogger {
	private static final String fileName = "logFile.txt";

	public String readFirstLine() {
		BufferedReader brRead = null;
		String firstLine = null;
		try {
			brRead = new BufferedReader(new FileReader(fileName));
			firstLine = brRead.readLine();

		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (brRead != null)
					brRead.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return firstLine;

	}

	public void writeFirstLine(String s) {
		BufferedWriter brWrite = null;

		try {
			brWrite = new BufferedWriter(new FileWriter(fileName));
			brWrite.write(s);

		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (brWrite != null)
					brWrite.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
