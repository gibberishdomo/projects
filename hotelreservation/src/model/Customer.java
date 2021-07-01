package model;

import java.util.regex.Pattern;

public class Customer {

    String firstName;
    String lastName;
    String email;
    private final String  emailRegex = "^(.+)@(.+).(.+)$";
    private final Pattern pattern = Pattern.compile(emailRegex);

    public Customer(String firstName, String lastName, String email) {
        if(!pattern.matcher(email).matches()){
            throw new IllegalArgumentException("Error, Invalid email");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;


    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
       lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email;
    }

    public int hashcode() {return super.hashCode();}
    public boolean equals(Object obj) {return super.equals(obj);}

    @Override
    public String toString() {return "Name:" + firstName  + lastName + ", " + email;}
}
