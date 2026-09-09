package dev.morgan.treepages.services;
import dev.morgan.treepages.dtos.ReaderRequest;
import dev.morgan.treepages.dtos.ReaderResponse;
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

    public Reader save(ReaderRequest request) {
        Reader reader = new Reader();
        reader.setName(request.username());
        return repository.save(reader);
    }
}
