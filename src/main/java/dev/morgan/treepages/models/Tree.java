package dev.morgan.treepages.models;

import dev.morgan.treepages.enums.TreeType;
import jakarta.persistence.*;

@Entity
@Table (name = "Tree")
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (name = "growth_progress")
    private Integer growthProgress;
    @Column (name = "tree_type")
    @Enumerated(EnumType.STRING)
    private TreeType treeType;
    @OneToOne
    private Book book;
    @ManyToOne
    private Garden garden;
    }
