package com.x4h.chunking;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.IntStream;

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
        IntStream.range(0, chunk_count)
            .parallel().forEach(i -> chunks.add(
                Arrays.copyOfRange(
                    data_bytes,
                    0,
                    Math.min(data_bytes.length, i + (chunk_count * chunk_size))
                )
            ));
        return chunks;
    }

    /**
     * Match up chunks by full size compatibility as less than or equal to
     *
     * @param chunks list of chunks
     * @return List of chunk pairs ordered by matching
     */
    @NotNull
    public static List<byte[]> meshChunks(@NotNull List<byte[]> chunks) {
        List<byte[]> sorted_chunks = new ArrayList<>();

        chunks.sort(new ByteArrayComparator());
        int chunks_length = (int) Math.ceil(chunks.size() / 2.0);

        IntStream.range(0, Math.floorDiv(chunks.size(), 2))
            .parallel().forEach(i -> {
                sorted_chunks.add(chunks.get(i));
                sorted_chunks.add(chunks.get(chunks_length + i));
            });
        if (chunks.size() % 2 != 0) {
            sorted_chunks.add(chunks.get(chunks_length - 1));
        }
        return sorted_chunks;
    }

    /**
     * Assert if two chunks satisfy:
     * {@code chunk_a + chunk_b <= max_chunk_size}
     *
     * @param byte_chunk_a First chunk
     * @param byte_chunk_b Second chunk
     * @return true if satisfied, false otherwise
     */
    public static boolean matchChunks(@NotNull byte[] byte_chunk_a, @NotNull byte[] byte_chunk_b, int max_chunk_size) {
        return new ByteArrayComparator().compare(byte_chunk_a, byte_chunk_b) < 0;
    }

}