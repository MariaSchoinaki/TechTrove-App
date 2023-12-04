package com.example.tecktrove.util;

import android.util.Pair;
import java.util.ArrayList;

/**
 * The main purpose of this class is to provide
 * an easy and safe way to implement the ports of a component.
 */
public class Port {

    private ArrayList<Pair<String, Integer>> ports;
    public Port(){
        this.ports = new ArrayList<Pair<String, Integer>>();
    }

    public Port(ArrayList<Pair<String, Integer>> ports){
        this.ports = ports;
    }
    public void add(Pair<String, Integer> port){
        ports.add(port);
    }

    public void remove(Pair<String, Integer> port){
        ports.remove(port);
    }

    public int getPortNumber(String key) {
        for (Pair<String, Integer> p : ports) {
            if (p.first.equals(key)) {
                return p.second;
            }
        }
        return -1;
    }
}
