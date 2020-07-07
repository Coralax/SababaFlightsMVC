package view;

import controller.AuthenticationController;
import controller.OrderController;
import model.objects.*;
import model.singletons.*;

import java.util.*;

public class SababaFlightsProgram {

    private AuthenticationController authController;
    private OrderController orderController;
    private SababaSearch sabbaSearch;
    private SababaOrderView orderView;

    private SignUpForm signUpForm;

    public SababaFlightsProgram() {
        this.authController = new AuthenticationController();
        this.orderController = new OrderController();
        this.sabbaSearch = new SababaSearch();
        this.signUpForm = new SignUpForm();
        this.orderView = new SababaOrderView(this);
     }

    public void loginScreen(){
        String op;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Welcome to SababaFlight: ");
            System.out.println("1: Log in ");
            System.out.println("2: Sign up ");
            System.out.println("-1: Exit ");
            op = scanner.nextLine();
            try {
                switch (op) {
                    case "1":
                        this.login();
                        break;
                    case "2":
                        this.signUpForm.signUp();
                        break;
                    case "-1":
                        LoginSingleton.getInstance().logOut();
                        this.loginScreen();
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }while (!op.equals("-1"));
    }

    public void homePage(){
        String op;
        Scanner scanner = new Scanner(System.in);
        Aircraft aircraft = new Aircraft(0,78,"Model");
        do {
            Agent loggedInAgent = LoginSingleton.getInstance().loggedInAgent;
            System.out.println("Welcome " + loggedInAgent.getFirstName() + " ,what would you like to do?");
            System.out.println("1: Search a Flight ");
            System.out.println("2: Orders ");
            System.out.println("3: Set currency");
            System.out.println("0: Logout");
            System.out.println("-1: Exit ");
            op = scanner.nextLine();
            try {
                switch (op) {
                    case "1":
                        sabbaSearch.search();
                        break;
                    case "2":
                        orderView.orderScreen();
                        break;
                    case "3":
                        System.out.println("Please choose USD or ILS");
                        String currencyInput = scanner.nextLine();
                        if (currencyInput.toLowerCase().equals("usd")) {
                            FlightSingleton.getInstance().setCurrency(0);
                        } else if (currencyInput.toLowerCase().equals("ils")) {
                            FlightSingleton.getInstance().setCurrency(1);
                        } else {
                            System.out.println("Please choose one of the options (USD/ILS)");
                        }
                        break;
                    case "0":
                        LoginSingleton.getInstance().logOut();
                        this.loginScreen();
                        break;
                    case "-1":
                        LoginSingleton.getInstance().logOut();
                        System.exit(0);
                        break;
                    default:
                        this.homePage();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        } while (!op.equals("-1"));
    }

    public void login() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Username: ");
            String userName = scanner.nextLine();
            System.out.println("Password: ");
            String password = scanner.nextLine();
            boolean login = authController.login(userName, password);
            if (login) {
                this.homePage();
            } else {
                this.login();
            }
            System.out.println("Login status: " + login);
        }
    }

}

