package com.marcelANDevertjan.main.Assignment.Scenario1;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Marcel and Evert-Jan on 26-1-2015.
 */
public class CustomQueue<E> implements Collection<E> {
    LinkedList<E> list = new LinkedList<E>();
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return list.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return list.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    public void enqueue(E object) {
        list.addLast(object);
    }

    public E dequeue(E object) {
        return list.poll();
    }

    public E peek(E object) {
        return list.peek();
    }
}
