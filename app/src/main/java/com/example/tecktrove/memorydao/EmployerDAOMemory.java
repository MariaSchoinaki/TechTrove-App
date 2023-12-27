package com.example.tecktrove.memorydao;

import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.Employer;
import com.example.tecktrove.dao.EmployerDAO;
import java.util.ArrayList;

public class EmployerDAOMemory implements EmployerDAO{

    protected static ArrayList<Employer> employers = new ArrayList<>();

    /**
     * Get a List of all employers
     *
     * @return      a list of employer objects
     */
    @Override
    public ArrayList<Employer> findAll() {
        return new ArrayList<>(employers);
    }

    /**
     * Get an employer based on the username and the password
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
     *Get an employer based on the employer id
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
     * Save the employer if they don't exist in the dao
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
     * Delete the employer if they don't exist in the dao
     *
     * @param entity    the employer object
     */
    @Override
    public void delete(Employer entity) {
        employers.remove(entity);
    }

    /**
     * Delete all the employers in the dao
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
