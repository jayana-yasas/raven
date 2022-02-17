package com.oxcentra.raven.util;

public class Entry<T> {

    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

}
