package com.example.tecktrove.domain;

import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;


public class User {
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    private Email email;
    private Telephone telephone;

    /**
     * Default Constructor
     */
    public User(){}

    /**
     * Constructor of User
     *
     * @param id        the id of the user as integer
     * @param username  the username of user
     * @param password  the password of user
     * @param firstName the name of the user
     * @param lastName  the surname of the user
     * @param email     the email address of the user
     * @param telephone the phone number of the user
     */

    public User(int id, String username, String password, String firstName, String lastName, Email email, Telephone telephone){
        this.id = id;
        this.firstName = firstName;
        this.password = password;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.telephone = telephone;
    }

    /**
     * Sets the id of the user
     *
     * @param id    the user id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the id of the user
     *
     * @return the user id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the Username of the user
     *
     * @param username  the username of the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the username of the user
     *
     * @return  the username of the user
     */
    public String getUsername() {
         return this.username;
    }

    /**
     * Sets the password of the user
     *
     * @param password the password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the password of the user
     *
     * @return the password of the user
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets the first name of the user
     *
     * @param name the first name of the user
     */
    public void setName(String name) {
        this.firstName = name;
    }

    /**
     * Gets the first name of the user
     *
     * @return the first name of the user
     */
    public String getName() {
        return this.firstName;
    }

    /**
     * Sets the last name of the user
     *
     * @param lastName  the last name of the user
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the last name of the user
     *
     * @return  the last name of the user
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the email of the user
     *
     * @param email     the email address of the user
     */
    public void setEmail(Email email) {
        this.email = email;
    }

    /**
     * Gets the email address of the user
     *
     * @return   the email address of the user
     */
    public Email getEmail() {
        return this.email;
    }

    /**
     * Sets the telephone number of the user
     *
     * @param telephone the telephone number of the user
     */
    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }

    /**
     * Gets the telephone number of the user
     *
     * @return  the telephone number of the user
     */
    public Telephone getTelephone() {
        return this.telephone;
    }

    /**
     * Returns {@code true} if an object is equals
     * with the object User
     *
     * @param other the other object
     * @return  true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object other) {

        if (other == null){
            return false;
        }
        if (this == other){
            return true;
        }
        if (!(other instanceof User)){
            return false;
        }
        User user = (User) other;
        return this.getId() == user.getId();
    }
}
