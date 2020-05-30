package com.example.main;


public class Passenger extends Person{
    private String passport;
    private boolean suitcase, meals;


    public Passenger(Person pr, String passport, boolean suitcase, boolean meals) {
        super(pr.firstName, pr.lastName, pr.id, pr.email, pr.birthDateString);
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
}
