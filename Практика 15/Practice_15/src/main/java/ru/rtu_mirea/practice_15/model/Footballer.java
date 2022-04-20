package ru.rtu_mirea.practice_15.model;

import lombok.Data;

@Data
public class Footballer {
    private String firstName;
    private String lastName;

    public Footballer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
