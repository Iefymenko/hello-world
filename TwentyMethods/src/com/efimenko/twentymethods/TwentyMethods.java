package com.efimenko.twentymethods;

/**
 * Created by oiefymenko on 08/12/2015.
 */
public class TwentyMethods {

    //01 get char array as argument and print it
    public static void print(char[] array) {
        //String rezStr = new String(chars);
        for (char c : array) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    //02 get two dimension char array as argument and print it
    public static void print(String[][] array) {
        for (String[] stringArray : array) {
            for (String s : stringArray) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    //03 get two dimension int array, return two dimension char array, each symbol in char array correspond to the code in int array
    public static char[][] convertToPosition(int[][] array) {
        char[][] returnArray = new char[array.length][];//??? why second dim don't have size?
        for (int i = 0; i < array.length; i++) {
            returnArray[i] = new char[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                returnArray[i][j] = (char) array[i][j];
            }
        }
        return returnArray;
    }

    //04 get two dimension int array, invert int array (each value should change sign)
    public static void invert(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)
                array[i][j] *= -1;
        }
    }

    //05 get two int digits, a and b, return biggest value
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    //06 get three int digits, a and b, return biggest value
    public static int max(int a, int b, int c) {
        return max(a, max(b, c));
    }

    //07 get five int digits, a and b, return biggest value
    public static int max(int a, int b, int c, int d, int e) {
        return max(max(a, b, c), max(d, e));
    }

    //08 char array, returns string contains arrays symbols
    public static String convert(char[] array) {
        //return new String(array);
        String string = "";
        for (char c : array) {
            string += c;
        }
        return string;
    }

    //09 get two char arrays, check if first array contains same sequence of chars as second array is. returns boolean
    public static boolean isSubset(char[] firstArray, char[] secondArray) {
        for (int i = 0; i < firstArray.length; i++) {
            for (int j = i, k = 0; (j < firstArray.length && k < secondArray.length); j++, k++) {
                if (firstArray[j] != secondArray[k]) {
                    break;
                }
                if (k == secondArray.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    //10 get int array and int value, returns index of array which value match in parameter, starts from begin of array. if there is no value - returns -1
    public static int indexOf(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) return i;
        }
        return -1;
    }


    //11 get int array and int value, returns index of array which value match in parameter, starts from end of array. if there is no value - returns -1
    public static int lastIndexOf(int[] array, int value) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == value) return array.length - i;
        }
        return -1;
    }

    //12 get int value, returns factorial
    public static long factorial(int n) {
        if (n > 0) {
            return n * factorial(n - 1);
        }
        else {
            return 1;}
    }

    //13 get int year value, returns true if it is leap year
    public static boolean isLeapYear(int year) {
        if ((year % 4) > 0) {
            return false;}
        else if ((year % 100) > 0) {
            return true;
        }
        else if ((year % 400) > 0) {
            return false;
        }
        else {
            return true;
        }
    }

    //14 get String array and String value, returns String array with Strings which contains this String value
    public static String[] contain(String[] array, String string) {
        int cnt = 0;
        for (int i = 0; i < array.length; i++)
            if (array[i].indexOf(string) > -1) {
                cnt++;
            }
            else {
                array[i] = "";
            }
        String[] returnArray = new String[cnt];
        for (int i = array.length - 1; i >= 0; i--)
            if (array[i] != "") {
                returnArray[cnt - 1] = array[i];
                cnt--;
            }
        return returnArray;
    }

    //15 get int array and int value, prints only elements that multiple of value
    public static void printMultiple(int[] array, int value) {
        for (int i : array) {
            if (i % value == 0) {
                System.out.println(i);
            }
        }
    }

    //16 get double value, prints this double with precision less or equal than 3 digits after dot
    public static void roundToThird(double d) {
        System.out.println(((double) (long) (d * 1000)) / 1000);
    }

    //17 get array of ints  and sort it ascending
    //bubble sort due to fixed size array
    public static void sortAsc(int[] array) {
        int b;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    b = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = b;
                }
            }
        }
    }


    //18 get int array and sort it descending
    public static void sortDesc(int[] array) {
        int b;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    b = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = b;
                }
            }
        }
    }

    //19 get int array and boolean value, if this value is true then sort ascending, otherwise - descending
    public static void sort(int[] array, boolean order) {
        if (order) sortAsc(array);
        else sortDesc(array);
    }

    //20 get byte array, if array contains repeated elements then returns true
    public static boolean isEqual(byte[] bytes) {
        byte[] table = new byte[(Byte.MAX_VALUE + 1) * 2];

        for (int i = 0; i < bytes.length; i++) {
            table[bytes[i] + Byte.MAX_VALUE + 1] += 1;
            if (table[bytes[i] + Byte.MAX_VALUE + 1] == 2) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String rezStr = "";

        char[] chars = {'a', 'b', 'c'};
        print(chars);

        String[][] strings = {{"a1", "a2", "a3"}, {"b1", "b2", "b3", "b4"}, {"c1", "c2"}};
        print(strings);

        int[][] ints = {{61, 62, 63}, {71, 72, 73, 74}, {81, 82}};
        char[][] char2arr;
        char2arr = convertToPosition(ints);
        rezStr = "";
        for (char[] chrArray : char2arr)
            for (char c : chrArray)
                rezStr += c;
        System.out.println(rezStr);

        invert(ints);
        rezStr = "";
        for (int[] strArray : ints)
            for (int i : strArray)
                rezStr += i;
        System.out.println(rezStr);

        System.out.println(max(1, 2));
        System.out.println(max(1, 2, 3));
        System.out.println(max(1, 2, 3, 4, 5));

        rezStr = convert(chars);
        System.out.println(rezStr);

        char[] chars2 = {'x', 'a', 'b', 'c'};
        System.out.println(isSubset(chars2, chars));

        System.out.println(indexOf(ints[1], -73));
        System.out.println(indexOf(ints[1], -73));

        System.out.println(factorial(4));
        System.out.println(isLeapYear(2015));

        String[] retStr = contain(strings[1], "2");
        rezStr = "";
        for (String s : retStr)
            rezStr += s;
        System.out.println(rezStr);

        printMultiple(ints[1], 36);

        roundToThird(0.1234);

        rezStr = "";
        sort(ints[1], true);
        for (int i : ints[1])
            rezStr += i;
        System.out.println(rezStr);
        rezStr = "";
        sort(ints[1], false);
        for (int i : ints[1])
            rezStr += i;
        System.out.println(rezStr);

        byte[] bytes = {1, 2, 1};
        System.out.println(isEqual(bytes));
    }

}
