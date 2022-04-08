package ru.rtu_mirea;

public class Main {

    public static void main(String[] args) {
        Hammers march = new Hammers(new MegafonAdapter());
        march.RunOnTheRoad();
    }
}
