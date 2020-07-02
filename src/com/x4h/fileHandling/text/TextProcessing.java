package com.x4h.fileHandling.text;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class TextProcessing {

    /**
     * Read all bytes from a file into an array
     *
     * @param file_name Location of text file
     * @return Array of bytes
     * @throws IOException If location does not exist or is in an invalid format
     */
    @NotNull
    public static byte[] readText(String file_name) throws IOException {
        return Files.readAllBytes(Paths.get(file_name).toAbsolutePath());
    }

}
