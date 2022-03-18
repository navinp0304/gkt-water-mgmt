package main.java;

public class Apartment2BHK extends ApartmentBase {

	public Apartment2BHK(Integer people, Integer defpeople, Double ratio) {
		super(people, defpeople, ratio);
	}

	public Apartment2BHK(Integer people, Integer defpeople, String s) {
		super(people, defpeople, s);
	}

	@Override
	public Integer getDefaultLitres() {

		return getDefaultPeople() * getLitresPerson() * getDaysMonth();
	}

	@Override
	public ApartmentBase clone() {
		return clone(this.getRatio());
	}

	@Override
	public ApartmentBase clone(Double ratio) {
		if (ratio < 0)
			throw new IllegalArgumentException("ratio < 0");
		if (ratio > 1)
			throw new IllegalArgumentException("ratio > 1");
		
		return new Apartment2BHK(this.getNumberOfPeople(), this.getDefaultPeople(), ratio);
	}
}
