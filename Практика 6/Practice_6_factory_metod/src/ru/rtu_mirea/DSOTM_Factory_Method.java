package ru.rtu_mirea;

public class DSOTM_Factory_Method extends FactoryMethod {
    @Override
    public Vinyl playVinyl() {
        return new The_Dark_Side_of_The_Moon();
    }
}
