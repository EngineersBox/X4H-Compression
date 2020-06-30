package com.x4h.fileHandling.image;

import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileProcessing {

    /**
     * Read an image file into a BufferedImage
     *
     * @param file_name Location of image file
     * @return BufferedImage
     * @throws IOException If location does not exist or is in an invalid format
     */
    public BufferedImage readImage(String file_name) throws IOException {
        return ImageIO.read(new File(file_name));
    }

    /**
     * Write buffered image data to a location of a given format
     *
     * @param file_name Location to write image data to
     * @param image BufferedImage data
     * @param file_type Enum value from ImageFileType
     * @throws IOException If location does not exist or is in an invalid format
     */
    public void writeImage(String file_name, BufferedImage image, @NotNull ImageFileType file_type) throws IOException {
        ImageIO.write(image, file_type.getFileExtension(), new File(file_name));
    }

}
