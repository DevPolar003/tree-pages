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
    @Column(name = "reading_status")
    @Enumerated(EnumType.STRING)
    private ReadingStatus status;
    @ManyToOne // MANY books belong to ONE reader
    private Reader reader;
    @ManyToOne  // MANY books belong to ONE garden
    private Garden garden;

}
