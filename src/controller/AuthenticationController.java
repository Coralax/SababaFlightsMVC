/* 1.Make Singleton
   2. Can contain as many services as it needs*/

package controller;
import model.service.AuthenticationService;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthenticationController {

    private AuthenticationService authService;

    public AuthenticationController(){
        this.authService = new AuthenticationService();
    }

    public boolean usernameValidation(String userName){
        boolean isValid=true;
        if (!userName.matches("^[a-zA-Z]*[0-9]*$")) {
            System.out.println("User name must consist of only English alphanumeric characters!");
            isValid=false;
        }
        if (userName.length() < 6 || userName.length() > 20) {
            System.out.println("User name must be between 6 and 20 characters long");
            isValid=false;
        }
        if(isValid){
            boolean userExist = this.authService.userExist(userName);
            if(userExist){
                System.out.println("Username already exists, please try again.");
                return false;
            } else // The username is ready to use (valid&not used before)
                return true;
        } //not a valid username
        return false;
    }

    public boolean passwordValidation(String password) {
        if (!(password.matches("^(?=.*[0-9])(?=.*[a-zA-Z]).{8,32}$"))) {
            return passwordStrength(password);
        }
        return true;
    }

    public boolean passwordStrength(String password) {
        if (password.length() < 8 || password.length() > 32) {
            System.out.println("Password must be between 8 and 32 characters long");
            return false;
        }

        if (!(password.matches("(?=.*[0-9]).*"))) {
            System.out.println("Password must contain at least one digit! ");
            return false;
        }

        if (!(password.matches("(?=.*[a-zA-Z]).*"))) {
            System.out.println("Password must contain at least one letter! ");
            return false;
        }
        return true;
    }

    public boolean minimumAge(LocalDate dateOfBirth) {

        Period period = Period.between(LocalDate.now(), dateOfBirth);
        if (period.getYears() < 18) {
            System.out.println("Agent must be above 18 years old");
            return false;
        }
        return true;
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    /*Calling to Authentication service to validate id, email, birthdate, username, password *and* enabled or not (enabled is taken from the AuthenticationRepository that
     service will call*/
    public boolean agentSignUp(String firstName, String lastName, long id, String email, String birthDate, boolean enabled , String userName, String password) {
    return authService.signUp(firstName,lastName,id,email,birthDate,enabled,userName,password);
    }

    public boolean validName(String name) {
        return name != null && !name.trim().equals("");
    }
    public boolean login(String userName, String password) {
        if(userName == null || userName.trim().equals("")|| password == null || password.trim().equals("")){
            throw new IllegalArgumentException("Username or password are required");
        }

        return authService.login(userName, password);

    }
    public boolean emailValidation(String email){
        return isValidEmail(email);
    }

    public boolean passportValidation(String passport) {
        if (!(passport.matches("[A-Za-z0-9_]+"))) {
            System.out.println("Passport must consist of English alphanumeric characters and digits only!");
            return false;
        }
        return true;
    }

    public boolean isDate(String date){
        Pattern pattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
    public boolean birthdayValidation(String date){
        return isDate(date);
    }

    public boolean dateValidation(LocalDate dateOfBirth) {
        return true;
    }

}
