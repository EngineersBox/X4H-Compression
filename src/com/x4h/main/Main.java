package com.x4h.main;

import com.x4h.fileHandling.image.ImageFileType;
import com.x4h.fileHandling.image.ImageProcessing;
import com.x4h.fileHandling.text.TextProcessing;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {

    private static String WDIR = "src/com/x4h/main/";

    /**
     * Find percentage difference between two numbers
     *
     * @param a Smaller number (a <= b)
     * @param b Larger number (b >= a)
     * @return Percentage difference
     */
    public static float percentageDiff(float a, float b) {
        return ((b - a) / b) * 100;
    }

    /**
     * Display compression statistics
     *
     * @param raw_length Length of uncompressed data (array/list)
     * @param compressed_length Length of compressed data (array/list)
     */
    public static void showDifference(int raw_length, int compressed_length) {
        System.out.println("Compressed image length: " + compressed_length + " bytes");
        System.out.println("Raw image length: " + raw_length + " bytes");
        System.out.println("Percentage difference: " + percentageDiff(compressed_length, raw_length) + "%");
        System.out.println("Raw difference: " + (raw_length - compressed_length) + " bytes");
    }

    public static void main(String[] args) throws IOException {
        String input_file = WDIR + "test2.jpg";
        String output_file = WDIR + "test3.jpg";
        BufferedImage data = ImageProcessing.readImage(input_file);


        byte[] b = ImageProcessing.readImageBytes(input_file, ImageFileType.JPG);
        TextProcessing.writeBytes(b, WDIR + "test_output.txt");

        b = ImageProcessing.convertBufferedImage(data);
//        TextProcessing.writeBytes(b, WDIR +"test_output.txt");

//        ImageProcessing.writeImage(output_file, b, ImageFileType.JPG);
        TextProcessing.writeBytes(b, output_file);
        showDifference((data.getWidth() * data.getHeight()) * 4, b.length);


//        System.out.println(Arrays.toString(b));
        X4H x4h = new X4H();
//        byte[] compressed_data = x4h.compress(data);
    }

}
