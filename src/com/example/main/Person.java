package com.example.main;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Pattern;


/*Need to do:
* 1. A method to validate that an ID is a unique identifier and no other person exists with the same ID
* 2. A method to validate that an email address is not already taken by another person
*
* Question: Where should we put all validation methods? what part of the MVC?
*
* */


public abstract class Person implements Serializable {

    protected String firstName;
    protected String lastName;
    protected long id;
    protected String email;
    protected String birthDateString;

    public Person(String firstName,String lastName,long id,  String email, String birthDateString) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id=id;
        if(!(validateJavaDate(birthDateString)))
            throw new IllegalArgumentException("Invalid date of birth");
        if(!(isValidEmail(email)))
            throw new IllegalArgumentException("Invalid email address");
        else {
            this.birthDateString = birthDateString;
            this.email = email;
        }
    }

    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public String getEmail() { return this.email; }
    public String getBirthDateString() { return this.birthDateString; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setBirthDateString(String birthDateString) { this.birthDateString = birthDateString; }

    public static boolean validateJavaDate(String strDate)
    {
        /* Check if date is 'null' */
        if (strDate.trim().equals(""))
        {
            System.out.println("Empty Date string");
            return false;
        }
        /* Date is not 'null' */
        else
        {
            /*
             * Set preferred date format,
             * In our example: dd.MM.yyyy */
            SimpleDateFormat strFormat = new SimpleDateFormat("dd/MM/yyyy");
            strFormat.setLenient(false);
            /* Create Date object
             * parse the string into date
             */
            try
            {
                Date javaDate = strFormat.parse(strDate);
           }
            /* Date format is invalid */
            catch (ParseException e)
            {
             return false;
            }
            /* Return true if date format is valid */
            return true;
        }
    }
    public static boolean isValidEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    @Override
    public String toString() {
        return("\n" +"Person details are: " +" \n" +
                "First name: " + firstName +"\n" +
                "Last name: " + lastName + "\n" +
                "ID: " + id + "\n" +
                "Email: " + email + "\n" +
                "Date of birth: " + birthDateString + "\n");
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
