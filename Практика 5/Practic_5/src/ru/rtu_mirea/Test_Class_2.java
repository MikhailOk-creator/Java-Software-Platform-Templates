package ru.rtu_mirea;

public enum Test_Class_2 {
    INSTANCE;
    public Test_Class_2 getInstance() {
        System.out.println("Enumeration");
        return INSTANCE;
    }
}
