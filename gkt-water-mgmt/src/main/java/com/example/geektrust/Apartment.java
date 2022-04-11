package com.example.geektrust;

import lombok.Data;

@Data public abstract class Apartment {
         private double ratioCORPORATIONBOREWELL = 0.0;
         private int residents = 0;
         private int guests  = 0;
         public void addGuests(int guests) {
        	 this.setGuests(this.getGuests()+guests); 
         }
}
