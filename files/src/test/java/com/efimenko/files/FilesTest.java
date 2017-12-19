package com.efimenko.files;

import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import static org.junit.Assert.*;
import java.io.UnsupportedEncodingException;
import org.junit.Before;
/**
 * Created by DSK20 on 14.12.2015.
 */
public class FilesTest {
    @Test
    public void FilePathTest() {
        File f = new File("test/.././file.txt");
        /*System.out.println("Name: "+f.getName());
        System.out.println("Path: "+f.getPath());
        System.out.println("Absolute Path: "+f.getAbsolutePath());
        try {
            System.out.println("Canonical Path: "+f.getCanonicalPath());
        }
        catch(Exception e) {}*/
    }

    @Test
    public void CreateFileTest() {
        FileTutor.createFile();
        File f = new File("tst/test.txt");
        assertTrue(f.exists());
    }

    @Test
    public void DeleteFileTest() {
        FileTutor.deleteFile();
        File f = new File("tst/test.txt");
        assertFalse(f.exists());
        assertFalse(new File("tst").exists());
    }

    @Before
    public void createFile() {
        File f1 = new File(RandomAccessTutor.FILES_TEST_PATH);
        try {
            f1.delete();
            f1.createNewFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Test
    public void testRandomAccess() throws UnsupportedEncodingException  {
        RandomAccessTutor.randomAccessWrite();
        String s = null;
        int i=-1;
        try {
            RandomAccessFile f = new RandomAccessFile(RandomAccessTutor.FILES_TEST_PATH, "r");
            i = f.readInt();
            s = f.readLine();
            f.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        assertEquals(i, 10);
        s = new String(s.getBytes("UTF-8"), "Unicode");
        assertEquals("test line", s);
        String read = RandomAccessTutor.randomAccessRead();
        read = new String(read.getBytes("UTF-8"), "Unicode");
        assertEquals("line", read);
    }

    @Test
    public void testFileStream() {
        FileStreamTutor.writeToFile();
        String s = FileStreamTutor.readFromFile();
        assertEquals(FileStreamTutor.TEST_LINE, s);
    }

    @Test
    public void testStream() {
        DataStreamTutor.writeToFile();
        String s = DataStreamTutor.readFromFile();
        assertEquals(DataStreamTutor.TEST_LINE, s);
    }

    @Test
    public void testFileManager() {
        assertEquals(1, FileManager.countFiles("test/"));
        assertEquals(0, FileManager.countFiles("tst/"));
        assertEquals(1, FileManager.countDirs("test/"));
        assertEquals(0, FileManager.countDirs("tst/"));
        //assertEquals(0, FileManager.countFiles("C:/Windows/System32/"));
        //assertEquals(0, FileManager.countDirs("C:/Windows/System32/"));
    }

    @Test
    public void testFileManagerCopy() {
        assertTrue(FileManager.copy("test.txt", "test/test.txt"));
        File fileTo = new File("test/test.txt");
        File fileFrom = new File("test.txt");
        assertEquals(fileFrom.length(),fileTo.length());
        assertTrue(fileTo.exists());
        assertTrue(FileManager.copy("test/", "files/"));
    }

    @Test
    public void testFileManagerDirsCopy() {
        assertTrue(FileManager.copy("test/", "files/"));
    }

}
