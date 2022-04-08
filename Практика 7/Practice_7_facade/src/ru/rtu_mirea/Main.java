package ru.rtu_mirea;

public class Main {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.StartPC();
        System.out.print('\n' + "-------you working-------" + '\n'+'\n');
        facade.StopPC();
    }
}
