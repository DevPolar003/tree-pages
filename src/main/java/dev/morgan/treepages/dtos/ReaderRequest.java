package dev.morgan.treepages.dtos;

public record ReaderRequest(
        String name,
        String email,
        String password
) {
}
