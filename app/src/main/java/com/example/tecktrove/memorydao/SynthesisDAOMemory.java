package com.example.tecktrove.memorydao;


import com.example.tecktrove.dao.SynthesisDAO;
import com.example.tecktrove.domain.Synthesis;
import java.util.ArrayList;

public class SynthesisDAOMemory implements SynthesisDAO {
    protected static  ArrayList<Synthesis> synthesis = new ArrayList<Synthesis>();

    @Override
    public ArrayList<Synthesis> findAll() {
        return new ArrayList<Synthesis>(synthesis);
    }

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

    @Override
    public void deleteAll() {
        synthesis.clear();
    }

    @Override
    public void delete(Synthesis entity) {
        synthesis.remove(entity);
    }

    @Override
    public void delete(String entity) {
        synthesis.remove(find(entity));
    }

    @Override
    public void delete(int entity) {
        synthesis.remove(find(entity));
    }

    @Override
    public void deleteAllByRating(Double number) {
        synthesis.remove(findAllByRating(number));

    }

    @Override
    public void deleteAllByNumberOfRatings(int number) {
        synthesis.remove(findAllByNumberOfRatings(number));

    }

    @Override
    public void save(Synthesis entity) {
        synthesis.add(entity);
    }

    @Override
    public Synthesis find(int modelNo) {
        for (Synthesis s : synthesis) {
            if (s.getModelNo() == modelNo) {
                return s;
            }
        }
        return null;
    }

    @Override
    public Synthesis find(String name) {
        for (Synthesis s : synthesis) {
            if (s.getName() == name) {
                return s;
            }
        }
        return null;
    }
}
