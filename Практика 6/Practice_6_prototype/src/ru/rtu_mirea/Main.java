package ru.rtu_mirea;

public class Main {

    public static void main(String[] args) {
        Project project = new Project(30111979, "The Wall", "Pink Floyd");
        Project copy = project.copy();
        System.out.println(copy);
    }
}
