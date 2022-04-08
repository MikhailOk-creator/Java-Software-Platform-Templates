package ru.rtu_mirea;

public class The_Wall implements Vinyl{
    @Override
    public void startVinyl() {
        System.out.println("...we came in?");
    }

    @Override
    public void endVinyl() {
        System.out.println("Isn't this where...");
    }
}
