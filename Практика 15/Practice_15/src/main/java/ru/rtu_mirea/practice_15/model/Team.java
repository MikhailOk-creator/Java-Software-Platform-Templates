package ru.rtu_mirea.practice_15.model;

import java.util.ArrayList;
import java.util.Date;

import lombok.Data;

@Data
public class Team {
    private String name;
    private Date creationDate;
    private ArrayList<Footballer> footballers = new ArrayList<>();

    public Team(String name, Date creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }
    public void addFootballer(Footballer footballer) {
        footballers.add(footballer);
    }
}
