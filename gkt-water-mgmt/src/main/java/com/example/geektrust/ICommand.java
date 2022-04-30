package com.example.geektrust;

@FunctionalInterface
public interface ICommand {
	Apartment parseCommand(Apartment apt,String command);
}
