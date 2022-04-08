package ru.rtu_mirea;

public class Hammers {
    private March road;
    public Hammers(){}
    public Hammers(March road) {
        this.road = road;
    }
    public void RunOnTheRoad() {
        System.out.println("RUN LIKE HELL!");
        road.run();
        System.out.println("STOP");
    }
}
