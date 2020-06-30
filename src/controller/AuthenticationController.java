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


    public AuthenticationController(){
        this.authService = new AuthenticationService();
    }

    public boolean login(String username, String password) {
        if(username==null || username.equals("")|| password == null || password.equals("")){
            throw new IllegalArgumentException("Username or password are required");
        }

        String session = authService.login(username, password);
        if(session != null){
            System.out.println("Session token: " + session);
            return true;
        }
        return false;
    }
}
