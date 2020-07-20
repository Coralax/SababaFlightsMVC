package view;

import controller.AuthenticationController;
import controller.OrderController;
import model.objects.*;
import model.filemanager.*;

import java.util.*;

public class SababaFlightsProgram {

    private AuthenticationController authController;
    private OrderController orderController;
    private SearchView sabbaSearch;
    private OrderView orderView;
    private EditDataView editDataView;
    private SignUpView signUpForm;

    public SababaFlightsProgram() {
        this.authController = new AuthenticationController();
        this.orderController = new OrderController();
        this.sabbaSearch = new SearchView(this);
        this.signUpForm = new SignUpView();
        this.orderView = new OrderView(this);
        this.editDataView=new EditDataView(this);
     }

    public void loginScreen(){
        String op;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Welcome to SababaFlight! ");
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
                        System.out.println("Good bye!");
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
            Agent loggedInAgent = LoginSingleton.getInstance().getLoggedInAgent();
            System.out.println("\n"+"Welcome " + loggedInAgent.getFirstName() + " ,what would you like to do?");
            System.out.println("1: Search a Flight ");
            System.out.println("2: Orders ");
            System.out.println("3: Set currency");

            if(loggedInAgent.getPermissionLevel()==10){
                System.out.println("4: Edit system data");
            }
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
                        System.out.print("Please choose USD or ILS: ");
                        String currencyInput = scanner.nextLine();
                        if (currencyInput.toLowerCase().equals("usd")) {
                            FlightFileManager.getInstance().setCurrency(0);
                        } else if (currencyInput.toLowerCase().equals("ils")) {
                            FlightFileManager.getInstance().setCurrency(1);
                        } else {
                            System.out.println("Please choose one of the options (USD/ILS)");
                        }
                        break;
                    case "4":
                        if(loggedInAgent.getPermissionLevel()==10)
                            editDataView.showData();
                        else
                            this.homePage();
                        break;
                    case "0":
                        LoginSingleton.getInstance().logOut();
                        System.out.println("Logged out successfully!"+"\n");
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
            System.out.print("Username: ");
            String userName = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            boolean login = authController.login(userName, password);
            if (login) {
                this.homePage();
            } else {
                this.login();
            }
            System.out.print("Login status: " + login);
        }
    }

}

