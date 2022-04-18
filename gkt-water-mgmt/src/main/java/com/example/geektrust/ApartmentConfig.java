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
@Data
public class ApartmentConfig {

	@XmlElement(name = "Apartment")
	private List<Apartment> aptList;
	@XmlElement(name = "PersonLitresPerDay")
	private int personLitresPerDay;
	@XmlElement(name = "DaysPerMonth")
	private int daysPerMonth;
	@XmlElement(name = "CorporationRate")
	private double corporationRate;
	@XmlElement(name = "BorewellRate")
	private double borewellRate;

	@Getter
	private int personLitresMonth;
	private Map<Integer, Integer> ResidentsLookup;
	private final String xmlConfigFile = "src/main/resources/com/example/geektrust/ApartmentConfig.xml";


	public  Integer getResidentsLookup(Integer houseType) {
		ApartmentConfig aptConfig = JAXB.unmarshal(new File(xmlConfigFile), ApartmentConfig.class);
		ResidentsLookup = aptConfig.getAptList().stream()
				.collect(Collectors.toMap(Apartment::getId, Apartment::getResidents));
		personLitresMonth = aptConfig.getPersonLitresPerDay() * aptConfig.getDaysPerMonth();
		System.out.println(aptConfig.personLitresPerDay + "|" + aptConfig.daysPerMonth);
		System.out.println(aptConfig.getBorewellRate() + "|" + aptConfig.getCorporationRate());


		return ResidentsLookup.get(houseType);
	}

	public static void main(String[] args) {
		ApartmentConfig aptConfig = new ApartmentConfig();
		System.out.println(aptConfig.getResidentsLookup(2));

	}

}
