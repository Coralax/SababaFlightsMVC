package view;

import controller.AuthenticationController;

import java.util.Scanner;

public class SignUpFormView {

    private AuthenticationController authController;

    public SignUpFormView(){

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
        System.out.println("Welcome to sign up page!"+"\n");

        //username validation
        do{
            System.out.println("User name: ");
            username = scanner.nextLine();
            validFlag = this.authController.usernameValidation(username);
//            if(!validFlag)
//                System.out.println("The username is not valid. please try again");
        }    while(!validFlag) ;

        //password validation
        do{
            System.out.println("Password: ");
            if(passwordRequirements){
                System.out.println(" Password must consist at least one english letter" +
                        ", one digit and length of 8-32 characters");
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
                System.out.println("Invalid email. Please try again");

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
            System.out.println("Birthday in dd/MM/yyyy format: ");
            birthDate = scanner.nextLine();
            validFlag = this.authController.birthdayValidation(birthDate);
            if(!validFlag)
                System.out.println("Invalid birth date string. Please try again");
        }    while(!validFlag) ;

        boolean signUpFlag = this.authController.agentSignUp(first_name, last_name, id, email, birthDate, false, username, password);
        if(signUpFlag){
            System.out.println("Sign up successfully!");
        }
    }


}
