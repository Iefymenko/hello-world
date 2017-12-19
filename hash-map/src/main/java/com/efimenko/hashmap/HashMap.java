package com.efimenko.hashmap;

import java.util.ArrayList;


public class HashMap {
    ArrayList[] array;
    private int size;

    private ArrayList getChild(Object key) {
        return array[key.hashCode() % array.length];
    }

    private Entry getEntry(ArrayList arrayList, Object key) {
        for (int i = 0; i < arrayList.size(); i++) {
            Entry entry = (Entry) arrayList.get(i);
            if (key.equals(entry.key)) {
                return entry;
            }
        }
        return null;
    }

    private ArrayList[] createMap(int length) {
        ArrayList[] newArray = new ArrayList[length];
        for (int i = 0; i < length; i++) {
            newArray[i] = new ArrayList();
        }
        return newArray;
    }

    void extend() {
        ArrayList[] oldArray = array;
        array = createMap((int) Math.round(oldArray.length * 1.5));
        for (int j = 0; j < oldArray.length; j++) {
            ArrayList arrayList = oldArray[j];
            for (int i = 0; i < arrayList.size(); i++) {
                Entry entry = (Entry) arrayList.get(i);
                put(entry.key, entry.value);
            }
        }
    }

    public HashMap(int length) {
        array = createMap(length);
    }

    public void put(Object key, Object value) {
        ArrayList arrayList = getChild(key);
        Entry entry = getEntry(arrayList, key);

        if (entry == null) {
            Entry newEntry = new Entry(key, value);
            arrayList.add(newEntry);
            size++;
            if (size > array.length * array.length) {
                extend();
            }
        } else {
            entry.value = value;
        }
    }

    public void putIfAbsent(Object key, Object value) {
        ArrayList arrayList = getChild(key);
        Entry entry = getEntry(arrayList, key);

        if (entry == null) {
            Entry newEntry = new Entry(key, value);
            arrayList.add(newEntry);
            size++;
        }
    }

    public Object get(Object key) {
        Entry entry = getEntry(getChild(key), key);
        if (entry != null) {
            return entry.value;
        }
        return null;
    }

    public Object remove(Object key) {
        ArrayList arrayList = getChild(key);
        Entry entry = getEntry(arrayList, key);

        if (entry != null) {
            arrayList.remove(entry);
            size--;
            return entry.value;
        }
        return null;
    }

    public ArrayList keys() {
        ArrayList keysList = new ArrayList(size);
        for (int j = 0; j < array.length; j++) {
            ArrayList arrayList = array[j];
            for (int i = 0; i < arrayList.size(); i++) {
                keysList.add(((Entry) arrayList.get(i)).key);
            }
        }
        return keysList;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < array.length; j++) {
            ArrayList arrayList = array[j];
            for (int i = 0; i < arrayList.size(); i++) {
                stringBuilder.append(arrayList.get(i) + " ");
            }
        }
        return stringBuilder.toString();
    }

    public boolean containsKey(Object key) {
        Entry entry = getEntry(getChild(key), key);
        if (entry != null) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object value) {
        for (int j = 0; j < array.length; j++) {
            ArrayList arrayList = array[j];
            for (int i = 0; i < arrayList.size(); i++) {
                Object currentValue=((Entry) arrayList.get(i)).value;
                if (value==null) {
                    if (currentValue ==null) {
                        return true;
                    }
                    else {
                        return false;
                    }

                }
                else if (value.equals(currentValue)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void putAll(HashMap hashMap) {
        ArrayList keys = hashMap.keys();
        for (int i = 0; i < keys.size(); i++) {
            Object key = keys.get(i);
            put(key, hashMap.get(key));
        }
    }
}
