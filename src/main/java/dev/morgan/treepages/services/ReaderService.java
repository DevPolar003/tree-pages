package dev.morgan.treepages.services;
import dev.morgan.treepages.models.Reader;
import dev.morgan.treepages.repositories.ReaderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReaderService {

    private final ReaderRepository repository;

    public ReaderService(ReaderRepository repository) {
        this.repository = repository;
    }

    public List<Reader> getAll() {
        return repository.findAll();
    }

    public Reader save(Reader reader) {
        return repository.save(reader);
    }
}
