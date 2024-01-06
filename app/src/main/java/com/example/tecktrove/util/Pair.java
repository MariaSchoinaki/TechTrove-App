package com.example.tecktrove.util;

public class Pair<T, K> {

    private T first;
    private K second;
    public Pair(){}

    public Pair(T s, K i){
        this.first = s;
        this.second = i;
    }

    /**
     * Sets the first attribute of the pair
     *
     * @param first the first attribute
     */
    public void setFirst(T first) {
        this.first = first;
    }

    /**
     * Sets the second attribute or the pair
     * @param second    the second attribute
     */
    public void setSecond(K second) {
        this.second = second;
    }

    /**
     * Gets the second attribute of the pair
     * @return  a {@link K} object
     */
    public K getSecond() {
        return second;
    }

    /**
     * Gets the firts attribute of the pair
     * @return  a {@link T} object
     */
    public T getFirst() {
        return first;
    }

    /**
     * Returns {@code true} if an object is equals
     * with the object pair
     *
     * @param other the other object
     * @return  true if the objects are equal, false otherwise
     */
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

    @Override
    public String toString() {
        return first + ": " + second;
    }
}


