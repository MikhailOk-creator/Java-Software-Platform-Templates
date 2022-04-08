package ru.rtu_mirea;

public class OS implements PC{
    @Override
    public void turnOn() {
        System.out.println("OS: Welcome");
    }

    @Override
    public void turnOff() {
        System.out.println("OS: Shut down");
    }
}
