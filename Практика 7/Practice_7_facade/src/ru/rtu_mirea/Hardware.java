package ru.rtu_mirea;

public class Hardware implements PC{
    @Override
    public void turnOn() {
        System.out.println("The power button is pressed");
    }

    @Override
    public void turnOff() {
        System.out.print("Self-shutdown");
    }
}
