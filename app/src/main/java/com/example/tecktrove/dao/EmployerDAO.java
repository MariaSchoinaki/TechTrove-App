package com.example.tecktrove.dao;

import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.Employer;
import java.util.ArrayList;

public interface EmployerDAO {

    /**
     * Stores an employer if they don't exist in the dao
     *
     * @param entity    the employer object
     */
    void save(Employer entity);

    /**
     * Returns a new ArrayList with all the employers in the dao
     *
     * @return      an ArrayList of employer objects
     */
    ArrayList<Employer> findAll();

    /**
     * Finds an employer based on the username and the password
     *
     * @param username      the username of the employer as a String
     * @param password      the password of the employer as a String
     * @return              an employer if it exists or null
     */
    Employer findEmployerByUsernameAndPassword(String username, String password);

    /**
     * Finds an employer based on the username
     *
     * @param username the username
     * @return  an Employer object or null
     */
    Employer findEmployerByUsername(String username);

    /**
     * Finds an employer based on the employer id
     *
     * @param       id the id of the employer
     * @return      an employer if it exists or null
     */
    Employer findEmployerByID(int id);

    /**
     * Deletes an employer
     *
     * @param entity    the employer object
     */
    void delete(Employer entity);

    /**
     * Deletes all the employers in the dao
     */
    void deleteAll();

    /**
     * Return the next available id that can be used for an employer
     *
     * @return the id for the employer
     */
    int nextId();
}
