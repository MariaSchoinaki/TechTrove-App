package com.example.tecktrove.util;

public class Pair {

    private String first;
    private int second;
    public Pair(){}

    public Pair(String s, int i){
        this.first = s;
        this.second = i;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getSecond() {
        return second;
    }

    public String getFirst() {
        return first;
    }
}
