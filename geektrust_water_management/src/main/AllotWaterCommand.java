package main;

/**
 * case sensitive ALLOT_WATER <apartment-type> <ratio> syntax
 */

public class AllotWaterCommand implements ICommand {

	private Double getAllotRatio(String s) {
		String[] arr = s.split(":");
		double x = Double.parseDouble(arr[0]);
		double y = Double.parseDouble(arr[1]);
		return x / (x + y);
	}

	private ApartmentBase createApartment(String s) {
		String[] arr = s.split(" ");
		String type = arr[1];
		String ratio = arr[2];
		Integer itype = Integer.parseUnsignedInt(type);
		Double dratio = getAllotRatio(ratio);
		// validTypes has ratio as 0
		return ApartmentBase.validTypes.get(itype).clone(dratio);
	}

	@Override
	public ApartmentBase parseCommand(ApartmentBase obj, String s) {
		try {
			boolean ret = verifyCommand(obj, s);
		} catch (IllegalArgumentException ex) {
			throw ex;
		}

		return createApartment(s);
	}

	private boolean verifyCommand(ApartmentBase obj, String s) {
		if (s == null)
			throw new IllegalArgumentException("string argument = null");

		if (obj != null)
			throw new IllegalArgumentException("base object already initialized obj!=null");

		String[] arr = s.split(" ");
		if (arr.length == 1) {
			if (!arr[0].equals("ALLOT_WATER"))
				throw new IllegalArgumentException("wrong command start with ALLOT_WATER");
			else
				throw new IllegalArgumentException("string arg length!=3");
		}

		if (arr.length != 3) {
			throw new IllegalArgumentException("string arg length!=3");
		}

		try {
			Integer ret = Integer.parseUnsignedInt(arr[1]);
			boolean isvalid = ApartmentBase.checkValidType(ret);
			if (!isvalid) {
				throw new IllegalArgumentException("apartment type is 2 or 3");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("apartment type should be unsigned int");
		}

		String[] arrRatio = arr[2].split(":");

		if (arrRatio.length != 2) {
			throw new IllegalArgumentException("Ratio string should be of format uint:uint like 2:3 or 1:2");
		}

		try {
			Integer.parseUnsignedInt(arrRatio[0]);

		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("ratio 1st arg != unsigned int");

		}

		try {
			Integer y = Integer.parseUnsignedInt(arrRatio[1]);
			if (y == 0)
				throw new IllegalArgumentException("ratio 2nd arg=0");

		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("ratio 2nd arg != unsigned int");
		}

		return true;
	}

}
