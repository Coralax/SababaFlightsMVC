package view;

import controller.AuthenticationController;

import java.util.Scanner;

public class SignUpForm {

    private AuthenticationController authController;

    public SignUpForm(){

        this.authController = new AuthenticationController();
    }

    public void signUp() {
        long id;
        boolean validFlag;
        boolean passwordRequirements=true;
        String username;
        String password;
        String email;
        String birthDate;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your sign up details:");

        //username validation
        do{
            System.out.println("username: ");
            username = scanner.nextLine();
            validFlag = this.authController.usernameValidation(username);
//            if(!validFlag)
//                System.out.println("The username is not valid. please try again");
        }    while(!validFlag) ;

        //password validation
        do{
            System.out.println("Password:");
            if(passwordRequirements){
                System.out.println(" (Password must consist at least one english letter" +
                        ", one digit and length of 8-32 characters)");
                passwordRequirements = false;
            }

            password = scanner.nextLine();
            validFlag = this.authController.passwordValidation(password);
//            if(!validFlag)
//                System.out.println("The pass is not valid. please try again");
        }    while(!validFlag) ;

        //email validation
        do{
            System.out.println("Email: ");
            email = scanner.nextLine();
            validFlag = this.authController.emailValidation(email);
            if(!validFlag)
                System.out.println("The email is not valid. please try again");

        }    while(!validFlag) ;

        System.out.println("Just a few more details");
        System.out.println("First name:");
        String first_name = scanner.nextLine();
        System.out.println("Last name: ");
        String last_name = scanner.nextLine();
        System.out.println("Id: ");
        String idStr = scanner.nextLine();
        id = Long.parseLong(idStr);

        //Birthday validation
        do{
            System.out.println("Birthday: ");
            birthDate = scanner.nextLine();
            validFlag = this.authController.birthdayValidation(birthDate);
            if(!validFlag)
                System.out.println("The Date is not valid. please try again");
        }    while(!validFlag) ;

        boolean signUpFlag = this.authController.agentSignUp(first_name, last_name, id, email, birthDate, false, username, password);
        if(signUpFlag){
            System.out.println("Sign up successfully");
        }
    }


}
