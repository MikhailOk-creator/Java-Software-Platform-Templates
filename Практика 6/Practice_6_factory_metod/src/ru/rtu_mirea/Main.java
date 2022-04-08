package ru.rtu_mirea;

public class Main {

    public static void main(String[] args) {
	    FactoryMethod vinyl1 = new DSOTM_Factory_Method();
        FactoryMethod vinyl2 = new The_Wall_Factory_Method();
        vinyl1.start();
        vinyl2.start();
    }
}
