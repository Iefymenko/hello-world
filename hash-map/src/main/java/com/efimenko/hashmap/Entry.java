package com.efimenko.hashmap;

/**
 * Created by DSK20 on 10.12.2015.
 */
public class Entry {
    protected Object key;
    protected Object value;

public Entry(Object k, Object v) {
    this.key = k;
    this.value = v;
}

@Override
public String toString() {
    return key.toString()+ value.toString();
}
}
