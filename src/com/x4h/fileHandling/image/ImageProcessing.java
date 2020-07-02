package com.x4h.fileHandling.image;

import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class ImageProcessing {

    /**
     * Read an image file into a byte array
     *
     * @param file_name Location of image file
     * @param file_type  Enum value from ImageFileType
     * @return byte[]
     * @throws IOException If location does not exist or is in an invalid format
     */
    @NotNull
    public static byte[] readImageBytes(@NotNull String file_name, @NotNull ImageFileType file_type) throws IOException {
        BufferedImage image = ImageIO.read(new File(file_name));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, file_type.getFileExtension(), baos);
        baos.flush();
        byte[] image_data = baos.toByteArray();
        baos.close();
        return image_data;
    }

    /**
     * Read an image file into a BufferedImage
     *
     * @param file_name Location of image file
     * @return BufferedImage
     * @throws IOException If location does not exist or is in an invalid format
     */
    @NotNull
    public static BufferedImage readImage(@NotNull String file_name) throws IOException {
       return ImageIO.read(new File(file_name));
    }

    public static int getBitLength(int number) {
        return BigInteger.valueOf(number).bitLength();
    }

    @NotNull
    public static List<Byte> convertIntToByte(int number, int bit_length) {
        int byte_count = (int) Math.ceil(bit_length / 8.0);
        List<Byte> bytes = new ArrayList<>();
        bytes.add((byte) (number & 0xFF));
        if (bit_length <= 8) {
            return bytes;
        }
        for (int b = 0; b < byte_count - 1; b++) {
            number >>= 8;
            bytes.add((byte) (number & 0xFF));
        }
        return bytes;
    }

    @NotNull
    public static byte[] convertBufferedImage(@NotNull BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        List<Byte> image_data = new ArrayList<>();
        int largest = 0;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int current_rgb = image.getRGB(x, y);
                int current_bit_length = getBitLength(current_rgb);
                largest = Math.max(largest, current_bit_length);
                image_data.addAll(convertIntToByte(current_rgb, current_bit_length));
            }
        }
        byte[] return_data = new byte[image_data.size()];
        for (int i = 0; i < return_data.length; i++) {
            return_data[i] = image_data.get(i);
        }
        return return_data;
    }

    /**
     * Write buffered image data to a location of a given format
     *
     * @param file_name Location to write image data to
     * @param image BufferedImage data
     * @param file_type Enum value from ImageFileType
     * @throws IOException If location does not exist or is in an invalid format
     */
    public static void writeImage(@NotNull String file_name, @NotNull BufferedImage image, @NotNull ImageFileType file_type) throws IOException {
        ImageIO.write(image, file_type.getFileExtension(), new File(file_name));
    }

}
