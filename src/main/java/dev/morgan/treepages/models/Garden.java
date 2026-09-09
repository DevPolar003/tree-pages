package dev.morgan.treepages.models;

import dev.morgan.treepages.enums.Theme;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "Garden")
public class Garden {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nome")
    private String name;
    @Enumerated(EnumType.STRING)
    private Theme theme;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @ManyToOne
    private Reader reader;

}
