package ru.rtu_mirea.practice_19.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
@Getter
@Setter
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "creationDate")
    private String creationDate;

    @Column(name="footballer_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Footballer> footballers;
}
