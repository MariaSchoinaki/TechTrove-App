package com.example.tecktrove.domain;

import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;

public class Employer extends User{

    private int employerID;

    public Employer(){}

    /**
     * Constructor of the Employer
     *
     * @param id            the employer id as an integer
     * @param username      the username of the employer
     * @param password      the password of the employer
     * @param firstName     the name of the employer
     * @param lastName      the surname of the employer
     * @param email         the email address of the employer
     * @param telephone     the phone number of the employer
     * @param empID         the employer id
     */
    public Employer(int id,String username, String password, String firstName, String lastName, int empID, Email email, Telephone telephone){
        super(id, username,password,firstName,lastName, email, telephone);
        this.employerID = empID;
    }

    /**
     * Sets the employer id
     *
     * @param employerID   the employer id
     */
    public void setEmployerID(int employerID) {
        this.employerID = employerID;
    }

    /**
     * Gets the employer id
     *
     * @return  the employer id
     */
    public int getEmployerID() {
        return employerID;
    }

    /**
     * Compare an Employer with another object.
     * If they have the same id as users objects,
     * they are the same
     *
     * @param other another object
     */
    @Override
    public boolean equals(Object other) {

        if (other == null){
            return false;
        }
        if (this == other){
            return true;
        }
        if (!(other instanceof Employer)){
            return false;
        }
        Employer emp = (Employer) other;
        return this.getId() == emp.getId();
    }
}
