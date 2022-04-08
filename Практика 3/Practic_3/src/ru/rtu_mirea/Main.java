package ru.rtu_mirea;

public class Main {

    static SetWithSemaphore<String> MySS = new SetWithSemaphore<String>();
    static MapWithLock<Integer, String> MyML = new MapWithLock<>();

    static class Th1 extends Thread{
        @Override
        public void run() {
            MySS.add("Was Ich Liebe");
            MySS.add("Links 2 3 4");
            MySS.add("Tattoo");
            MySS.add("Sehnsucht");
            MySS.add("Zeig Dich");
            System.out.println(MySS.remove("Zeig Dich"));
            System.out.println(MySS.size());
        }
    }
    static class Th2 extends Thread{
        @Override
        public void run() {
            MyML.put(1, "Popov");
            MyML.put(2, "Zikov");
            MyML.put(3, "Akopyan");
            System.out.println(MyML.containsKey(3));
            MyML.remove(2);
            System.out.println(MyML.size());
        }
    }

    public static void main(String[] args) {
        Th1 t11 = new Th1();
        Th1 t12 = new Th1();
        t11.start();
        t12.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("---------------------");

        Th2 th21 = new Th2();
        Th2 th22 = new Th2();
        th21.start();
        th22.start();
    }
}
