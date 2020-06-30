package com.x4h.main;

import com.x4h.chunking.ByteChunks;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class X4H implements X4HBase {

    private CompressionOptions compressionOptions;

    public X4H() {
        new X4H(new CompressionOptions());
    }

    public X4H(CompressionOptions compressionOptions) {
        this.compressionOptions = compressionOptions;
    }

    @NotNull
    public byte[] compress(@NotNull byte[] data) {
        List<byte[]> chunks = ByteChunks.chunkSplit(data, this.compressionOptions.chunk_size);
        chunks = ByteChunks.meshChunks(chunks);
        return data;
    }

    @NotNull
    public byte[] decompress(@NotNull byte[] data) {
        return data;
    }

}
