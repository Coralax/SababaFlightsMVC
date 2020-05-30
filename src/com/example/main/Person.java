package com.example.main;

import lombok.Builder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Builder // first design pattern
public class Person {
    private String firstName;
    private String lastName;
    private long id;
    private String email;
    private String birthDateString;


    public Person(String firstName,String lastName,long id,  String email, String birthDateString) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id=id;
        if(validateJavaDate(birthDateString))
            this.birthDateString = birthDateString;

    }

    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public String getEmail() { return this.email; }
    public String getBirthDateString() { return this.birthDateString; }
    // TODO: getBirthDate() which returns a Date object

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setBirthDateString(String birthDateString) { this.birthDateString = birthDateString; }


    @Override
    public String toString() {
        return "Person name: "+firstName + " " +lastName +"  email: "+email + " birthday: "+ birthDateString ;
    }

    public static boolean validateJavaDate(String strDate)
    {
        /* Check if date is 'null' */
        if (strDate.trim().equals(""))
        {
            return true;
        }
        /* Date is not 'null' */
        else
        {
            /*
             * Set preferred date format,
             * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
            SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
            sdfrmt.setLenient(false);
            /* Create Date object
             * parse the string into date
             */
            try
            {
                Date javaDate = sdfrmt.parse(strDate);
                System.out.println(strDate+" is valid date format");
            }
            /* Date format is invalid */
            catch (ParseException e)
            {
                System.out.println(strDate+" is Invalid Date format");
                return false;
            }
            /* Return true if date format is valid */
            return true;
        }
    }

}
