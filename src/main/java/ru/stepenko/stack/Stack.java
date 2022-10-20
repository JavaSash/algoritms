package ru.stepenko.stack;

public interface Stack<E> {

    /**
     * Add element on top of stack
     * @param element
     */
    void push(E element);

    /**
     * Delete element from top
     *
     * @throws StackIsEmptyException when trying to delete element from empty stack
     */
    void pop() throws StackIsEmptyException;

    /**
     * Clear stack
     */
    void clear();

    /**
     * @return element from top
     */
    E peek();

    /**
     * @return stack size
     */
    int size();

    /**
     * @return true if stack is empty
     */
    boolean isEmpty();
}
