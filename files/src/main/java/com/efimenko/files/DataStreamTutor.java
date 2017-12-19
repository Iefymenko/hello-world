package com.efimenko.files;

import java.awt.image.BufferedImageOp;
import java.io.*;

/**
 * Created by DSK20 on 15.12.2015.
 */
public class DataStreamTutor {
    static final String FILES_TEST_PATH = "files/test.txt";
    static final String TEST_LINE = "test line";

    /**
     * Writes into FILES_TEST_PATH string TEST_LINE
     * using method writeUTF of class DataOutputStream.
     * Also use BufferedOutputStream for bufferization.
     * Then close the stream.
     */
    public static void writeToFile() {
        try {
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(FILES_TEST_PATH)));
            dos.writeUTF(TEST_LINE);
            dos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read line from the file using method readUTF and returns it.
     * @return
     */
    public static String readFromFile() {
        try {
            DataInputStream dos = new DataInputStream(new BufferedInputStream(new FileInputStream(FILES_TEST_PATH)));
            String s = dos.readUTF();
            dos.close();
            return s;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
