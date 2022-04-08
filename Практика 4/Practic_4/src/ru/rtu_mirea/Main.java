package ru.rtu_mirea;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService eS = Executors.newFixedThreadPool(10);
        eS.submit(() -> {
           try {
               int sum = 0;
               for (int i = 0; i < 10; i++) {
                   sum++;
               }
               System.out.print(sum);
               Thread.sleep(2000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("We run it");
        });
        eS.submit(()->System.out.println("Start"));
    }
}
