package com.example.main;

public class Passenger extends Person {
    private String passport;
    private boolean suitcase, meals;

    public Passenger(String passport, boolean suitcase, boolean meals){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setBirthDateString(birthDateString);
        this.passport = passport;
        this.suitcase = suitcase;
        this.meals = meals;
    }

    public boolean isMeals() { return meals; }
    public boolean isSuitcase() { return suitcase; }
    public String getPassport() { return passport; }

    public void setMeals(boolean meals) { this.meals = meals; }
    public void setPassport(String passport) { this.passport = passport; }
    public void setSuitcase(boolean suitcase) { this.suitcase = suitcase; }
}
