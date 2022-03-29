package main.java.watermgmt;

import java.io.FileInputStream;

public class WaterManagement {

	public WaterManagement() {
	}

	public static void main(String[] args) {
		String filename = args[0];
		filename = filename.strip();
		if(filename.length()==0) {
			return;
		}
		FileInputStream instream = null; 
		try {  
	          instream = new FileInputStream(filename);  
	          System.setIn(instream);  
	      } catch (Exception e) {  
	          System.err.println("Error Occurred.");  
	      }  		
		CommandParser cmdParser = new CommandParser();
		cmdParser.run();

	}
}
