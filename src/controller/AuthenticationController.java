/* 1.Make Singleton
   2. Can contain as many services as it needs*/

package controller;
import model.service.AuthenticationService;

import java.time.LocalDate;

public class AuthenticationController {

    private AuthenticationService authService;

    public boolean agentSignUp(String firstName, String lastName, long id, String email, LocalDate birthDate, boolean enabled , String userName, String password){

        /*Calling to Authentication service to validate id, email, birthdate, username, password *and* enabled or not (enabled is taken from the AuthenticationRepository that
         service will call*/


        return true;
    }

}
