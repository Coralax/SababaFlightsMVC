/* 1.Make Singleton
   2. Can contain as many services as it needs*/

package controller;
import model.objects.Passenger;
import model.service.AuthenticationService;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthenticationController {

    private AuthenticationService authService;

    public AuthenticationController(){
        this.authService = new AuthenticationService();
    }

    public Passenger passengerExists(long id ) {
        return authService.passengerExists(id);
    }

    public boolean usernameValidation(String userName){
        boolean isValid=true;
        if (!userName.matches("^[a-zA-Z]*[0-9]*$")) {
            System.out.println("\n"+"User name must consist of only English alphanumeric characters!"+"\n");
            isValid=false;
        }
        if (userName.length() < 6 || userName.length() > 20) {
            System.out.println( "\n"+ "User name must be between 6 and 20 characters long!" +"\n");
            isValid=false;
        }
        if(isValid){
            boolean userExist = this.authService.userExist(userName);
            if(userExist){
                System.out.println("\n" +"Username already exists, please try again "+"\n");
                return false;
            } else
                return true;
        }
        return false;
    }

    public boolean checkPasswordValidation(String password) {
        if (!(password.matches("^(?=.*[0-9])(?=.*[a-zA-Z]).{8,32}$"))) {
            return passwordStrength(password);
        }
        return true;
    }

    public boolean passwordValidation(String pass){
        boolean isValid = this.checkPasswordValidation(pass);
        if( !isValid)
            throw new IllegalArgumentException("");
        return this.checkPasswordValidation(pass);
    }

    public boolean passwordStrength(String password) {
        if (password.length() < 8 || password.length() > 32) {
            System.out.println("\n"+"Password must be between 8 and 32 characters long! " +"\n");
            return false;
        }

        if (!(password.matches("(?=.*[0-9]).*"))) {
            System.out.println("\n"+"Password must contain at least one digit! "+"\n");
            return false;
        }

        if (!(password.matches("(?=.*[a-zA-Z]).*"))) {
            System.out.println("\n"+"Password must contain at least one letter! "+"\n");
            return false;
        }
        return true;
    }

    public boolean minimumAge(LocalDate dateOfBirth) {
        Period period = Period.between(dateOfBirth, LocalDate.now());
         if (period.getYears() < 18) {
            System.out.println("\n"+"Agent must be 18 years old or above!" +"\n");
            return false;
        }
        return true;
    }

    public boolean isValidEmail(String email) {
        if (email == null ||email.trim().equals("")) {
            System.out.println("\nInvalid email!"+"\n");
            return false;
        }
        boolean exist =authService.emailExists(email);
        if(exist)
            return false;

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
         if(!pat.matcher(email).matches()) {
             System.out.println("\nInvalid email format!"+"\n");
             return false;
         }
         return true;
    }

    public boolean agentSignUp(String firstName, String lastName, long id, String email, String birthDate, boolean enabled , String userName, String password) {
    return authService.signUp(firstName,lastName,id,email,birthDate,enabled,userName,password);
    }

    public boolean validName(String name) {
        return name != null && !name.trim().equals("");
    }

    public boolean login(String userName, String password) {
        if(userName == null || userName.trim().equals("")|| password == null || password.trim().equals("")){
            System.out.println("\n"+"Username and password are required!" +"\n");
            return false;
        }
        return authService.login(userName, password);
    }

    public boolean passportValidation(String passport) {
        if (!(passport.matches("[A-Za-z0-9_]+"))) {
            System.out.println("\n"+"Passport must consist of English alphanumeric characters and digits only!" +"\n");
            return false;
        }
        return true;
    }

    public boolean idValidation(String id) {
        if (!(id.matches("^[0-9]+$")) ||(id.length()<5)) {
            System.out.println("\n"+"ID must contain only digits and have a minimum length of 5!" +"\n");
            return false;
        }
        return true;
    }

    public boolean creditCardValidation(String card) {
        if (!(card.matches("^[0-9]+$")) ||(card.length()<16)) {
            System.out.println("\n"+"Credit card must contain only digits and length of 16!" +"\n");
            return false; }
        return true;
    }

    public boolean isDate(String date){
        Pattern pattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

}
