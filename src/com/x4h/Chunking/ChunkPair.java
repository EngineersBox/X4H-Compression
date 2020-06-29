package com.x4h.Chunking;

import org.jetbrains.annotations.NotNull;

public class ChunkPair {

    public byte[] chunk_a;
    public byte[] chunk_b;

    public ChunkPair(@NotNull byte[] chunk_a, @NotNull byte[] chunk_b) {
        this.chunk_a = chunk_a;
        this.chunk_b = chunk_b;
    }

}
