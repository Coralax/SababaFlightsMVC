package view;

import controller.OrderController;
import controller.SearchController;
import model.singletons.LoginSingleton;

import java.util.Scanner;

public class SababaOrderView {
    private OrderController orderController;
    public SababaFlightsProgram sababaFlightsProgram;

    public SababaOrderView(SababaFlightsProgram referer) {
        this.orderController= new OrderController();
        this.sababaFlightsProgram = referer;
    }

    public void orderScreen(){
        String op;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Welcome to order page. What would you like to do? ");
            System.out.println("1: Search order by ID ");
            System.out.println("2: Search order by Agent code");
            System.out.println("3: Search order by Passenger passport ");
            System.out.println("4: Search order by dates ");
            System.out.println("5: Add a passenger to an existing order ");
            System.out.println("6: Cancel order by order ID ");
            System.out.println("-1: Return to home page ");

            op = scanner.nextLine();
            try {
                switch (op) {
                    case "1":
                        orderController.searchByID();
                        break;
                    case "2":
                        orderController.searchByAgentCode();
                        break;
                    case "3":
                        orderController.searchByPassenger();
                        break;
                    case "4":
                        orderController.searchByDate();
                        break;
                    case "5":
                        orderController.addAPassengerToOrder();
                        break;
                    case "6":
                        orderController.cancelOrder();
                        break;
                    case "-1":
                        LoginSingleton.getInstance().logOut();
                        System.exit(0);
                        break;
                    default:
                        this.sababaFlightsProgram.homePage();
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }while (!op.equals("-1"));
    }


}
