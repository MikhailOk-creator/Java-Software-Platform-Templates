package ru.rtu_mirea;

public class The_Wall_Factory_Method extends FactoryMethod{
    @Override
    public Vinyl playVinyl() {
        return new The_Wall();
    }
}
