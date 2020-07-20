package view;

import com.sun.xml.internal.bind.v2.TODO;
import controller.AuthenticationController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SignUpView {

    private AuthenticationController authController;
    private SababaFlightsProgram sababaFlightsProgram;

    public SignUpView(){
        this.authController = new AuthenticationController();
    }

    public void signUp() {
        long id;
        boolean validFlag;
        String username;
        String password;
        String email;
        String birthDateStr;
        String firstName;
        String lastName;
        String idStr;
        LocalDate birthDate = null;
        DateTimeFormatter formatter ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Sign up page!"+"\n");

        //Username input and validation
        do{
            System.out.print("User name: ");
            username = scanner.nextLine();
            validFlag = this.authController.usernameValidation(username);
        }    while(!validFlag) ;

        do{
            System.out.print("Password: ");
            password = scanner.nextLine();
            try {
                validFlag = this.authController.passwordValidation(password);
            }catch (IllegalArgumentException e){
                validFlag = false;
            }

        } while(!validFlag);

        //Email input and validation
        do{
            System.out.print("Email: ");
            email = scanner.nextLine();
            validFlag = this.authController.isValidEmail(email);
        }    while(!validFlag);

        //Date of birth input and validation
        do {
            validFlag=true;
            System.out.print("Date of birth in dd/MM/yyyy format: ");
            birthDateStr = scanner.nextLine();
            try {
                formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                formatter.parse(birthDateStr);
                birthDate = LocalDate.parse(birthDateStr, formatter);
            } catch (Exception e) {
                validFlag=false;
                System.out.println("\n"+"Invalid date of birth format!" +"\n");
            }
        }while(!validFlag);

        //Agent is below 18 years old
        if(!authController.minimumAge(birthDate))
        {
            sababaFlightsProgram=new SababaFlightsProgram();
            System.out.println("Returning..."+"\n");
            sababaFlightsProgram.loginScreen();
        }

        //Name inputs and validations
        do {
            System.out.print("First name: ");
             firstName = scanner.nextLine();
             validFlag=authController.validName(firstName);
             if(!validFlag)
                 System.out.println("Invalid first name. Please try again");
            }while(!validFlag);

        do {
            System.out.print("Last name: ");
            lastName = scanner.nextLine();
            validFlag=authController.validName(lastName);
            if(!validFlag)
                System.out.println("Invalid last name. Please try again");
        }while(!validFlag);

        //ID input and validation
        do {
            System.out.print("ID: ");
            idStr = scanner.nextLine();
            validFlag=authController.idValidation(idStr);
           }while(!validFlag);
          id = Long.parseLong(idStr);

        boolean signUpFlag = this.authController.agentSignUp(firstName, lastName, id, email, birthDateStr, false, username, password);
        if(signUpFlag){
            System.out.println("\n"+"Sign up successfully!"+"\n");
        }
    }
}
