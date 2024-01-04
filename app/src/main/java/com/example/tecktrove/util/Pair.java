package com.example.tecktrove.util;

public class Pair<T, K> {

    private T first;
    private K second;
    public Pair(){}

    public Pair(T s, K i){
        this.first = s;
        this.second = i;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(K second) {
        this.second = second;
    }

    public K getSecond() {
        return second;
    }

    public T getFirst() {
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


