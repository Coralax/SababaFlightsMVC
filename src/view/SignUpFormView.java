package view;

import com.sun.xml.internal.bind.v2.TODO;
import controller.AuthenticationController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SignUpFormView {

    private AuthenticationController authController;

    public SignUpFormView(){

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
        LocalDate birthDate;
        DateTimeFormatter formatter ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to sign up page"+"\n");


        //Username validation
        do{
            System.out.println("User name: ");
            username = scanner.nextLine();
            validFlag = this.authController.usernameValidation(username);
        }    while(!validFlag) ;

        //Password validation
        do{
            System.out.println("Password: ");
            password = scanner.nextLine();
            validFlag = this.authController.passwordValidation(password);
        }    while(!validFlag) ;

        //Email validation

        do{
            System.out.println("Email: ");
            email = scanner.nextLine();
            validFlag = this.authController.emailValidation(email);
            if(!validFlag)
                System.out.println("Invalid email. Please try again");

        }    while(!validFlag) ;

        do {
            System.out.println("First name:");
             firstName = scanner.nextLine();
             validFlag=authController.validName(firstName);
             if(!validFlag)
                 System.out.println("Invalid first name. Please try again");
            }while(!validFlag);

        do {
            System.out.println("Last name:");
            lastName = scanner.nextLine();
            validFlag=authController.validName(lastName);
            if(!validFlag)
                System.out.println("Invalid last name. Please try again");
        }while(!validFlag);

        do {
            System.out.println("ID: ");
            idStr = scanner.nextLine();
            validFlag=authController.idValidation(idStr);
           }while(!validFlag);
          id = Long.parseLong(idStr);


        //Date of birth validation
        System.out.println("Birth date in dd/MM/yyyy format: ");
        birthDateStr = scanner.nextLine();
//       do {
//            try {
//                formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//                formatter.parse(birthDateStr);
//                birthDate = LocalDate.parse(birthDateStr, formatter);
//            } catch (Exception e) {
//            }
//        }while(!validFlag);

        boolean signUpFlag = this.authController.agentSignUp(firstName, lastName, id, email, birthDateStr, false, username, password);
        if(signUpFlag){
            System.out.println("Sign up successfully!");
        }
    }

    //TODO: Check that email address does not exist already!!!!
    //TODO: FIX BIRTHDAY VALIDATION


}
