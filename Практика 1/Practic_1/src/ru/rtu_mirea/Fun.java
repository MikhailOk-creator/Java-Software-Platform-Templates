package ru.rtu_mirea;

import java.util.Arrays;
import java.util.function.Consumer;

public class Fun implements Consumer {

    @Override
    public void accept(Object o) {
        Arrays.sort((int[])o);
        System.out.println(Arrays.toString((int[]) o));
    }
}
