package com.efimenko.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessTutor {
    static final String FILES_TEST_PATH = "files/test.txt";

    /*
    * This method should open RandomAccessFile using path FILES_TEST_PATH
    * and writes here number 10 (Integer), and then string "test line"
    */
    public static void randomAccessWrite() {
        try {
            RandomAccessFile f = new RandomAccessFile(FILES_TEST_PATH, "rw");
            f.writeInt(10);
            f.writeChars("test line");
            f.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
    * This method shoulld open file RandomAccessFile using path FILES_TEST_PATH,
    * pass number 10 and word "test " dont count them,
    * jump on 5th letter, read and return "line"
    */
    public static String randomAccessRead() {
        String s = "";
        try {
            RandomAccessFile f = new RandomAccessFile(FILES_TEST_PATH, "r");
            f.skipBytes(14);
            s = f.readLine();
            f.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}

