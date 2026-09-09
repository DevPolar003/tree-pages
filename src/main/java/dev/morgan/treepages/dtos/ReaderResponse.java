package dev.morgan.treepages.dtos;
import dev.morgan.treepages.models.Reader;

public record ReaderResponse(
        Long id,
        String username,
        String email
) {}
