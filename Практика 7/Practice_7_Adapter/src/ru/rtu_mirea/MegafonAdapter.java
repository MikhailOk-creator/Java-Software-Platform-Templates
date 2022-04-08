package ru.rtu_mirea;

public class MegafonAdapter implements March {
    private Megafon megafon;
    public MegafonAdapter() {
        megafon = new Megafon();
    }
    public void run() {
        megafon.Speech();
    }
}
