package com.example.tecktrove.domain;

import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;

public class Employer extends User{



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

     */
    public Employer(int id,String username, String password, String firstName, String lastName, Email email, Telephone telephone){
        super(id, username,password,firstName,lastName, email, telephone);

    }




    /**
     * Compare an Employer with another object.
     * If they have the same id as users objects,
     * they are the same
     *
     * @param other another object
     */

}
