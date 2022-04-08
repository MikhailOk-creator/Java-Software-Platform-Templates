package ru.rtu_mirea;

public class Facade {
    private OS Windows10;
    private Hardware dream_config;
    public Facade() {
        Windows10 = new OS();
        dream_config = new Hardware();
    }
    public void StartPC() {
        dream_config.turnOn();
        Windows10.turnOn();
    }
    public void StopPC() {
        Windows10.turnOff();
        dream_config.turnOff();
    }
}
