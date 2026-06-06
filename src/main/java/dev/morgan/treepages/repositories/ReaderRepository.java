package dev.morgan.treepages.repositories;

import dev.morgan.treepages.models.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository <Reader, Integer> {}