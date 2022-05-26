package ru.rtu_mirea.practice_24.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "teams")
@Getter
@Setter
@NoArgsConstructor
public class Team {
    @Id
    /*@SequenceGenerator(name = "users_seq", sequenceName = "users_sequence", allocationSize = 1)
    @GeneratedValue(generator = "users_seq", strategy = GenerationType.SEQUENCE)*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "creationDate")
    private String creationDate;

    public Team(String name, String creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="footballer_id")
    @JsonIgnore
    private Footballer footballer;
}
