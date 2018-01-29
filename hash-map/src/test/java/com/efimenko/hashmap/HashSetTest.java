package com.efimenko.hashmap;

import org.junit.Test;
import org.junit.Assert;

/**
 * Created by DSK20 on 11.12.2015.
 */
public class HashSetTest {
    @Test
    public void testPut() {
        HashSet hashSet = new HashSet();
        String key = "key1";
        String key2 = "key2";
        hashSet.add(key);
        Assert.assertEquals(hashSet.size(), 1);
        Assert.assertTrue(hashSet.contains(key));
        Assert.assertFalse(hashSet.contains(key2));
        hashSet.add(key2);
        Assert.assertEquals(hashSet.size(), 2);
        Assert.assertTrue(hashSet.contains(key2));

    }
}
