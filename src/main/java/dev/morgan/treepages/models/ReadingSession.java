package dev.morgan.treepages.models;

import dev.morgan.treepages.enums.ReadingStatus;
import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "reading_session")
public class ReadingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    private Book book;

    public long calculateMinutes(){
        return Duration.between(startTime, endTime).toMinutes();
    }
}
