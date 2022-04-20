package com.example.geektrust;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.xml.bind.JAXB;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@XmlRootElement(name = "ApartmentConfig")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class ApartmentConfig {

	@XmlElement(name = "Apartment")
	@Getter private List<Apartment> aptList;
	@XmlElement(name = "PersonLitresPerDay")
	@Getter private int personLitresPerDay;
	@XmlElement(name = "DaysPerMonth")
	@Getter private int daysPerMonth;
	@XmlElement(name = "CorporationRate")
	@Getter private double corporationRate;
	@XmlElement(name = "BorewellRate")
	@Getter private double borewellRate;

	@Getter
	private int personLitresMonth;
	private Map<Integer, Integer> residentsLookup;
	private static final String XMLCONFIGFILE = "src/main/resources/com/example/geektrust/ApartmentConfig.xml";

	public Integer getResidentsLookup(Integer houseType) {
		ApartmentConfig aptConfig = JAXB.unmarshal(new File(XMLCONFIGFILE), ApartmentConfig.class);
		residentsLookup = aptConfig.getAptList().stream()
				.collect(Collectors.toMap(Apartment::getId, Apartment::getResidents));
		personLitresMonth = aptConfig.getPersonLitresPerDay() * aptConfig.getDaysPerMonth();
		System.out.println(aptConfig.personLitresPerDay + "|" + aptConfig.daysPerMonth);
		System.out.println(aptConfig.getBorewellRate() + "|" + aptConfig.getCorporationRate());

		return residentsLookup.get(houseType);
	}

	public static void main(String[] args) {
		ApartmentConfig aptConfig = new ApartmentConfig();
		System.out.println(aptConfig.getResidentsLookup(2));

	}

}
