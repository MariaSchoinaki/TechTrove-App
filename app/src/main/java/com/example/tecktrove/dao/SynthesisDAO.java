package com.example.tecktrove.dao;

import com.example.tecktrove.domain.Synthesis;
import com.example.tecktrove.dao.SynthesisDAO;
import java.util.ArrayList;

public interface SynthesisDAO {
    /**
     * Function that returns the
     * entire synthesis list
     *
     * @return  the NR
     */
    ArrayList<Synthesis>findAll();
    /**
     * Function that returns all
     * the synthesis witch has
     * the given number of ratings defined
     * by the user
     *
     * @return  the NR
     */
    ArrayList<Synthesis>findAllByNumberOfRatings(int number);
    /**
     * Function that returns all
     * the synthesis witch has
     * the given rating defined
     * by the user
     *
     * @return  the R
     */
    ArrayList<Synthesis>findAllByRating(Double number);
    /**
     * Function that deletes
     * the synthesis list
     */
    void deleteAll();
    /**
     * Function that delete
     * given synthesis
     */
    void delete(Synthesis entity);
    /**
     * Function that delete
     * all the synthesis by
     * the given rating
     */
    void deleteAllByRating(Double number);
    /**
     Save the current synthsesis
     */
    void save(Synthesis entity);


}
