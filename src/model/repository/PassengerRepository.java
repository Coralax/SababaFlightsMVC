package model.repository;

import model.objects.Passenger;

public interface PassengerRepository {

   Passenger getPassengerByID(long passengerID);
}
