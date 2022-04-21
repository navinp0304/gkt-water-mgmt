package com.example.geektrust;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.xml.bind.JAXB;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "ApartmentConfig")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class RateCalculatorConfig {

	@XmlElement(name = "IRateCalculator")
	@Getter private List rateCalculators;

	private static final String RATECONFIGFILE = "src/main/resources/com/example/geektrust/RateCalculatorConfig.xml";

	public void initRateConfig() {
		RateCalculatorConfig rateCalculatorConfig = JAXB.unmarshal(new File(RATECONFIGFILE), RateCalculatorConfig.class);
		System.out.println(rateCalculatorConfig.rateCalculators);
	}
	
	public static void main(String[] args) {
		RateCalculatorConfig rateConfig = new RateCalculatorConfig();
		System.out.println("Before rateConfig");
		rateConfig.initRateConfig();
		System.out.println("After rateConfig");

	}
}
