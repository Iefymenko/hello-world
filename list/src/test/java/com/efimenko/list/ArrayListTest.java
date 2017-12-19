package com.efimenko.list;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by oiefymenko on 09/12/2015.
 */
public class ArrayListTest {
    @Test
    public void testAdd() {
        String[] s={"Test1", "Test2", "Test3"};
        ArrayList arrayList = new ArrayList();
        assertEquals(-1, arrayList.last);

        arrayList.add(s[0]);
        assertEquals(s[0], arrayList.get(0));
        assertEquals(0, arrayList.last);

        arrayList.add(1, s[1]);
        assertEquals(s[1], arrayList.get(1));
        assertEquals(1, arrayList.last);

        arrayList.add(1, s[2]);
        assertEquals(s[2], arrayList.get(1));
        assertEquals(2, arrayList.last);
        assertEquals(s[1], arrayList.get(2));

    }

    @Test
    public void testRemove() {
        String[] s={"Test1", "Test2", "Test3"};
        ArrayList arrayList = new ArrayList();

        arrayList.add(s[0]);
        arrayList.add(s[1]);
        arrayList.add(s[2]);
        assertEquals(s[1], arrayList.remove(1));
        assertEquals(s[2], arrayList.get(1));
        assertEquals(1, arrayList.last);
    }

    @Test
    public void testIndexOf() {
        String[] s={"Test1", "Test2", "Test3"};
        ArrayList arrayList = new ArrayList();

        arrayList.add(s[0]);
        arrayList.add(s[1]);
        arrayList.add(s[2]);
        assertEquals(0, arrayList.indexOf(s[0]));
        assertEquals(1, arrayList.indexOf(s[1]));
        assertEquals(2, arrayList.indexOf(s[2]));
    }

    @Test
    public void testLastIndexOf() {
        String[] s={"Test1", "Test2", "Test3"};
        ArrayList arrayList = new ArrayList();

        arrayList.add(s[0]);
        arrayList.add(s[1]);
        arrayList.add(s[2]);
        assertEquals(0, arrayList.lastIndexOf(s[0]));
        assertEquals(1, arrayList.lastIndexOf(s[1]));
        assertEquals(2, arrayList.lastIndexOf(s[2]));
    }

    @Test
    public void testClear() {
        String[] s={"Test1", "Test2", "Test3"};
        ArrayList arrayList = new ArrayList();

        assertTrue(arrayList.isEmpty());

        arrayList.add(s[0]);
        arrayList.add(s[1]);
        arrayList.add(s[2]);

        assertFalse(arrayList.isEmpty());

        arrayList.clear();
        assertTrue(arrayList.isEmpty());
        assertEquals(arrayList.last, -1);
        assertNull(arrayList.get(0));
        assertNull(arrayList.get(1));
        assertNull(arrayList.get(2));
    }

    @Test
    public void testSet() {
        String[] s={"Test1", "Test2", "Test3"};
        ArrayList arrayList = new ArrayList();

        arrayList.set(0, s[0]);
        assertEquals(arrayList.get(0), s[0]);
        arrayList.set(0, s[1]);
        assertEquals(arrayList.get(0), s[1]);
        arrayList.set(2, s[2]);
        assertEquals(arrayList.get(2), s[2]);
    }

    @Test
    public void testSize() {
        String[] s={"Test1", "Test2", "Test3"};
        ArrayList arrayList = new ArrayList();

        assertEquals(0, arrayList.size());

        arrayList.add(s[0]);
        arrayList.add(s[1]);
        arrayList.add(s[2]);

        assertEquals(3, arrayList.size());
    }

    @Test
    public void testContains() {
        String[] s={"Test1", "Test2", "Test3"};
        ArrayList arrayList = new ArrayList();

        arrayList.add(s[0]);
        arrayList.add(s[1]);
        arrayList.add(s[2]);

        assertTrue(arrayList.contains(s[0]));
        assertTrue(arrayList.contains(s[1]));
        assertTrue(arrayList.contains(s[2]));
        assertFalse(arrayList.contains("Test4"));
    }
}
