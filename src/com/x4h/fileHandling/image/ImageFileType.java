package com.x4h.fileHandling.image;

public enum ImageFileType {

    DNG("dng"),
    TIFF("tiff"),
    SVG("svg"),
    BMP("bmp"),
    PNG("png"),
    JPG("jpg");

    private String file_extension;

    ImageFileType(String file_extension) {
        this.file_extension = file_extension;
    }

    /**
     * Get the file extension associated with the enum value
     *
     * @return File extension
     */
    String getFileExtension() {
        return this.file_extension;
    }

}
