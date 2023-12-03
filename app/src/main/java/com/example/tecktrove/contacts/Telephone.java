package com.example.tecktrove.contacts;


/**
 * Telephone Number
 * Implemented as a value object
 */
public class Telephone {

    private String telephone;

    /**
     * Constructor based on a String
     *
     * @param tel       the telephone number
     */
    public Telephone(String tel){
        this.telephone = tel;
    }

    /**
     * Gets the telephone number as a String
     *
     * @return  the telephone number
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Validates the phone number
     *
     * @return {@code true} if the phone number is valid
     */
    public boolean isValid(){
        return true;
    }

    /**
     * Validates the instanceof a telephone
     * @param other     the other object to check
     * @return
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (this == other) {
            return true;
        }

        if (!(other instanceof Telephone)) {
            return false;
        }

        Telephone tel = (Telephone) other;
        return telephone == null
                ? tel.getTelephone() == null
                : telephone.equals(tel.getTelephone());
    }
}
