/* 1.Make Singleton
   2. Can contain as many services as it needs*/

package controller;
import model.service.AuthenticationService;

public class AuthenticationController {

    private AuthenticationService authService;

    public AuthenticationController(){
        this.authService = new AuthenticationService();
    }

    public boolean agentSignUp(String firstName, String lastName, long id, String email, String birthDate, boolean enabled , String userName, String password){

        /*Calling to Authentication service to validate id, email, birthdate, username, password *and* enabled or not (enabled is taken from the AuthenticationRepository that
         service will call*/
    return this.authService.signUp(firstName,lastName,id,email,birthDate,enabled,userName,password);

    }


    public boolean login(String userName, String password) {
        if(userName == null || userName.equals("")|| password == null || password.equals("")){
            throw new IllegalArgumentException("Username or password are required");
        }

        return authService.login(userName, password);

//        String session = authService.login(username, password);
//        if(session != null){
//            System.out.println("Session token: " + session);
//            return true;
//        }
//        return false;
    }
    public boolean emailValidation(String email){
        return this.authService.isValidEmail(email);
    }
    public boolean passwordValidation(String pass){
        return this.authService.passwordValidation(pass);
    }

    public boolean usernameValidation(String username){
        //check validation
        //check if username exist or not
        boolean isValid = this.authService.userNameValidation(username);
        if(isValid){
            boolean userExist = this.authService.userExist(username);
            if(userExist){
                System.out.println("username is already exist, try again.");
                return false;
            } else // The username is ready to use (valid&not used before)
                return true;
        } //not a valid username
        return false;
    }

    public boolean birthdayValidation(String date){
        return this.authService.isDate(date);
    }

}
