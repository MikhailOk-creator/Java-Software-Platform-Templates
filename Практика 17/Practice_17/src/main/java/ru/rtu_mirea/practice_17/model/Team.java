package ru.rtu_mirea.practice_17.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "team")
@Getter
@Setter
public class Team {
    @Id
    @SequenceGenerator(name = "users_seq", sequenceName = "users_sequence", allocationSize = 1)
    @GeneratedValue(generator = "users_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "creationDate")
    private Date creationDate;

    @OneToMany(mappedBy = "team")
    private List<Footballer> footballerList;

    public Team() {
    }

    public Team(String name, Date creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }
}
