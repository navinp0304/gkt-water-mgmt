package com.example.geektrust;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CommandParser {

	final String fileName;

	CommandParser(String fileName){
		this.fileName = fileName;
		/*
		System.setProperty("java.util.logging.SimpleFormatter.format", "%5$S%n");
	
		logger = Logger.getLogger(CommandParser.class.getName());
		logger.setUseParentHandlers(false);

		SimpleFormatter fmt = new SimpleFormatter();
		StreamHandler sh = new StreamHandler(System.err, fmt);
		logger.addHandler(sh);
		*/
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
			//logger.severe("FILE NOT FOUND\n");
			WaterMgmtLogger logger = new WaterMgmtLogger();
			logger.writeFirstLine("FILE NOT FOUND\n");
		}
	}
}
