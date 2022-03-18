package main.java;

public class AddGuestsCommand implements ICommand {

	@Override
	public ApartmentBase parseCommand(ApartmentBase obj, String s) {
		try {
			boolean ret = verifyCommand(obj, s);
		} catch (IllegalArgumentException ex) {
			throw ex;
		}

		String[] arr = s.split(" ");
		String numPeople = arr[1];

		obj.addPeople(Integer.parseInt(numPeople));
		return obj;
	}

	private boolean verifyCommand(ApartmentBase obj, String s) {
		if (obj == null)
			throw new IllegalArgumentException("apartment base null not initialized with allot_water command");
		if (s == null)
			throw new IllegalArgumentException("command string is null");

		if (s.length() == 0)
			throw new IllegalArgumentException("command string is empty");

		String[] arr = s.split(" ");

		if (arr.length == 1) {
			if (!arr[0].equals("ADD_GUESTS")) {
				throw new IllegalArgumentException("command should be ADD_GUESTS");
			}

		}
		if (arr.length != 2) {
			throw new IllegalArgumentException("command string split on space should be of size 2");
		}

		try {
			Integer.parseUnsignedInt(arr[1]);

		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("arg1 should be unsigned int");
		}
		return true;
	}

}
