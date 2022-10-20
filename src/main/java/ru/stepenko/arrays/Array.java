package ru.stepenko.arrays;

import java.util.List;

public interface Array<E> {

    void add(E element);

    void addAll(List<E> elements);

    void remove(int index);

    void removeAll(List<E> elements);

    void clear();

    E get(int index);

    boolean contains(E element);

    boolean isEmpty();

    int indexOf(E element);

    void set(int index, E element);

    int size();
}
