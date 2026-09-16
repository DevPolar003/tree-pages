package dev.morgan.treepages.models;

import jakarta.persistence.*;

import java.util.List;


@Table(name = "Reader")
@Entity(name = "Reader")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    @Column(name = "password_hash")
    private String password;
    private Integer wallet = 0;
    @Column(name = "streak_days")
    private Integer streakDays = 0;
    @Column(name = "total_minutes_read")
    private Integer totalMinutesRead = 0;
    @OneToMany(mappedBy = "reader")
    private List<Garden> gardens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getWallet() {
        return wallet;
    }

    public void setWallet(Integer wallet) {
        this.wallet = wallet;
    }

    public Integer getStreakDays() {
        return streakDays;
    }

    public void setStreakDays(Integer streakDays) {
        this.streakDays = streakDays;
    }

    public Integer getTotalMinutesRead() {
        return totalMinutesRead;
    }

    public void setTotalMinutesRead(Integer totalMinutesRead) {
        this.totalMinutesRead = totalMinutesRead;
    }
}
