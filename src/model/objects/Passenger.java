package model.objects;

import java.util.Objects;

public class Passenger extends Person {
    private String passport;
    private boolean suitcase, meals;

    public Passenger() { super(); }

    public Passenger(
            String firstName,
            String lastName,
            long id,
            String email,
            String birthDateStr,
            String passport,
            boolean hasSuitcase,
            boolean hasMeals
        ) {
        super(firstName, lastName, email, id, birthDateStr);
        this.passport = passport;
        this.suitcase = hasSuitcase;
        this.meals = hasMeals;
    }

    // Setters (which will be used by the builder)
    public void setPassport(String passport) {
        this.passport = passport;
    }
    public void setHasSuitcase(boolean suitcase) {
        this.suitcase = suitcase;
    }
    public void setHasMeals(boolean meals) {
        this.meals = meals;
    }

    // Getters
    public String getPassport() {
        return this.passport;
    }
    public boolean isSuitcase() {
        return this.suitcase;
    }
    public boolean isMeals() {
        return this.meals;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"+
                " Passport='" + passport + "\n" +
                " Has suitcase=" + suitcase + "\n" +
                " Has meals=" + meals + "\n" ;
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
