package ru.stepenko.queue;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import ru.stepenko.stack.Stack;
import ru.stepenko.stack.StackArrayListImpl;
import ru.stepenko.stack.StackIsEmptyException;

import java.util.Objects;

@Data
@Slf4j
public class QueueTwoStacksImpl<E> implements Queue<E> {

    private final Stack<E> push = new StackArrayListImpl<>();
    private final Stack<E> pull = new StackArrayListImpl<>();

    @Override
    public int size() {
        return push.size() + pull.size();
    }

    @Override
    public boolean isEmpty() {
        return push.isEmpty() && pull.isEmpty();
    }

    @Override
    public void add(E e) {
        push.push(e);
    }

    @Override
    public void clear() {
        push.clear();
        pull.clear();
    }

    @Override
    public E poll() {
        E element = pull.peek();
        try {
            if (Objects.nonNull(element)) {
                pull.pop();
                return element;
            }
            shift();
            element = pull.peek();
            pull.pop();
        } catch (StackIsEmptyException e) {
            log.warn("stack is empty");
        }
        return element;
    }

    @Override
    public E peek() {
        if (!pull.isEmpty()) return pull.peek();
        shift();
        return pull.peek();
    }

    private void shift() {
        try {
            while (true) {
                if (Objects.nonNull(push.peek())) pull.push(push.peek());
                push.pop();
            }
        } catch (StackIsEmptyException e) {
            log.warn("stack is empty");
        }
    }
}
