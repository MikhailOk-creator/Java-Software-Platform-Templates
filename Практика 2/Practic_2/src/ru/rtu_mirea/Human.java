package ru.rtu_mirea;

import java.time.LocalDate;

public class Human {
    public int age;
    public String FirstName;
    public String LastName;
    public LocalDate birthDate;
    private int weight;

    public Human(int age, String FirstName, String LastName, LocalDate birthDate, int weight) {
        this.age = age;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", birthDate=" + birthDate +
                ", weight=" + weight +
                '}';
    }
}
