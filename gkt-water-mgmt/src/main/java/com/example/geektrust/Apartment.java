package com.example.geektrust;


import lombok.Getter;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class Apartment {
	@NonNull
	@Getter private Integer id;
	@NonNull
	@Getter private Integer residents;
	@NonNull
	@Getter private Double ratioCORPORATIONBOREWELL;

	@NonNull
	@Getter private Integer guests;


}
