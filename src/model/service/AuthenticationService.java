package model.service;

import model.objects.Passenger;
import model.repository.AuthenticationRepositoryImpl;
import model.repository.PassengerRepositoryImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthenticationService {

    private AuthenticationRepositoryImpl authRepository;

    public AuthenticationService() {
        this.authRepository = new AuthenticationRepositoryImpl(); }

    public boolean login(String userName, String password) {
        return authRepository.userNameLogin(userName, password);
    }

    public boolean signUp(String firstName, String lastName, long id, String email, String birthDate, boolean enabled, String userName, String password) {
        return authRepository.signUp(firstName, lastName, id, email, birthDate, enabled, userName, password);
    }

    public boolean userExist(String username) {
        return authRepository.userExist(username);
    }

    public boolean emailExists(String email) {
        return authRepository.emailExists(email);
    }

    public Passenger passengerExists(long id){
         PassengerRepositoryImpl passengerRepository= new PassengerRepositoryImpl();
        return passengerRepository.getPassengerByID(id);
    }
}


