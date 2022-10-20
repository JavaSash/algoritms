package ru.stepenko.arrays;

import java.util.List;

public class DynamicArray<E> implements Array<E> {

    private final static int DEFAULT_LENGTH = 16;
    private final static double DEFAULT_THRESHOLD = 0.75;
    private int currentIndex = 0;
    private int size = 0;
    private Object[] data = new Object[DEFAULT_LENGTH];

    @Override
    public void add(Object element) {
        data[currentIndex] = element;
        currentIndex++;
        size++;
    }

    @Override
    public void addAll(List elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(int index) {
        for (int i = index; i < data.length - 1; i++) {
            data[index] = data[i + 1];
        }
        size--;
    }

    @Override
    public void removeAll(List elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        data = new Object[data.length];
        size = 0;
    }

    @Override
    public E get(int index) {
        return (E) data[index];
    }

    @Override
    public boolean contains(Object element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(Object element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(int index, Object element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return size;
    }
}
