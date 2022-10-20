package ru.stepenko.stack;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StackArrayListImpl<E> implements Stack<E> {

    private final List<E> stack = new ArrayList<>();

    @Override
    public void push(E element) {
        stack.add(element);
    }

    @Override
    public void pop() throws StackIsEmptyException {
        if (stack.isEmpty()) throw new StackIsEmptyException();
        stack.remove(stack.size() - 1);
    }

    @Override
    public void clear() {
        stack.clear();
    }

    @Override
    public E peek() {
        if(stack.isEmpty()) return null;
        return stack.get(stack.size() - 1);
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
