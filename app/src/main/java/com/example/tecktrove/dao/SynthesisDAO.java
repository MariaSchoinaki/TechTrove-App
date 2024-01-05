package com.example.tecktrove.dao;

import com.example.tecktrove.domain.Synthesis;
import com.example.tecktrove.dao.SynthesisDAO;
import java.util.ArrayList;

public interface SynthesisDAO {

    /**
     * Stores a synthesis in the dao
     *
     * @param entity a Synthesis object
     */
    void save(Synthesis entity);

    /**
     * Returns a new ArrayList of all
     * the synthesis in the dao
     *
     * @return  an ArrayList of Synthesis objects
     */
    ArrayList<Synthesis>findAll();

    /**
     * Finds all the synthesis which have
     * a specific number of rates
     *
     * @param number    the number of rates
     * @return an ArrayList of Synthesis Objects
     */
    ArrayList<Synthesis>findAllByNumberOfRatings(int number);

    /**
     * Finds all the synthesis which have a specific
     * rating
     *
     * @param number    the rating
     * @return  an ArrayList of Synthesis Objects
     */
    ArrayList<Synthesis>findAllByRating(Double number);

    /**
     * Finds a Synthesis based on the model number
     *
     * @param modelNo   the model number
     * @return  a Synthesis object or null
     */
    Synthesis find(int modelNo);

    /**
     * Finds a Synthesis based on its name
     *
     * @param name  the name of the synthesis
     * @return  a Synthseis object or null
     */
    Synthesis find(String name);

    /**
     * Deletes all the synthesis objects in the dao
     */
    void deleteAll();

    /**
     * Deletes the synthesis from the dao
     *
     * @param entity    a Synthesis object
     */
    void delete(Synthesis entity);

    /**
     * Deletes a synthesis by the name
     *
     * @param name  the synthesis's name
     */
    void delete(String name);

    /**
     * Deletes a synthesis by its model number
     *
     * @param modelNo   the model number
     */
    void delete(int modelNo);

    /**
     * Deletes all the synthesis in the dao by
     * the given rating
     *
     * @param rating    the rating
     */
    void deleteAllByRating(Double rating);

    /**
     * Deletes all the synthesis in the dao by
     * the number of rates
     *
     * @param number    the number of rates
     */
    void deleteAllByNumberOfRatings(int number);
}
