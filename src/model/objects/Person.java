package model.objects;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


/*Need to do:
* 1. A method to validate that an ID is a unique identifier and no other person exists with the same ID
* 2. A method to validate that an email address is not already taken by another person
*
* */


public abstract class Person implements Serializable {

    protected String firstName;
    protected String lastName;
    protected long id;
    protected String email;
    protected LocalDate birthDate;

    public Person(String firstName,String lastName,long id,  String email, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id=id;
        this.birthDate = birthDate;
         this.email = email;
      }

    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public String getEmail() { return this.email; }
    public LocalDate getBirthDateString() { return this.birthDate; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setBirthDateString(LocalDate birthDate) { this.birthDate = birthDate; }


    @Override
    public String toString() {
        return("\n" +"Person details are: " +" \n" +
                "First name: " + firstName +"\n" +
                "Last name: " + lastName + "\n" +
                "ID: " + id + "\n" +
                "Email: " + email + "\n" +
                "Date of birth: " + birthDate + "\n");
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
     /* if(!(validateJavaDate(birthDateString)))
              throw new IllegalArgumentException("Invalid date of birth");
              if(!(isValidEmail(email)))
              throw new IllegalArgumentException("Invalid email address");*/