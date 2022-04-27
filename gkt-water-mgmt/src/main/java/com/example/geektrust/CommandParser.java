package com.example.geektrust;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CommandParser {

	String fileName;
	CommandParser(String fileName){
		this.fileName = fileName;
	}

	void run() {
		CommandCollections commandcols = new CommandCollections();
		Apartment apt=null;
		try (Scanner scanner = new Scanner(new File(fileName))) {
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				apt=commandcols.parseCommand(apt, line);
				
			}
		} catch (FileNotFoundException fnfe) {
			System.err.print("File not found\n");
		}
	}
}
