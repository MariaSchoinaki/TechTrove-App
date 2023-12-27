package com.example.tecktrove.dao;

import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.Employer;
import java.util.ArrayList;

public interface EmployerDAO {

    /**
     * Get an employer based on the username and the password
     *
     * @param username      the username of the employer as a String
     * @param password      the password of the employer as a String
     * @return              an employer if it exists or null
     */
    Employer findEmployerByUsernameAndPassword(String username, String password);

    public Employer findEmployerByUsername(String username);

    /**
     *Get an employer based on the employer id
     *
     * @param       id the id of the employer
     * @return      an employer if it exists or null
     */
    Employer findEmployerByID(int id);

    /**
     * Get a List of all employers
     *
     * @return      a list of employer objects
     */
    ArrayList<Employer> findAll();

    /**
     * Save the employer if they don't exist in the dao
     *
     * @param entity    the employer object
     */
    void save(Employer entity);

    /**
     * Delete the employer if they don't exist in the dao
     *
     * @param entity    the employer object
     */
    void delete(Employer entity);

    /**
     * Delete all the employers in the dao
     */
    void deleteAll();

    /**
     * Return the next available id that can be used for an employer
     *
     * @return the id for the employer
     */
    int nextId();
}
