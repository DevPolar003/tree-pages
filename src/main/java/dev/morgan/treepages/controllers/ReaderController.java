package dev.morgan.treepages.controllers;

import dev.morgan.treepages.dtos.ReaderRequest;
import dev.morgan.treepages.dtos.ReaderResponse;
import dev.morgan.treepages.models.Reader;
import dev.morgan.treepages.services.ReaderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/readers")
public class ReaderController {

        private final ReaderService service;

        public ReaderController(ReaderService service) {
            this.service = service;
        }

        @GetMapping
        public List<ReaderResponse> getAll() {
            return service.getAll();
        }

        @PostMapping
        public Reader create(@RequestBody ReaderRequest request) {
            return service.save(request);
        }
    }

