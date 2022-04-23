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

	void processCommand(String cmd) {
		System.out.println(cmd);
	}

	void run() {
		try (Scanner scanner = new Scanner(new File(fileName))) {
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(" i started " + "  "+ args.length+" "+args[0]);
		System.out.println(System.getProperty("user.dir") );
		CommandParser cp = new CommandParser(args[0]);
		cp.run();
	}

}
