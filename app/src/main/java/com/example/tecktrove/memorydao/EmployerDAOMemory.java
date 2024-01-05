package com.example.tecktrove.memorydao;

import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.Employer;
import com.example.tecktrove.dao.EmployerDAO;
import java.util.ArrayList;

public class EmployerDAOMemory implements EmployerDAO{

    protected static ArrayList<Employer> employers = new ArrayList<>();

    /**
     * Stores an employer if they don't exist in the dao
     *
     * @param entity    the employer object
     */
    @Override
    public void save(Employer entity) {
        if (!employers.contains(entity)){
            employers.add(entity);
        }
    }

    /**
     * Returns a new ArrayList with all the employers in the dao
     *
     * @return      an ArrayList of employer objects
     */
    @Override
    public ArrayList<Employer> findAll() {
        return new ArrayList<>(employers);
    }

    /**
     * Finds an employer based on the username and the password
     *
     * @param username      the username of the employer as a String
     * @param password      the password of the employer as a String
     * @return              an employer if it exists or null
     */
    @Override
    public Employer findEmployerByUsernameAndPassword(String username, String password){
        for (Employer employer: employers){
            if (employer.getUsername().equals(username) && employer.getPassword().equals(password)){
                return employer;
            }
        }
        return null;
    }

    /**
     * Finds an employer based on the username
     *
     * @param username the username
     * @return  an Employer object or null
     */
    @Override
    public Employer findEmployerByUsername(String username) {
        for (Employer employer: employers){
            if (employer.getUsername().equals(username)){
                return employer;
            }
        }
        return null;
    }

    /**
     * Finds an employer based on the employer id
     *
     * @param       id the id of the employer
     * @return      an employer if it exists or null
     */
    @Override
    public Employer findEmployerByID(int id){
        for (Employer employer: employers){
            if (employer.getId() == id){
                return employer;
            }
        }
        return null;
    }

    /**
     * Deletes an employer
     *
     * @param entity    the employer object
     */
    @Override
    public void delete(Employer entity) {
        employers.remove(entity);
    }

    /**
     * Deletes all the employers in the dao
     */
    @Override
    public void deleteAll(){
        employers.clear();
    }

    /**
     * Return the next available id that can be used for an employer
     *
     * @return the id for the employer
     */
    @Override
    public int nextId() {
        return (employers.size() > 0 ? employers.get(employers.size()-1).getId()+1 : 1);
    }
}
