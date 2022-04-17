package ru.rtu_mirea.practice_14.model;

import java.util.Objects;

public class Footballer {
    private String firstName;
    private String lastName;

    public Footballer() {
    }

    public Footballer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Footballer footballer = (Footballer) o;
        return Objects.equals(firstName, footballer.firstName) && Objects.equals(lastName, footballer.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
