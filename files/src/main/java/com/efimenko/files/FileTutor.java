package com.efimenko.files;

import java.io.File;
import java.io.IOException;

/**
 * Created by DSK20 on 14.12.2015.
 */
public class FileTutor {
    /**
     * This method should create test folder and file test/test.txt
     * Also show in log full path to created file
     */
    public static void createFile() {
        File f = new File("tst/test.txt");
        f.getParentFile().mkdir();
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method should delete test folder and file test/test.txt
     */
    public static void deleteFile() {
        File f = new File("tst/test.txt");
        f.delete();
        f = f.getParentFile();
        f.delete();
    }
}
