package com.efimenko.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTutor {
    static final String FILES_TEST_PATH = "files/test.txt";
    static final String TEST_LINE = "test line";

    /**
     * writes into file FILES_TEST_PATH string TEST_LINE,
     * converts string into byte array.
     * please use class FileOutputStream.
     */
    public static void writeToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILES_TEST_PATH);
            fileOutputStream.write(TEST_LINE.length());
            byte[] s = TEST_LINE.getBytes();
            fileOutputStream.write(s);
            fileOutputStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * reads string from file and return it using FileInputStream.
     *
     * @return
     */
    public static String readFromFile() {
        byte bytes[];
        try {
            FileInputStream fileInputStream = new FileInputStream(FILES_TEST_PATH);
            bytes = new byte[fileInputStream.available()];
            int i = fileInputStream.read();
            byte[] s = new byte[i];
            fileInputStream.read(s, 0, i);
            String str = new String(s);
            return str;
        }
        catch (IOException e) {
            e.printStackTrace();
        };
        return null;
    }
}
