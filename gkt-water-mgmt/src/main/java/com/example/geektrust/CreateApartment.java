package com.example.geektrust;

public class CreateApartment {
	private CreateApartment() {}
	public static Apartment executeCreateApartment(int type,double ratio) {
		return (type==2)?new Apartment2BHK(ratio):new Apartment3BHK(ratio);
	}
}
