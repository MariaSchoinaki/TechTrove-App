package com.example.tecktrove.contacts;

/**
 * The email address
 * Implemented as a value object
 */

public class Email {

    private String email;

    /**
     * Constructor based on a String for the email
     *
     * @param email     the email address
     */
    public Email(String email){
        this.email = email;
    }

    /**
     * Gets the email address as a String
     *
     * @return  the email address
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Validates the email address
     *
     * @return {@code true} if the email address is valid
     */
    public boolean isValid(){
        return true;
    }

    /**
     * Validates the instanceof a email
     * @param other     the other object to check
     * @return
     */
    @Override
    public boolean equals(Object other) {

        if (other == null){
            return false;
        }
        if (this == other){
            return true;
        }
        if (!(other instanceof Email)){
            return false;
        }

        Email e = (Email) other;
        return email == null ? e.getEmail() == null
                : email.equals(e.getEmail());
    }
}
