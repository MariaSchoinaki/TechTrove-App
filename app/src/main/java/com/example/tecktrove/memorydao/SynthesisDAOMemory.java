package com.example.tecktrove.memorydao;


import com.example.tecktrove.dao.SynthesisDAO;
import com.example.tecktrove.domain.Synthesis;
import java.util.ArrayList;

public class SynthesisDAOMemory implements SynthesisDAO {
    ArrayList<Synthesis> synthesis = new ArrayList<Synthesis>();

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
    public void deleteAllByRating(Double number) {
        synthesis.remove(findAllByRating(number));

    }

    @Override
    public void save(Synthesis entity) {
        synthesis.remove(entity);
    }
}
