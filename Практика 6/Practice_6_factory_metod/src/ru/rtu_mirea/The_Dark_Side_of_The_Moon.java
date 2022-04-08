package ru.rtu_mirea;

public class The_Dark_Side_of_The_Moon implements Vinyl{
    @Override
    public void startVinyl() {
        System.out.println("I've been mad for fucking years, absolutely years, been over the edge for yonks, been working me buns off for bands...");
    }

    @Override
    public void endVinyl() {
        System.out.print("There is no Dark side of the Moon. In matter fact it's all dark." + '\n');
    }
}
