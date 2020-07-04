package model.service;
/*Need to do:
 * 1. A method to validate that the user name of an agent is not already taken
 * 2. A method to validate that an ID is a unique identifier and no other person exists with the same ID
 * 3. A method to validate that an email address is not already taken by another person*/

import model.repository.AuthenticationRepositoryImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;
import java.util.regex.Pattern;

public class AuthenticationService {

    private AuthenticationRepositoryImpl authRepository;

    public AuthenticationService() {
        this.authRepository = new AuthenticationRepositoryImpl();
    }

    public String login(String userName, String password){
        if(this.authRepository.userNameLogin(userName, password)){
            return UUID.randomUUID().toString();
        }
        return null;
    }

    public boolean userNameValidation(String userName) {

        if (!userName.matches("^[a-zA-Z]*$")) {
            System.out.println("User name must consist of only English alphanumeric characters!");
            return false;
        }
        if (userName.length() < 6 || userName.length() > 20) {
            System.out.println("User name must be between 6 and 20 characters long");
            return false;
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


    public boolean passportValidation(String passport) {
        if (!(passport.matches("[A-Za-z0-9_]+"))) {
            System.out.println("Passport must consist of English alphanumeric characters and digits only!");
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

    public boolean dateValidation(LocalDate dateOfBirth) {
        return true;
    }

    public boolean signUp(String firstName, String lastName, long id, String email, String birthDate, boolean enabled , String userName, String password) {

            return this.authRepository.signUp(firstName, lastName, id, email, birthDate, enabled, userName, password);

    }
}


