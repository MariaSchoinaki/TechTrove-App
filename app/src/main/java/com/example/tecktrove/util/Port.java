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

    /**
     * Default constructor
     */
    public Port(){
        this.ports = new ArrayList<Pair<String,Integer>>();
    }

    /**
     * Constructor with parameters: {ports}
     * @param ports an ArrayList with {@link Pair} objects
     *              representing with first the name of the port
     *              and second the number of the ports
     */
    public Port(ArrayList<Pair<String,Integer>> ports){
        this.ports = ports;
    }

    /**
     * Adds a pair of port in the ArrayList of Ports
     *
     * @param port a pair object <String nameofport, Integer numberofport>
     */
    public void add(Pair port){
        ports.add(port);
    }

    /**
     * Removes a pair of port from the ArrayList
     * @param p a pair object <String nameofport, Integer numberofport>
     */
    public void remove(Pair p){
        ports.remove(p);
    }

    /**
     * Gets the number of ports a specific port has
     *
     * @param key   the name of the port
     * @return  the number of ports or -1
     */
    public int getPortNumber(String key) {
        Pair<String,Integer> p1 = findPortPair(key);
        for (Pair<String,Integer> p : ports) {
            if (p.getFirst() == key) {
                return  p.getSecond();
            }
        }
        return -1;
    }

    /**
     * Returns {@code true} if another object is equal with this
     * port object
     *
     * @param other the other object
     * @return  {@code true} if the objects are equal, {@code false} otherwise
     */
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

    /**
     * Returns the ports
     *
     * @return  an ArrayList of {@link Pair} Objects
     */
    public ArrayList<Pair<String,Integer>> getPorts(){
        return this.ports;
    }

    /**
     * Finds a Pair of port by the ports name
     *
     * @param key   the ports name
     * @return      a {@link Pair} object or null
     */
    public Pair<String,Integer> findPortPair(String key){
        for (Pair<String,Integer> p : ports) {
            if (p.getFirst() == key) {
                return p;
            }
        }
        return null;
    }
}
