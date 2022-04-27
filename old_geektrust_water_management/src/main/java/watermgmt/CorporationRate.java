package main.java.watermgmt;

public class CorporationRate implements IRateCalculator {
	private final Double CORPORATION_RATE = 1.0;

	@Override
	public Double getRate(Double xlitres) {
		return xlitres * CORPORATION_RATE;
	}

	@Override
	public Double getLitres(ApartmentBase aptObj) {
		if (aptObj == null)
			throw new IllegalArgumentException("null argument");
		return aptObj.getDefaultLitres() * aptObj.getRatio();
	}

}
