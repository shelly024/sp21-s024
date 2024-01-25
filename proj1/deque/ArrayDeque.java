package deque;

import java.util.Iterator;

public class ArrayDeque<T>implements Deque<T>, Iterable<T>{
    public T[] items;
    public int size;
    public int i;
    public int nextfirst;
    public int nextlast;
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        i = 3;
        nextfirst = i;
        nextlast = i + 1;
    }
    @Override
    public void addFirst(T item) {
        items[nextfirst] = item;
        if (nextfirst == 0) {
            nextfirst = items.length - 1;
        }else {
            nextfirst = nextfirst - 1;
        }
        size = size + 1;
    }@Override
    public void addLast(T item) {
        items[nextlast] = item;
        if (nextlast == items.length - 1) {
            nextlast = 0;
        }else {
            nextlast = nextlast + 1;
        }
        size = size + 1;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        for(int i = 0;i < size;i+=1){
            System.out.print(items[i] + " ");
        }
    }
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (nextfirst == items.length - 1) {
            T a = items[0];
            nextfirst = 0;
            size = size - 1;
            return a;
        }
        T a = items[nextfirst+1];
        nextfirst = nextfirst + 1;
        size = size - 1;
        return a;
    }
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (nextlast == 0) {
            T b = items[items.length - 1];
            nextlast = items.length - 1;
            size = size - 1;
            return b;
        }
        T b = items[nextlast - 1];
        nextlast = nextlast - 1;
        size = size - 1;
        return b;
    }
    @Override
    public T get(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        }
        int a;
        if (nextfirst == items.length - 1) {
            return items[index];
        }
        if (nextfirst + 1 + index > items.length - 1) {
            a = nextfirst + 1 + index - (items.length - 1);
            return items[a - 1];
        }
        return items[nextfirst + 1 + index];
    }

    public Iterator<T> iterator() {
        return new ArayDequeIterator();
    }
    private class ArayDequeIterator implements Iterator<T> {
        int in = 0;
        @Override
        public boolean hasNext() {
            return in < size;
        }

        @Override
        public T next() {
            T a = get(in);
            in += 1;
            return a;
        }
    }
    public boolean equals(Object o) {
        if (o instanceof ArrayDeque Array) {
            if (Array.size != this.size) {
                return false;
            }
            for (T x : this.items) {
                if (!Array.contains(x)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public boolean contains(T x) {
        for (int i = 0; i < size; i += 1) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }
}
