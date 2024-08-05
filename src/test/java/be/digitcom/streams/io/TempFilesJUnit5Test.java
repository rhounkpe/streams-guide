package be.digitcom.streams.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;


import static org.junit.jupiter.api.Assertions.assertTrue;

//@SpringBootTest
public class TempFilesJUnit5Test {
    Path path1, path2;
    File file1, file2;

    /**
     * This folder and the files created in it will be deleted after
     * tests are run, even in the event of failures or exceptions.
     */
    @TempDir
    Path tempDir;


    /**
     * Executed before every test: create two temporary files
     */
    @BeforeEach
    public void setUp() {
        try {
            path1 = Files.createTempDirectory(Paths.get( "C:\\labs\\io-data" ), "tmpDirPrefix");
            System.out.println(path1);
            path2 = tempDir.resolve("testfile2.txt");
            System.out.println(path2);
        } catch (InvalidPathException ipe) {
            System.err.println(
                    "error when creating temporary test file in " +
                            this.getClass().getSimpleName()
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        file1 = path1.toFile();
        file2 = path2.toFile();
    }

    @Disabled
    @Test
    public void test2TempFiles() {
        // Write out data to the test files
        try {
            FileWriter fw1 = new FileWriter(file1);
            BufferedWriter bw1 = new BufferedWriter(fw1);
            bw1.write("Content for file1");
            bw1.close();

//            FileWriter fw2 = new FileWriter(file2);
//            BufferedWriter bw2 = new BufferedWriter(fw2);
//            bw2.write("Content for file2");
//            bw2.close();
        } catch (IOException e) {
            System.out.println("Error creating temporary test file in " +  this.getClass().getSimpleName());
            throw new RuntimeException(e);
        }

        assertTrue(file1.exists());
//        assertTrue(file2.exists());
//
//        assertEquals(file1.length(), 17L);
//        assertEquals(file1.length(), file2.length());
//
//        assertTrue(file1.getAbsoluteFile().toPath().endsWith("testfile1.txt"));
    }
}
