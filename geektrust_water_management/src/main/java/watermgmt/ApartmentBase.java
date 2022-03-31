package main.java.watermgmt;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * All the common factors for apartment is defined here. All of 2BHK,3BHK,3.5
 * BHK,5BHK would have some 1. Some number of people. 2. Each apartment could
 * have a different ratio of Borewell ,corporation. 3. getDefaultLitres() is an
 * abstract method implemented by 2BHK,3BHK i.e 900 and 1500 litres. 4.
 * RATIO_CORP_BOREWELL is parsed and updated as a Double
 *
 * @author navin
 *
 */

public abstract class ApartmentBase {
	private Integer numPeople = 0, defaultPeople = 0;

	private Double RATIO_CORP_BOREWELL = 0.0;
	private final Integer LITRES_PER_PERSON = 10;
	private final Integer DAYS_PER_MONTH = 30;
	private String ratioStr = "";

	// @formatter:off
	/**
	 * type is the key , 2 for 2BHK and 3 for 3BHK
	 */
	public static Map<Integer,ApartmentBase> validTypes =
			                      Map.of(
			                             2,new Apartment2BHK(3,3,0.0),
			                             3,new Apartment3BHK(5,5,0.0)
			                          // 4,new Apartment4BHK(7,7,0.0) followed by a new class Apartment4BHK extending ApartmentBase
			                         );


	List<IRateCalculator> rateList =
			Arrays.asList(
					 new BorewellRate(),
					 new CorporationRate(),
					 new TankerRate()
					 // new rate can be added here implementing IRateCalculator
				   );

	// @formatter: on

	
	ApartmentBase(Integer nPeople,Integer dPeople){
		if(nPeople < 0) 
			throw new IllegalArgumentException("nPeople < 0");
		if(dPeople <= 0) 
			throw new IllegalArgumentException("dPeople <= 0");
		if(nPeople < dPeople)
			throw new IllegalArgumentException("nPeople < dPeople");
		numPeople = nPeople;
		defaultPeople = dPeople;
	}
	
	ApartmentBase(Integer nPeople,Integer dPeople,String s){
		this(nPeople,dPeople);
		setRatio(s);
	}

	ApartmentBase(Integer nPeople,Integer dPeople,Double ratio){
		this(nPeople,dPeople);
		if( (ratio< 0) || (ratio > 1) ) 
			throw new IllegalArgumentException("ratio not between [0,1]");

		RATIO_CORP_BOREWELL = ratio;
	}	

	// 2BHK would return 900, 3BHK would return 1500
	public abstract Integer getDefaultLitres();

	// This is abstract method that is implemented by 2BHK,3BHK class
	public abstract ApartmentBase clone();

	public abstract ApartmentBase clone(Double ratio);

	/**
	 * defaultLitres is 900,1500 for 2BHK,3BHK. boreLitres and CorpLitres are based
	 * on defaultLitres and ratio. totLitres is the amount including guests added.
	 * slabLitres is based on the difference totLitres - defaultLitres applied by
	 * Tanker.
	 *
	 * @return
	 */
	public Double getCost() {
		double totcost = 0.0;

		for (IRateCalculator rateobj : rateList) {
		//	System.out.println("dbg "+ rateobj.getLitres(this)+" "+this + " "+this.getRatio()+" "+rateobj.getRate(rateobj.getLitres(this)));
			totcost += rateobj.getRate(rateobj.getLitres(this));
		//	System.out.println("totcost = "+totcost);
		}

		return totcost;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) 
			return true;
		if(o == null) 
			return false;
		if(this.getClass()!=o.getClass()) 
			return false;
		ApartmentBase obj = (ApartmentBase)o ;
		return  (Math.abs(getRatio() - obj.getRatio()) < 1e-4)
				&&
				(this.getDefaultPeople() == obj.getDefaultPeople()) 
				&&
				(this.getNumberOfPeople() == obj.getNumberOfPeople()) ;

	}

	
	/**
	 * Assumes an apartment can have atmost 99 default people in the begining
	 */
	@Override
	public int hashCode() {
	    return (int)(getRatio()*10000 + 10000) + 100*getNumberOfPeople() + getDefaultPeople(); 
	}
	
	
	public Integer getDaysMonth() {
		return DAYS_PER_MONTH;
	}
	
	public Integer getLitresPerson() {
		return LITRES_PER_PERSON;
	}
	
	public Integer getDefaultPeople() {
		return defaultPeople;
	}

	public Integer getNumberOfPeople() {
		return numPeople;
	}

	public Integer addPeople(Integer x) {
		numPeople += x;
		return numPeople;
	}


	private void setRatio(String s) {
		String[] arr = s.split(":");
		if(arr.length != 2) 
			throw new IllegalArgumentException("Ratio arr.length after split on : should be 2");
		double x = Double.parseDouble(arr[0]);
		double y = Double.parseDouble(arr[1]);

		if(x<0) 
			throw new IllegalArgumentException("numerator is < 0");
		if(y<=0) 
			throw new IllegalArgumentException("denominator is <= 0");
		
		ratioStr = s;
		RATIO_CORP_BOREWELL = x / (x + y);
	}

	public Double getRatio() {
		return RATIO_CORP_BOREWELL;
	}
	
	public String getRatioStr() {
		return ratioStr;
	}

	public Integer getTotalLitres() {
		return getNumberOfPeople() * DAYS_PER_MONTH * LITRES_PER_PERSON;
	}
	
	public static boolean checkValidType(Integer x){
		return validTypes.get(x) != null;
	}
}
