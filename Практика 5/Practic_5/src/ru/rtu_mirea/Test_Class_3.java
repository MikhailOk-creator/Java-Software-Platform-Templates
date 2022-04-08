package ru.rtu_mirea;

public class Test_Class_3 {
    private static Test_Class_3 INSTANCE = new Test_Class_3();

    private Test_Class_3() {
        System.out.println("Lazy Initialization");
    }

    public static synchronized Test_Class_3 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Test_Class_3();
            return INSTANCE;
        }
        return INSTANCE;
    }
}
