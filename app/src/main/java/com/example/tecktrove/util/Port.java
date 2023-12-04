package com.example.tecktrove.util;

import android.util.Pair;
import java.util.ArrayList;

/**
 * The main purpose of this class is to provide
 * an easy and safe way to implement the ports of a component.
 */
public class Port {

    private ArrayList<Pair<String, Integer>> ports;
    public Port(){}

    public Port(ArrayList<Pair<String, Integer>> ports){
        this.ports = ports;
    }
    public void add(Pair<String, Integer> port){
        ports.add(port);
    }
}
