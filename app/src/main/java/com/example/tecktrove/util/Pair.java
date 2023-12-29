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

    @Override
    public boolean equals(Object other) {
        if (other == null){
            return false;
        }
        if (this == other){
            return true;
        }
        if (!(other instanceof Pair)){
            return false;
        }
        Pair o = (Pair) other;
        return (this.first==o.first) && (this.second == this.second);
    }
}


