package ru.rtu_mirea;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MapWithLock<E, G> extends HashMap<E, G> implements Map<E, G> {
    private static final Lock lock = new ReentrantLock();

    @Override
    public int size() {
        lock.lock();
        int t = super.size();
        lock.unlock();
        return t;
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        boolean t = super.isEmpty();
        lock.unlock();
        return t;
    }

    @Override
    public boolean containsKey(Object key) {
        lock.lock();
        boolean t = super.containsKey(key);
        lock.unlock();
        return t;
    }

    @Override
    public boolean containsValue(Object value) {
        lock.lock();
        boolean t = super.containsValue(value);
        lock.unlock();
        return t;
    }

    @Override
    public G get(Object key) {
        lock.lock();
        G t = super.get(key);
        lock.unlock();
        return t;
    }

    @Override
    public G put(E key, G value) {
        lock.lock();
        G t = super.put(key, value);
        lock.unlock();
        return t;
    }

    @Override
    public G remove(Object key) {
        lock.lock();
        G t = super.remove(key);
        lock.unlock();
        return t;
    }

    @Override
    public void putAll(Map<? extends E, ? extends G> m) {
        lock.lock();
        super.putAll(m);
        lock.unlock();
    }

    @Override
    public void clear() {
        lock.lock();
        super.clear();
        lock.unlock();
    }

    @Override
    public Set<E> keySet() {
        lock.lock();
        Set<E> r = super.keySet();
        lock.unlock();
        return r;
    }

    @Override
    public Collection<G> values() {
        lock.lock();
        Collection<G> r = super.values();
        lock.unlock();
        return r;
    }

    @Override
    public Set<Entry<E, G>> entrySet() {
        lock.lock();
        Set<Entry<E, G>> r = super.entrySet();
        lock.unlock();
        return r;
    }
}
