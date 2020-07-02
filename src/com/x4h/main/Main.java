package com.x4h.main;

import com.x4h.fileHandling.image.ImageProcessing;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        String file_name = "src/com/x4h/main/test.png";
        BufferedImage data = ImageProcessing.readImage(file_name);
        byte[] b = ImageProcessing.convertBufferedImage(data);
        System.out.println(Arrays.toString(b));
        X4H x4h = new X4H();
//        byte[] compressed_data = x4h.compress(data);
    }

}
