package ru.stepenko.queue;

public interface Queue<E> {

    int size();

    boolean isEmpty();

    void add(E e);

    void clear();

    E poll();

    E peek();
}
