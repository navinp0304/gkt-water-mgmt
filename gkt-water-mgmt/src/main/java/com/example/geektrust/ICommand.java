package com.example.geektrust;

@FunctionalInterface
public interface ICommand {
	public Apartment parseCommand(Apartment apt,String command);
}
