package ru.rtu_mirea;

public class GreenTea_Factory implements Tea_Factory{
    @Override
    public Indian_Tea create_IndianT() {
        return new Green_IndiaT();
    }

    @Override
    public Turkish_Tea create_TurkishT() {
        return new Black_TurkishT();
    }
}
