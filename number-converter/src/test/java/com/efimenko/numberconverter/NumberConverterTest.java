package com.efimenko.numberconverter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oiefymenko on 08/12/2015.
 */
public class NumberConverterTest {
    @Test
    public void testIntToString() {
        assertEquals("1234567890", NumberConverter.toString(1234567890));
        assertEquals("-1234567890", NumberConverter.toString(-1234567890));
        assertEquals("0", NumberConverter.toString(0));
        assertEquals("2147483647", NumberConverter.toString(2147483647));
        assertEquals("-2147483648", NumberConverter.toString(-2147483648));
    }

    @Test
    public void testStringToInt() {
        assertEquals(1234567890, NumberConverter.toInt("1234567890"));
        assertEquals(-1234567890, NumberConverter.toInt("-1234567890"));
        assertEquals(0, NumberConverter.toInt("0"));
        assertEquals(2147483647, NumberConverter.toInt("2147483647"));
        assertEquals(-2147483648, NumberConverter.toInt("-2147483648"));
    }

    @Test
    public void testStringToDouble()
    {
        assertEquals(67890.01234567890123456789, NumberConverter.toDouble("67890.01234567890123456789"), 0.001);
        assertEquals(-67890.01234567890123456789, NumberConverter.toDouble("-67890.01234567890123456789"), 0.001);
        assertEquals(0, NumberConverter.toDouble("0"), 0.001);
    }

    @Test
    public void testDoubleToString()
    {
        assertEquals("12345.6789", NumberConverter.toString(12345.6789));
        assertEquals("-12345.6789", NumberConverter.toString(-12345.6789));
        assertEquals("67890.0123456789", NumberConverter.toString(67890.012345678901));
        assertEquals("-67890.0123456789", NumberConverter.toString(-67890.012345678901));
        assertEquals("0", NumberConverter.toString(0));
    }

}
