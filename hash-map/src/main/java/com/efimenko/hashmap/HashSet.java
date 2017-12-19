package com.efimenko.hashmap;

import java.util.List;

/**
 * Created by DSK20 on 11.12.2015.
 */
public class HashSet {
    private HashMap hashMap;

    public HashSet() {
        hashMap = new HashMap(4);
    }

    public void add(Object value) {
        hashMap.put(value, value);
    }

    public void remove(Object value) {
        hashMap.remove(value);
    }

    public List values() {
        return hashMap.keys();
    }

    public boolean contains(Object value) {
        return hashMap.containsKey(value);
    }

    public int size() {
        return hashMap.size();
    }

    public void clear() {
        hashMap = new HashMap(hashMap.size());
    }
}
