package com.example.geektrust;

public class Main {
    public static void main(String[] args)  {
    	String filename = args[0];
    	CommandParser cp = new CommandParser(filename);
    	cp.run();
	}
}
