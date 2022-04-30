package com.example.geektrust;

import org.jetbrains.annotations.NotNull;

public class Main {
    public static void main(String @NotNull [] args)  {
    	String filename = args[0];
    	CommandParser cp = new CommandParser(filename);
    	cp.run();
    	WaterMgmtLogger logger = new WaterMgmtLogger();
    	//System.out.println(logger.readFirstLine());
	}
}
