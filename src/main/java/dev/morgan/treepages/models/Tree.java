package dev.morgan.treepages.models;

import jakarta.persistence.*;

@Entity
@Table (name = "Tree")
public class Tree {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
