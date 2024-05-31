package com.hk.corejava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReadWriteRunner {

    public static void main(String[] args) throws IOException {
        /* System.out.println("Current working directory: " + System.getProperty("user.dir")); */
        Path path = Paths.get("src/com/hk/corejava/test.txt");
        String name = Files.readString(path);
        System.out.println("name = " + name);
        Path newPath = Paths.get("src/com/hk/corejava/new_test.txt");
        Files.writeString(newPath,name.replace("Kumar", ""));
    }

}
