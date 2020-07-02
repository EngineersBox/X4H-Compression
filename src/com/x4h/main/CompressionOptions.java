package com.x4h.main;

public class CompressionOptions {

    private static final int MAX_CHUNK_DATA_SIZE = 100;
    private static final int MAX_CHUNK_SIZE = 500;

    public int data_size; // How large the total data_size is in byte length
    public int read_rate;
    public int write_rate;
    public int chunk_size; // How many bytes per chunk

    public CompressionOptions() {
        this(1000000000, 550, 500, 25);
    }

    public CompressionOptions(int data_size, int read_rate, int write_rate, int chunk_size) {
        this.data_size = Math.min(data_size, MAX_CHUNK_DATA_SIZE);
        this.read_rate = read_rate;
        this.write_rate = write_rate;
        this.chunk_size = Math.min(chunk_size, MAX_CHUNK_SIZE);
    }

}
