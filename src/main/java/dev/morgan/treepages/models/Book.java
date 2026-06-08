package dev.morgan.treepages.models;

import dev.morgan.treepages.enums.ReadingStatus;
import jakarta.persistence.*;

@Entity
@Table (name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private Integer pageCount;
    @Enumerated(EnumType.STRING)
    private ReadingStatus status;

}
