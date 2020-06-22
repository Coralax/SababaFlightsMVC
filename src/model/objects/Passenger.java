package model.objects;

import java.util.Objects;

public class Passenger extends Person {
    private String passport;
    private boolean hasSuitcase, hasMeals;


    // Setters (which will be used by the builder)
    public void setPassport(String passport) {
        this.passport = passport;
    }
    public void setHasSuitcase(boolean suitcase) {
        this.hasSuitcase = suitcase;
    }
    public void setHasMeals(boolean meals) {
        this.hasMeals = meals;
    }

    // Getters
    public String getPassport() {
        return this.passport;
    }
    public boolean isSuitcase() {
        return this.hasSuitcase;
    }
    public boolean isMeals() {
        return this.hasMeals;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"+
                " Passport='" + passport + "\n" +
                " Has suitcase=" + hasSuitcase + "\n" +
                " Has meals=" + hasMeals + "\n" ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(passport, passenger.passport);
    }

}
