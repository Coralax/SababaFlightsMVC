package model.objects;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


/*Need to do:
* 1. A method to validate that an ID is a unique identifier and no other person exists with the same ID
* 2. A method to validate that an email address is not already taken by another person
*
* */


public abstract class Person {

    protected String firstName;
    protected String lastName;
    protected long id;
    protected String email;
    protected String birthDateStr;
    protected LocalDate birthDate;

    public Person() {}

    public Person(String firstName, String lastName, String email, long id, String birthDateStr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = id;
        setBirthDate(birthDateStr);
    }

    public String getBirthDateStr() { return this.birthDateStr; }
    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public String getEmail() { return this.email; }
    public LocalDate getBirthDate() { return this.birthDate; }
    public long getId() { return this.id; }
    public void setBirthDateStr(String birthDateStr) { this.birthDateStr = birthDateStr; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }

    public void setBirthDate(String birthDateStr)  {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        formatter.parse(birthDateStr);
        this.birthDate = LocalDate.parse(birthDateStr, formatter);
    }
    public void setId(long id) { this.id = id; }

    @Override
    public String toString() {
        return
                "First name: " + firstName +"\n" +
                "Last name: " + lastName + "\n" +
                "ID: " + id + "\n" +
                "Email: " + email + "\n" +
                "Date of birth: " + birthDate + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
