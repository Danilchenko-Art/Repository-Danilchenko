import java.util.Arrays;
import java.util.NoSuchElementException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
interface Stack<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
}

// Класc ArrayStack.java
class ArrayStack<T> implements Stack<T> {
    private final int capacity;
    private Object[] elements;
    private int top = -1;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.elements = new Object[this.capacity];
    }

    @Override
    public void push(T item) {
        if (top + 1 >= capacity) throw new IllegalStateException("Стек полон");
        elements[++top] = item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Стек пуст");
        return (T) elements[top--];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Стек пуст");
        return (T) elements[top];
    }

    @Override
    public boolean isEmpty() {
        return top < 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(elements, 0, top + 1));
    }
}


public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new ArrayStack<>(5); // Создаем стек строк длиной 5

        stack.push("Москва");
        stack.push("Санкт-Петербург");
        stack.push("Казань");

        System.out.println(stack.peek());      // Выведет 'Казань'
        System.out.println(stack.pop());       // Удалит и выведет 'Казань'
        System.out.println(stack.isEmpty());   // false

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}