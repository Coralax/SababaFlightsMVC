package model.repository;

import model.FileManager;
import model.objects.Airport;

import java.io.IOException;

/*Login,Signup*/
public interface AuthenticationRepository {

    boolean userNameLogin(String userName, String password);
    void logOut();
    boolean isLoggedin();
    boolean signUp(String firstName, String lastName, long id, String email, String birthDate, boolean enabled , String userName, String password);

}
