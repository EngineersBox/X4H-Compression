package com.x4h.main;

import com.x4h.chunking.ByteChunks;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class X4H implements X4HBase {

    private CompressionOptions compressionOptions;

    public X4H() {
        this(new CompressionOptions());
    }

    public X4H(CompressionOptions compressionOptions) {
        this.compressionOptions = compressionOptions;
    }

    @NotNull
    public byte[] compress(@NotNull byte[] data) {
        List<byte[]> chunks = ByteChunks.chunkSplit(data, this.compressionOptions.chunk_size);
        chunks = ByteChunks.meshChunks(chunks);

        int total_array_length = chunks.stream().mapToInt(c -> c.length).sum();
        byte[] byte_array = new byte[total_array_length];

        AtomicInteger arr_idx = new AtomicInteger();
        chunks.forEach(c -> {
            for (int i = 0; i < c.length; i++) {
                byte_array[arr_idx.get() + i] = c[i];
            }
            arr_idx.getAndAdd(c.length);
        });
        return byte_array;
    }

    @NotNull
    public byte[] decompress(@NotNull byte[] data) {
        return data;
    }

}
