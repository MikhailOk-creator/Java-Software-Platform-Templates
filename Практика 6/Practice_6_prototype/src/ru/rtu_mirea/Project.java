package ru.rtu_mirea;

public class Project implements Copy{
    private int id;
    private String name;
    private String author;

    public Project(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    @Override
    public Project copy() {
        return new Project(id, name, author);
    }

    @Override
    public String toString() {
        return id +", " + name + ", " + author ;
    }
}
