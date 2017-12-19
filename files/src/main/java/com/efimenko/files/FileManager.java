package com.efimenko.files;

import java.io.*;

/**
 * Created by DSK20 on 15.12.2015.
 */
public class FileManager {
    public static int countFiles(String path) {
        int count = 0;
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                if (file.list() != null) {
                    for (String currentFile : file.list()) {
                        count += countFiles(path + "/" + currentFile);
                    }
                }
            } else {
                //System.out.println(path);
                count = 1;
            }
        }
        return count;
    }

    public static int countDirs(String path) {
        int count = 0;
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                count++;
                //System.out.println(path);
                if (file.list() != null) {
                    for (String currentFile : file.list()) {
                        count += countDirs(path + currentFile + "/");
                    }
                }
            }
        }
        return count;
    }

    public static boolean copyFile(String pathFrom, String pathTo) {
        File fileFrom = new File(pathFrom);
        File fileTo = new File(pathTo);
        if (fileTo.exists()) {
            fileTo.delete();
        }

        try {
            fileTo.createNewFile();
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileFrom));
                 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileTo))) {
                byte[] buffer = new byte[1000];
                int numBytes;
                while ((numBytes = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, numBytes);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean copy(String pathFrom, String pathTo) {
        File fileFrom = new File(pathFrom);
        File fileTo = new File(pathTo);
        if (fileFrom.isDirectory()) {
            fileTo.mkdir();
            if (fileFrom.list() != null) {
                for (String currentFile : fileFrom.list()) {
                    copy(fileFrom.getPath() + File.separator + currentFile, fileTo.getPath() + File.separator + currentFile);
                }
            }
        } else {
            copyFile(pathFrom, pathTo);
        }
        return true;
    }

    public static boolean move(String pathFrom, String pathTo) {
        copy(pathFrom, pathTo);
        File fileFrom = new File(pathFrom);
        fileFrom.delete();
        return true;
    }
}
