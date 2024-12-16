package lab6;

import java.util.*;

/**
 * Lab6Task - типізована колекція на основі однозв'язного списку,
 * яка реалізує інтерфейс Set.
 *
 * @param <T> тип елементів колекції
 */
public class Lab6Task<T> implements Set<T> {

    /**
     * Вузол однозв'язного списку.
     */
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> head;
    private int size;

    /**
     * Порожній конструктор.
     */
    public Lab6Task() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Конструктор, що приймає один елемент.
     *
     * @param element початковий елемент
     */
    public Lab6Task(T element) {
        this();
        add(element);
    }

    /**
     * Конструктор, що приймає колекцію.
     *
     * @param collection початкова колекція
     */
    public Lab6Task(Collection<? extends T> collection) {
        this();
        addAll(collection);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(current.data, o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public <E> E[] toArray(E[] a) {
        if (a.length < size) {
            a = (E[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        Node<T> current = head;
        int index = 0;
        Object[] result = a;
        while (current != null) {
            result[index++] = current.data;
            current = current.next;
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(T t) {
        if (contains(t)) {
            return false;
        }
        head = new Node<>(t, head);
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            if (Objects.equals(current.data, o)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T element : c) {
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            if (!c.contains(current.data)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                modified = true;
            } else {
                previous = current;
            }
            current = current.next;
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object element : c) {
            if (remove(element)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

}
