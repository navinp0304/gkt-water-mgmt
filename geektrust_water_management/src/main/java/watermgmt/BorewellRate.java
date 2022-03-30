package main.java.watermgmt;

public class BorewellRate implements IRateCalculator {
	private final Double BOREWELL_RATE = 1.5;

	@Override
	public Double getRate(Double xlitres) {
		return BOREWELL_RATE * xlitres;
	}

	@Override
	public Double getLitres(ApartmentBase aptObj) {
		if (aptObj == null)
			throw new IllegalArgumentException("null argument");
		return aptObj.getDefaultLitres()  -  (double)Math.round(aptObj.getDefaultLitres()*aptObj.getRatio());
	}

}
