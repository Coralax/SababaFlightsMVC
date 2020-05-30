package com.example.main;

public class Passenger extends Person{
    private String passport;
    private boolean suitcase, meals;

    public Passenger(String firstName, String lastName, long id, String email, String birthDateString, String passport, boolean suitcase, boolean meals) {
        super(firstName, lastName, id, email, birthDateString);
        this.passport = passport;
        this.suitcase = suitcase;
        this.meals = meals;
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
}
