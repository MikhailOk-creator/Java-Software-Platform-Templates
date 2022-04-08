package ru.rtu_mirea;

public abstract class FactoryMethod {
    public void start() {
        Vinyl vinyl = playVinyl();
        vinyl.startVinyl();
        vinyl.endVinyl();
    }
    public abstract Vinyl playVinyl();
}
