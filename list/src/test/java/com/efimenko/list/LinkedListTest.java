package com.efimenko.list;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by oiefymenko on 09/12/2015.
 */
public class LinkedListTest {
    @Test
    public void testAdd() {
        String[] s={"Test1", "Test2", "Test3"};
        LinkedList linkedList = new LinkedList();
        assertEquals(0, linkedList.size());

        linkedList.add(s[0]);
        assertEquals(s[0], linkedList.get(0));

        linkedList.add(1, s[1]);
        //assertEquals(s[1], linkedList.get(1));

        //linkedList.add(1, s[2]);
        //assertEquals(s[2], linkedList.get(1));
        //assertEquals(s[1], linkedList.get(2));

    }

    /*@Test
    public void testRemove() {
        String[] s={"Test1", "Test2", "Test3"};
        LinkedList linkedList = new LinkedList();

        linkedList.add(s[0]);
        linkedList.add(s[1]);
        linkedList.add(s[2]);
        assertEquals(s[1], linkedList.remove(1));
        assertEquals(s[2], linkedList.get(1));
    }

    @Test
    public void testIndexOf() {
        String[] s={"Test1", "Test2", "Test3"};
        LinkedList linkedList = new LinkedList();

        linkedList.add(s[0]);
        linkedList.add(s[1]);
        linkedList.add(s[2]);
        assertEquals(0, linkedList.indexOf(s[0]));
        assertEquals(1, linkedList.indexOf(s[1]));
        assertEquals(2, linkedList.indexOf(s[2]));
    }

    @Test
    public void testLastIndexOf() {
        String[] s={"Test1", "Test2", "Test3"};
        LinkedList linkedList = new LinkedList();

        linkedList.add(s[0]);
        linkedList.add(s[1]);
        linkedList.add(s[2]);
        assertEquals(0, linkedList.lastIndexOf(s[0]));
        assertEquals(1, linkedList.lastIndexOf(s[1]));
        assertEquals(2, linkedList.lastIndexOf(s[2]));
    }

    @Test
    public void testClear() {
        String[] s={"Test1", "Test2", "Test3"};
        LinkedList linkedList = new LinkedList();

        assertTrue(linkedList.isEmpty());

        linkedList.add(s[0]);
        linkedList.add(s[1]);
        linkedList.add(s[2]);

        assertFalse(linkedList.isEmpty());

        linkedList.clear();
        assertTrue(linkedList.isEmpty());
        assertNull(linkedList.get(0));
        assertNull(linkedList.get(1));
        assertNull(linkedList.get(2));
    }

    @Test
    public void testSet() {
        String[] s={"Test1", "Test2", "Test3"};
        LinkedList linkedList = new LinkedList();

        linkedList.set(0, s[0]);
        assertEquals(linkedList.get(0), s[0]);
        linkedList.set(0, s[1]);
        assertEquals(linkedList.get(0), s[1]);
        linkedList.set(2, s[2]);
        assertEquals(linkedList.get(2), s[2]);
    }

    @Test
    public void testSize() {
        String[] s={"Test1", "Test2", "Test3"};
        LinkedList linkedList = new LinkedList();

        assertEquals(0, linkedList.size());

        linkedList.add(s[0]);
        linkedList.add(s[1]);
        linkedList.add(s[2]);

        assertEquals(3, linkedList.size());
    }

    @Test
    public void testContains() {
        String[] s={"Test1", "Test2", "Test3"};
        LinkedList linkedList = new LinkedList();

        linkedList.add(s[0]);
        linkedList.add(s[1]);
        linkedList.add(s[2]);

        assertTrue(linkedList.contains(s[0]));
        assertTrue(linkedList.contains(s[1]));
        assertTrue(linkedList.contains(s[2]));
        assertFalse(linkedList.contains("Test4"));
    }*/
}