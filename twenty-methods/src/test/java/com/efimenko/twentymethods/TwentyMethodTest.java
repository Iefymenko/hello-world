package com.efimenko.twentymethods;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by oiefymenko on 08/12/2015.
 */
public class TwentyMethodTest {
    @Test
    public void testAdd() {
        String rezStr;
        int[][] ints = {{61, 62, 63}, {71, 72, 73, 74}, {81, 82}};
        char[][] char2arr;
        char2arr = TwentyMethods.convertToPosition(ints);
        rezStr = "";
        for (char[] chrArray : char2arr)
            for (char c : chrArray)
                rezStr += c;
        assertEquals("=>?GHIJQR", rezStr);
        //assertNotEquals(4, calculator.divide(2, 3));
    }

}
