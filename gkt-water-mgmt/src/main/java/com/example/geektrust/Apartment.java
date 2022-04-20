package com.example.geektrust;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class Apartment {
	@NonNull
	@Getter private Integer id;
	@NonNull
	@Getter private Integer residents;
	@NonNull
	@Getter private Double ratioCORPORATIONBOREWELL;

	@NonNull
	@Getter private int guests;


}
