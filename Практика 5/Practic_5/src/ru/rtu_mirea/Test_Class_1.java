package ru.rtu_mirea;

public class Test_Class_1 {
    private Test_Class_1() {
        System.out.println("Class Holder Singleton");
    }

    public static class SingletonHolder {
        public static final Test_Class_1 HOLDER_INSTANCE = new Test_Class_1();
    }

    public static Test_Class_1 getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }
}
