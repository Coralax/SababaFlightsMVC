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

    public SababaFlightsProgram() {
        this.authController = new AuthenticationController();
        this.orderController = new OrderController();
        this.sabbaSearch = new SababaSearch(this);
        this.orderView = new SababaOrderView(this);
     }

    public void startProgram() {
        /*CLI options*/

        Set<Agent> agents = AgentSingleton.getInstance().agentSet;
        Set<AircraftCompany> aircraftCompanies = AircraftCompanySingleton.getInstance().aircraftCompanySet;
        Set<Airport> airports = AirportSingleton.getInstance().airportSet;
        Set<Flight> flights = FlightSingleton.getInstance().flightSet;
        Set<Passenger> passengers = PassengerSingleton.getInstance().passengerSet;
        Set<Order> orders = OrderSingleton.getInstance().orderSet;

//        for (Order order : orders) {
//            System.out.println(order.getOtherPassengers().size());
//        }

        Iterator<AircraftCompany> aircraftCompanyIterator = aircraftCompanies.iterator();
        Iterator<Flight> flightIterator = flights.iterator();
        Iterator<Passenger> passengerIterator = passengers.iterator();
        AircraftCompany aircraftCompany = aircraftCompanyIterator.next();
        List<Flight> flight = new ArrayList<>();
        flight.add(flightIterator.next());

        System.out.println(OrderSingleton.getInstance().orderSet.size());

        this.loginScreen();

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
                        this.SignUp();
                        break;
                    case "-1":
                        break;
                    default:
                        LoginSingleton.getInstance().logOut();
                        this.loginScreen();
                        System.exit(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }while (!op.equals("-1"));
    }


    public void SignUp() {
        //(String firstName, String lastName, long id, String email, LocalDate birthDate,
        // boolean enabled , String userName, String password) throws IOException {
        long id;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your sign up details:\n first name:");
        String first_name = scanner.nextLine();
        System.out.println("last name: ");
        String last_name = scanner.nextLine();
        System.out.println("id: ");
        Scanner sc = new Scanner(System.in);
        String idStr = sc.next();
        id = Long.parseLong(idStr);

        System.out.println("email: ");
        String email = scanner.nextLine();

        System.out.println("birthday: ");
        String birthDate = scanner.nextLine();

        System.out.println("username: ");
        String username = scanner.nextLine();
        System.out.println("password:");
        String password = scanner.nextLine();

        boolean signUpFlag = this.authController.agentSignUp(first_name, last_name, id, email, birthDate, false, username, password);
        System.out.println("signUpFlag");
        if(signUpFlag){
            System.out.println("Sign up successfully");
        }
    }



    public void homePage(){
        String op;
        Scanner scanner = new Scanner(System.in);
        do {
            Agent loggedInAgent = LoginSingleton.getInstance().loggedInAgent;
            System.out.println("Welcome " + loggedInAgent.getFirstName() + " ,what would you like to do?");
            System.out.println("1: Search a Flight ");
            System.out.println("2: Orders ");
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
                    case "0":
                        LoginSingleton.getInstance().logOut();
                        this.loginScreen();
                        break;
                    case "-1":
                        LoginSingleton.getInstance().logOut();
                        System.exit(0);
                        break;
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

