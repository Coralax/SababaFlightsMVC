package com.example.main;

public class Main {
    public static void main(String[] args) {


        //Enabled = false, throws an exception as expected
       /* Agent agent1 = new Agent("Dan", "Cohen",12121,"dann@gmail.com", "01/12/1993", false,"abdababa", "23231");
        System.out.println(agent1.toString());*/

        //Bad user name
      /*   Agent agent2 = new Agent("Dan", "Cohen",12121,"dann@gmail.com", "01/12/1993", true,"aaa3231", "23231333f");
       System.out.println(agent2.toString());*/

        //Bad password throws an exception as expected
        /*Agent agent3 = new Agent("Dan", "Cohen",12121,"dann@gmail.com", "01/12/1993", true,"aaaddd", "cczzzzzz");
        System.out.println(agent3.toString());*/


        //Runs as expected and prints
        /*Agent agent3 = new Agent("Coral", "Ifergan",12121,"coral@gmail.com", "01/12/1993", true,"raaaaaaddd", "1cCzzzzzz");
        System.out.println(agent3.toString());*/

       Agent agent4 = new Agent("dan", "cohen",12121,"dann@gmail.com", "01/12/1993", true,"aaaddd", "1cczzdddds");
       System.out.println(agent4.toString());

       //Bad passport throws an exception as expected
       /*Passenger ps = new Passenger("Coral", "Ifergan",12121, "coral@gmail.com","01/02/1990","בבששש",true,false);
        System.out.println(ps.toString());*/


    }

}