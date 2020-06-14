package model.objects;


import java.time.LocalDate;
import java.util.Objects;

public class Passenger extends Person {
    private String passport;
    private boolean suitcase, meals;

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
