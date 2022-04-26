package com.example.geektrust;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class CommandParser {
	@NonNull
	String fileName;

	void run() {
		CommandCollections commandcols = new CommandCollections();
		Apartment apt=null;
		try (Scanner scanner = new Scanner(new File(fileName))) {
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				apt=commandcols.parseCommand(apt, line);
				
			}
		} catch (FileNotFoundException fnfe) {
			System.err.println("File not found\n");
		}
	}
}
