package model.repository;

import model.objects.Passenger;

public interface PassengerRepository {

     Passenger passengerExist(long id);
     Passenger getPassengerByID(long passengerID);


}
