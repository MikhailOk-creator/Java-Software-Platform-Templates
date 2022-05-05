package ru.rtu_mirea.practice_18.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "footballers")
@Getter
@Setter
public class Footballer {
    @Id
    /*@SequenceGenerator(name = "users_seq", sequenceName = "users_sequence", allocationSize = 1)
    @GeneratedValue(generator = "users_seq", strategy = GenerationType.SEQUENCE)*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;

    public Footballer() {
    }

    public Footballer(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
    private List<Team> teams;*/
}
