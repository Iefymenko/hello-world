package com.efimenko.list;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by oiefymenko on 09/12/2015.
 */
public class ListTest {
    @Test
    public void testAdd() {
        String[] s={"Test1", "Test2", "Test3"};
        ArrayList arrayList = new ArrayList();
        assertEquals(-1, arrayList.last);

        arrayList.add(s[0]);
        assertEquals(s[0], arrayList.array[0]);
        assertEquals(0, arrayList.last);

        arrayList.add(1, s[1]);
        assertEquals(s[1], arrayList.array[1]);
        assertEquals(1, arrayList.last);

        arrayList.add(1, s[2]);
        assertEquals(s[2], arrayList.array[1]);
        assertEquals(2, arrayList.last);
        assertEquals(s[1], arrayList.array[2]);

    }
}
