package ru.rtu_mirea;

import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.Semaphore;

public class SetWithSemaphore<E> extends HashSet<E> {
    private final Semaphore semaphore = new Semaphore(1);

    @Override
    public boolean add(E e) {
        boolean t = false;
        try {
            semaphore.acquire();
            t = super.add(e);
            semaphore.release();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        return t;
    }

    public boolean remove(Object o) {
        boolean t = false;
        try {
            semaphore.acquire();
            t = super.remove(o);
            semaphore.release();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        return t;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean t = false;
        try {
            semaphore.acquire();
            t = super.removeAll(c);
            semaphore.release();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        return t;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean t = false;
        try {
            semaphore.acquire();
            t = super.addAll(c);
            semaphore.release();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        return t;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean ret = false;
        try {
            semaphore.acquire();
            ret = super.retainAll(c);
            semaphore.release();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        return ret;
    }

    @Override
    public int size() {
        int t = 0;
        try {
            semaphore.acquire();
            t = super.size();
            semaphore.release();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        return t;
    }
}
