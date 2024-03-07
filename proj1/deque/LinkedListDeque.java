package deque;
import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class IntNode {
        private T item;
        private IntNode prev;
        private IntNode next;
        private IntNode(IntNode p, T i, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }
    private IntNode sentinel;
    private int size;
    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    @Override
    public void addFirst(T item) {
        size = size + 1;
        if (size == 1) {
            IntNode first = new IntNode(sentinel, item, sentinel);
            sentinel.next = first;
            sentinel.prev = first;
        } else {
            IntNode currentfirst = sentinel.next;
            IntNode newfirst = new IntNode(sentinel, item, sentinel.next);
            sentinel.next = newfirst;
            currentfirst.prev = newfirst;
        }
    }
    @Override
    public void addLast(T item) {
        IntNode s = sentinel.prev;
        IntNode last = new IntNode(sentinel.prev, item, sentinel);
        s.next = last;
        last.prev = s;
        last.next = sentinel;
        sentinel.prev = last;
        size = size + 1;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        for (int i = 0; i <= size - 1; i += 1) {
            System.out.print(get(i) + " ");
        }
    }
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        IntNode x = sentinel.next;
        T a = sentinel.next.item;
        IntNode p = sentinel.next.next;
        sentinel.next = p;
        p.prev = sentinel;
        size = size - 1;
        x.next = null;
        x.prev = null;
        return a;
    }
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        IntNode x = sentinel.prev;
        IntNode p = sentinel.prev.prev;
        T a = sentinel.prev.item;
        sentinel.prev = p;
        sentinel.prev.next = sentinel;
        size = size - 1;
        x.next = null;
        x.prev = null;
        return a;
    }
    @Override
    public T get(int index) {
        IntNode p = sentinel;
        if (index < size && index >= 0) {
            for (int i = 0; i <= index; i += 1) {
                p = p.next;
            }
        } else {
            return null;
        }
        return p.item;
    }
    private T helper1(IntNode p, int index) {
        if (index == 0) {
            return p.item;
        }
        p = p.next;
        return helper1(p, index - 1);
    }
    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return helper1(sentinel.next, index);
    }
    public Iterator<T> iterator() {
        return new LListDequeIterator();
    }
    private class LListDequeIterator implements Iterator<T> {
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
        if (o instanceof Deque) {
            Deque array = (Deque) o;
            if (array.size() != this.size) {
                return false;
            }
            for (int i = 0; i < size; i += 1) {
                T x = this.get(i);
                T y = (T) array.get(i);
                if (x != y) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
