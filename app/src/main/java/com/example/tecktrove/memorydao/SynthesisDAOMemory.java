package com.example.tecktrove.memorydao;


import com.example.tecktrove.dao.SynthesisDAO;
import com.example.tecktrove.domain.Synthesis;
import java.util.ArrayList;

public class SynthesisDAOMemory implements SynthesisDAO {
    protected static  ArrayList<Synthesis> synthesis = new ArrayList<Synthesis>();

    /**
     * Stores a synthesis in the dao
     *
     * @param entity a Synthesis object
     */
    @Override
    public void save(Synthesis entity) {
        synthesis.add(entity);
    }

    /**
     * Returns a new ArrayList of all
     * the synthesis in the dao
     *
     * @return  an ArrayList of Synthesis objects
     */
    @Override
    public ArrayList<Synthesis> findAll() {
        return new ArrayList<Synthesis>(synthesis);
    }

    /**
     * Finds all the synthesis which have
     * a specific number of rates
     *
     * @param number    the number of rates
     * @return an ArrayList of Synthesis Objects
     */
    @Override
    public ArrayList<Synthesis> findAllByNumberOfRatings(int number) {
        ArrayList<Synthesis> NR = new ArrayList<Synthesis>();
        for (Synthesis s : synthesis){
            if(s.getNumberOfRatings()==number){
                NR.add(s);
            }
        }
        return NR;
    }

    /**
     * Finds all the synthesis which have a specific
     * rating
     *
     * @param number    the rating
     * @return  an ArrayList of Synthesis Objects
     */
    @Override
    public ArrayList<Synthesis> findAllByRating(Double number) {
        ArrayList<Synthesis> R = new ArrayList<Synthesis>();
        for (Synthesis s : synthesis) {
            if (s.getRating() == number) {
                R.add(s);
            }
        }
        return R;
    }

    /**
     * Finds a Synthesis based on the model number
     *
     * @param modelNo   the model number
     * @return  a Synthesis object or null
     */
    @Override
    public Synthesis find(int modelNo) {
        for (Synthesis s : synthesis) {
            if (s.getModelNo() == modelNo) {
                return s;
            }
        }
        return null;
    }

    /**
     * Finds a Synthesis based on its name
     *
     * @param name  the name of the synthesis
     * @return  a Synthseis object or null
     */
    @Override
    public Synthesis find(String name) {
        for (Synthesis s : synthesis) {
            if (s.getName() == name) {
                return s;
            }
        }
        return null;
    }

    /**
     * Finds all published sunthesis in the dao
     *
     * @return an ArrayList of Synthesis objects
     */
    @Override
    public ArrayList<Synthesis> findAllPublished() {
        ArrayList<Synthesis> Published = new ArrayList<Synthesis>();
        for(Synthesis s: synthesis){
            if(s.getPublishState()){
                Published.add(s);
            }
        }
        return Published;
    }

    /**
     * Deletes all the synthesis objects in the dao
     */
    @Override
    public void deleteAll() {
        synthesis.clear();
    }

    /**
     * Deletes the synthesis from the dao
     *
     * @param entity    a Synthesis object
     */
    @Override
    public void delete(Synthesis entity) {
        synthesis.remove(entity);
    }

    /**
     * Deletes a synthesis by the name
     *
     * @param name  the synthesis's name
     */
    @Override
    public void delete(String name) {
        synthesis.remove(find(name));
    }

    /**
     * Deletes a synthesis by its model number
     *
     * @param modelNo   the model number
     */
    @Override
    public void delete(int modelNo) {
        synthesis.remove(find(modelNo));
    }

    /**
     * Deletes all the synthesis in the dao by
     * the given rating
     *
     * @param rating    the rating
     */
    @Override
    public void deleteAllByRating(Double rating) {
        for (int i =0; i< findAllByRating(rating).size();){
            synthesis.remove(findAllByRating(rating).get(i));
        }
    }

    /**
     * Deletes all the synthesis in the dao by
     * the number of rates
     *
     * @param number    the number of rates
     */
    @Override
    public void deleteAllByNumberOfRatings(int number) {
        for (int i =0; i< findAllByNumberOfRatings(number).size();){
            synthesis.remove(findAllByNumberOfRatings(number).get(i));
        }
    }
}
