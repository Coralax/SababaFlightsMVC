package model.builders;
import model.objects.Passenger;
import java.time.LocalDate;

public class PassengerBuilder {
    private String firstName, lastName, email, passport;
    private boolean hasSuitcase, hasMeals;
    private long id;
    private LocalDate birthDate;

    public PassengerBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PassengerBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PassengerBuilder email(String email) {
        this.email = email;
        return this;
    }

    public PassengerBuilder passport(String passport) {
        this.passport = passport;
        return this;
    }

    public PassengerBuilder hasSuitcase(boolean hasSuitcase) {
        this.hasSuitcase = hasSuitcase;
        return this;
    }

    public PassengerBuilder hasMeals(boolean hasMeals) {
        this.hasMeals = hasMeals;
        return this;
    }

    public PassengerBuilder id(long id) {
        this.id = id;
        return this;
    }

    public PassengerBuilder birthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public Passenger build() {
        Passenger passenger = new Passenger();
        passenger.setFirstName(this.firstName);
        passenger.setLastName(this.lastName);
        passenger.setEmail(this.email);
        passenger.setPassport(this.passport);
        passenger.setHasSuitcase(this.hasSuitcase);
        passenger.setHasMeals(this.hasMeals);
        passenger.setId(this.id);
        passenger.setBirthDate(this.birthDate);
        return passenger;
    }
}
