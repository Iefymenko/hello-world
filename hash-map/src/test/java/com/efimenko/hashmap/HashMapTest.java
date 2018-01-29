package com.efimenko.hashmap;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

/**
 * Created by DSK20 on 10.12.2015.
 */
public class HashMapTest {
    @Test
    public void testPut() {
        HashMap hashMap = new HashMap(16);
        String key = "key1";
        String key2 = "key2";
        String value = "val1";
        String value2 = "val2";
        hashMap.put(key, value2);
        Assert.assertEquals(hashMap.get(key), value2);
        Assert.assertEquals(hashMap.size(), 1);

        hashMap.put(key, value);
        Assert.assertEquals(hashMap.get(key), value);
        Assert.assertEquals(hashMap.size(), 1);

        hashMap.putIfAbsent(key, value2);
        Assert.assertEquals(hashMap.get(key), value);
        Assert.assertEquals(hashMap.size(), 1);

        Assert.assertEquals(hashMap.toString(), key + value + " ");

        ArrayList arrayList = new ArrayList();
        arrayList.add(key);

        Assert.assertTrue(hashMap.containsValue(value));
        Assert.assertEquals(hashMap.keys(), arrayList);

        Assert.assertTrue(hashMap.containsValue(value));
        Assert.assertTrue(hashMap.containsKey(key));

        Assert.assertEquals(hashMap.remove(key), value);
        Assert.assertEquals(hashMap.size(), 0);
    }

    @Test
    public void testPutAll() {
        HashMap hashMap = new HashMap(4);
        HashMap hashMap2 = new HashMap(8);
        String key = "key1";
        String key2 = "key2";
        String value = "val1";
        String value2 = "val2";
        hashMap.put(key, value);
        hashMap2.put(key2, value2);
        Assert.assertEquals(hashMap.size(), 1);
        hashMap.putAll(hashMap2);
        Assert.assertEquals(hashMap.size(), 2);
    }

    @Test
    public void testExtend() {
        HashMap hashMap = new HashMap(4);
        String key = "key1";
        String key2 = "key2";
        String value = "val1";
        String value2 = "val2";
        hashMap.put(key, value);
        hashMap.put(key2, value2);
        Assert.assertEquals(hashMap.size(), 2);
        Assert.assertEquals(hashMap.array.length, 4);
        Assert.assertEquals(hashMap.get(key), value);
        Assert.assertEquals(hashMap.get(key2), value2);
        hashMap.extend();
        Assert.assertEquals(hashMap.size(), 4); //?to check this test
        Assert.assertEquals(hashMap.array.length, 6);
        Assert.assertEquals(hashMap.get(key), value);
        Assert.assertEquals(hashMap.get(key2), value2);
    }

}
