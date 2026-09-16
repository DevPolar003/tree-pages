package dev.morgan.treepages.controllers;


import dev.morgan.treepages.dtos.ReaderRequest;
import dev.morgan.treepages.models.Reader;
import dev.morgan.treepages.services.ReaderService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth/register")
public class AuthController {

    private final ReaderService service;
    PasswordEncoder encoder;

    public AuthController(ReaderService service) {
        this.service = service;
    }

    @PostMapping
    public Reader register(@RequestBody ReaderRequest reader) {
        return service.save(reader);
    }
}
