package main.java.watermgmt;

public class BillCommand implements ICommand {

	@Override
	public ApartmentBase parseCommand(ApartmentBase obj, String s) {
		// return obj unchanged if verification fails
		if (verifyCommand(obj, s) != true)
			return obj;
		// Print the <TOTAL_WATER_CONSUMED_IN_LITERS> <TOTAL_COST>
		long totlitres = Math.round(obj.getTotalLitres());
		long totcost = (long) Math.ceil(obj.getCost());
		System.out.println(Long.toString(totlitres) + " " + Long.toString(totcost));
		return obj;
	}

	private boolean verifyCommand(ApartmentBase obj, String s) {
		if (obj == null)
			return false;
		if (s == null)
			return false;
		if (s.equals("BILL")) {
			return true;
		}
		throw new IllegalArgumentException("BILL command expected");
	}

}
