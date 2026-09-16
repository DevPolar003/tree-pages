package dev.morgan.treepages.services;

import dev.morgan.treepages.dtos.ReaderRequest;
import dev.morgan.treepages.dtos.ReaderResponse;
import dev.morgan.treepages.models.Reader;
import dev.morgan.treepages.repositories.ReaderRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {

    private final ReaderRepository repository;
    private final PasswordEncoder encoder; // also dependence injection

    public ReaderService(ReaderRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public List<ReaderResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(reader -> new ReaderResponse(
                        reader.getId(),
                        reader.getName(),
                        reader.getEmail()
                ))
                .toList();
    }

    public Reader save(ReaderRequest reader) {

        Reader r = new Reader();
        r.setEmail(reader.email());
        r.setName(reader.name());
        String hash = encoder.encode(reader.password());
        r.setPassword(hash);

        return repository.save(r);
    }
}
