package com.example.tecktrove.util;


import java.util.ArrayList;

/**
 * The main purpose of this class is to provide
 * an easy and safe way to implement the ports of a component.
 */
public class Port {

    private ArrayList<Pair> ports;
    public Port(){
        this.ports = new ArrayList<Pair>();
    }

    public Port(ArrayList<Pair> ports){
        this.ports = ports;
    }
    public void add(Pair port){
        ports.add(port);
    }

    public void remove(Pair p){
        ports.remove(p);
    }

    public int getPortNumber(String key) {
        Pair p1 = findPortPair(key);
        for (Pair p : ports) {
            if (p.getFirst() == key) {
                return  p.getSecond();
            }
        }
        return -1;
    }

    public ArrayList<Pair> getPorts(){
        return this.ports;
    }

    public Pair findPortPair(String key){
        for (Pair p : ports) {
            if (p.getFirst() == key) {
                return p;
            }
        }
        return null;
    }
}
