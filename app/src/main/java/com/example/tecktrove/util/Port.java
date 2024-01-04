package com.example.tecktrove.util;


import com.example.tecktrove.domain.OrderLine;

import java.util.ArrayList;
import java.util.Objects;

/**
 * The main purpose of this class is to provide
 * an easy and safe way to implement the ports of a component.
 */
public class Port {

    private ArrayList<Pair<String,Integer>> ports;
    public Port(){
        this.ports = new ArrayList<Pair<String,Integer>>();
    }

    public Port(ArrayList<Pair<String,Integer>> ports){
        this.ports = ports;
    }
    public void add(Pair port){
        ports.add(port);
    }

    public void remove(Pair p){
        ports.remove(p);
    }

    public int getPortNumber(String key) {
        Pair<String,Integer> p1 = findPortPair(key);
        for (Pair<String,Integer> p : ports) {
            if (p.getFirst() == key) {
                return  p.getSecond();
            }
        }
        return -1;
    }
    @Override
    public boolean equals(Object other) {
        if (other == null){
            return false;
        }
        if (this == other){
            return true;
        }
        if (!(other instanceof Port)){
            return false;
        }
        Port o = (Port) other;
        if (o.getPorts().size()!=this.getPorts().size()) {
            return false;
        }else{
            boolean equals = Boolean.TRUE;
            for (int i = 0; i<o.getPorts().size();i++){
                if (!(o.getPorts().get(i).equals(this.ports.get(i)))){
                    equals = Boolean.FALSE;
                }
            }
            return  equals;
        }
    }

    public ArrayList<Pair<String,Integer>> getPorts(){
        return this.ports;
    }

    public Pair<String,Integer> findPortPair(String key){
        for (Pair<String,Integer> p : ports) {
            if (p.getFirst() == key) {
                return p;
            }
        }
        return null;
    }
}
