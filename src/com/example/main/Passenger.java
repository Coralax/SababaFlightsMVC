package com.example.main;

public class Passenger extends Person {
    private string passport;
    private boolean suitcase, meals;

    public Passenger(string passport, boolean suitcase, boolean meals){
        super(firstName, lastName, email, birthDateString);
        this.passport = passport;
        this.suitcase = suitcase;
        this.meals = meals;
    }

    public boolean isMeals() { return meals; }
    public boolean isSuitcase() { return suitcase; }
    public string getPassport() { return passport; }

    public void setMeals(boolean meals) { this.meals = meals; }
    public void setPassport(string passport) { this.passport = passport; }
    public void setSuitcase(boolean suitcase) { this.suitcase = suitcase; }
}
