package main.java;

import java.util.Scanner;

public class CommandParser {
	private ApartmentBase aptBase = null;

	public void run() {
		Scanner input = new Scanner(System.in);

		while (input.hasNextLine()) {
			aptBase = parse(input.nextLine());
		}
		input.close();
	}

	public ApartmentBase parse(String s) {
		if (s == null)
			throw new IllegalArgumentException("arg = null");
		String line = s.strip();
		if (line == "")
			throw new IllegalArgumentException("arg = empty");

		// skip empty or blank lines with spaces

		String[] arr = line.split(" ");

		if (arr[0].equals("ALLOT_WATER")) {
			if (aptBase != null) {

				throw new IllegalArgumentException(
						"Apartment already initialized with ALLOT_WATER command, cannot multiple initialize.");

			}

			AllotWaterCommand cmd = new AllotWaterCommand();

			aptBase = cmd.parseCommand(aptBase, line);
		}

		else if (arr[0].equals("ADD_GUESTS")) {
			if (aptBase == null)
				throw new IllegalArgumentException(
						"Apartment not initialized with ALLOT_WATER command before calling ADD_GUESTS command");

			AddGuestsCommand cmd = new AddGuestsCommand();
			aptBase = cmd.parseCommand(aptBase, line);

		} else if (arr[0].equals("BILL")) {
			if (aptBase == null) {
				throw new IllegalArgumentException(
						"Apartment not initialized with ALLOT_WATER command before calling BILL command");
			}
			BillCommand cmd = new BillCommand();

			aptBase = cmd.parseCommand(aptBase, line);
			aptBase = null;

		} else {
			if (line.length() > 0) {
				throw new IllegalArgumentException("Wrong Command : Ignoring");
			}
		}
		return aptBase;

	}
}
