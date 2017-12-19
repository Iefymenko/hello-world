package com.efimenko.numberconverter;

/*
The Class should contain four static methods to convert:
int -> String
String -> int
double -> String
String -> double
1) No standart methods to convert
2) No more than one symbol during iteration (e.g. during number to string conversion we should take from number digits one by one)
3) The numbers can be negative
4) Floats can have no digits after dot (12345)
5) During to string convertion we don't neet to check whether number is correct. Strings always contain correct numbers
ps We cann use class Math methods
*/
public class NumberConverter {
    //2 number converter, numbers can be negative
    //int to str by digits using simple math operations
    public static String toString(int value) {
        String returnString = "";

        int sign = 1;
        if (value<0) {
            sign = -1;
        }

        int mod = 0;

        while (Math.abs(value) > 0 || value == Integer.MIN_VALUE) {
            mod = Math.abs(value % 10);
            value = value / 10;
            mod += (int) '0';//+48
            returnString += (char) mod;
        }

        returnString = new StringBuilder(returnString).reverse().toString();
        if (sign<0) {
            returnString="-"+returnString;
        }
        else if (returnString.equals("")) {
            returnString = "0";
        }

        return returnString;
    }

    public static String toString(long value) {
        String returnString = "";

        int sign = 1;
        if (value<0) {
            sign = -1;
        }

        long mod = 0;

        while (Math.abs(value) > 0 || value == Long.MIN_VALUE) {
            mod = Math.abs(value % 10);
            value = value / 10;
            mod += (int) '0';//+48
            returnString += (char) mod;
        }

        returnString = new StringBuilder(returnString).reverse().toString();
        if (sign<0) {
            returnString="-"+returnString;
        }
        else if (returnString.equals("")) {
            returnString = "0";
        }

        return returnString;
    }

    public static int toInt(String value) {
        int returnValue = 0;

        int sign = 1;
        if (value.charAt(0)=='-') {
            sign = -1;
            value=value.substring(1);
        };

        for (int j=0; j<value.length(); j++) {
            returnValue += sign*Math.pow(10, value.length() - j - 1) * (int) (value.charAt(j) - (int) '0');
        }

        return returnValue;
    }

    public static long toLong(String value) {
        long returnValue = 0;

        int sign = 1;
        if (value.charAt(0)=='-') {
            sign = -1;
            value=value.substring(1);
        };

        for (int j=0; j<value.length(); j++) {
            returnValue += sign*Math.pow(10, value.length() - j - 1) * (long) (value.charAt(j) - (long) '0');
        }

        return returnValue;
    }

    public static String toString(double value) {
        String returnValue = "";
        final double DELTA = 0.000000000001;
        int power = 0;

        double temp = value;
        long whole = 0;

        if (temp>0) {
            whole = (long)Math.floor(temp);
        }
        else {
            whole = (long)Math.ceil(temp);
        }
        returnValue += NumberConverter.toString(whole);
        temp -= whole;
        temp = Math.abs(temp);

        if (temp/Math.pow(10, power)>DELTA) {
            returnValue+=".";
            while (temp/Math.pow(10, power)>DELTA) {
                power+=1;
                temp *= 10;
                whole = (long)Math.floor(temp);
                returnValue += NumberConverter.toString(whole);
                //System.out.println("temp: "+temp+" whole: "+whole+" returnValue: "+returnValue);
                temp -= whole;
            }
        }
        return returnValue;
    }

    public static double toDouble(String value) {
        double returnDouble = 0;
        String fraction = "";

        int sign = 1;
        if (value.charAt(0)=='-') {
            sign = -1;
        };

        int separator = value.indexOf('.');
        if (separator < 0) {
            separator = value.length();
        }
        else {
            fraction = value.substring(separator+1);
            returnDouble += sign*NumberConverter.toLong(fraction) / Math.pow(10, fraction.length());
        }
        returnDouble += NumberConverter.toLong(value.substring(0, separator));
        return returnDouble;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
