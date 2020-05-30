package com.example.main;

public class Main {
    public static void main(String[] args) {

        //Runs as expected and prints
        Person pr3 = new Person("Danny", "Cohen", 11111, "dannycohen@gmail.com", "01/12/1993");
        System.out.println(pr3.toString());

        //Throws an exception for invalid birth of date string as expected
        /*Person pr = new Person("Danny", "Cohen", 11111, "dannycohen@gmail.com", "01/13/1993");
        System.out.println(pr.toString());*/

            // The following throws an exception for invalid email address as expected
      /*  Person pr2 = new Person("Danny", "Cohen", 11111, "dannycohen@gmail..com", "01/12/1993");
        System.out.println(pr2.toString());*/

        //Enabled = false, throws an exception as expected
        /*Agent agent1 = new Agent("dan", "cohen",12121,"dann@gmail.com", "01/12/1993", false,"abdababa", "23231");
        System.out.println(agent1.toString());*/

        //Short user name/ digits only throws an exception as expected
        /*Agent agent2 = new Agent("dan", "cohen",12121,"dann@gmail.com", "01/12/1993", true,"3231", "23231333f");
        System.out.println(agent2.toString());*/

        //Bad password throws an exception as expected
        /*Agent agent3 = new Agent("dan", "cohen",12121,"dann@gmail.com", "01/12/1993", true,"aaaddd", "cczzzzzz");
        System.out.println(agent3.toString());*/


        //Runs as expected and prints
       /* Agent agent3 = new Agent(new Person("coral", "ifergan",12121,"coral@gmail.com", "01/12/1993"), true,"aaaddd", "1cczzzzzz");
        System.out.println(agent3.toString());*/

        Agent agent4 = new Agent(pr3, true,"aaaddd", "1cczzzzzz");
        System.out.println(agent4.toString());

    }

}