package main.java;

public interface IRateCalculator {

	public Double getLitres(ApartmentBase aptObj); // get litres for this object

	public Double getRate(Double xlitres); // rate for xlitres

}
