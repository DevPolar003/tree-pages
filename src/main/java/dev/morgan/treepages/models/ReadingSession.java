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
    @Column (name = "start_time")
    private LocalDateTime startTime;
    @Column (name = "end_time")
    private LocalDateTime endTime;
    @Column (name = "duration_minutes")
    private Long durationMinutes;
    @ManyToOne
    private Book book;
    @ManyToOne
    private Reader reader;

    public Long calculateMinutes(){
        return Duration.between(startTime, endTime).toMinutes();
    }
}
