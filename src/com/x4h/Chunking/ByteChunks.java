package com.x4h.Chunking;

import javafx.collections.transformation.SortedList;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public abstract class ByteChunks {

    /**
     * Split a byte array into a list of byte chunks of a given length or less if required
     *
     * @param data_bytes Byte sectioned data to group into chunks
     * @param chunk_size Sizes of chunks to section
     * @return List of chunks
     */
    @NotNull
    public static List<byte[]> chunkSplit(@NotNull byte[] data_bytes, int chunk_size) {
        List<byte[]> chunks = new ArrayList<>();
        int chunk_count = data_bytes.length / chunk_size;
        for (int i=0; i < chunk_count; i++) {
            chunks.add(
                Arrays.copyOfRange(
                    data_bytes,
                    0,
                    Math.min(data_bytes.length, i + (chunk_count * chunk_size))
                )
            );
        }
        return chunks;
    }

    public static SortedList<ChunkPair> meshChunks(@NotNull List<byte[]> chunks) {
        List<ChunkPair> sorted_chunks = new ArrayList<>();
        chunks.sort(new ByteArrayComparator());
    }

    public static boolean matchChunks(@NotNull byte[] byte_chunk_a, @NotNull byte[] byte_chunk_b) {

    }

}
