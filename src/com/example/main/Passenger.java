package com.example.main;


import java.util.Objects;

public class Passenger extends Person{
    private String passport;
    private boolean suitcase, meals;


    public Passenger( String firstName,String lastName,long id,  String email, String birthDateString,String passport, boolean suitcase, boolean meals) {
        super(firstName, lastName, id, email, birthDateString);
        this.suitcase = suitcase;
        this.meals = meals;
        if(!passportValidation(passport))
            throw new IllegalArgumentException("");
        else
            this.passport = passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setSuitcase(boolean suitcase) {
        this.suitcase = suitcase;
    }

    public void setMeals(boolean meals) {
        this.meals = meals;
    }
    public String getPassport() {
        return passport;
    }

    public boolean isSuitcase() {
        return suitcase;
    }

    public boolean isMeals() {
        return meals;
    }

    private static boolean passportValidation(String passport) {
        if (!(passport.matches("[A-Za-z0-9_]+")) ) {
            System.out.println("Passport must consist of English alphanumeric characters and digits only!");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Passenger additional information: " + "\n" +
                "Passport: " + passport + "\n" +
                "Suitcase: " + suitcase + "\n" +
                "Plane meal: " + meals + "\n" ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(passport, passenger.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passport);
    }
}
