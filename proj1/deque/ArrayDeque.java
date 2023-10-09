package deque;
public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int i;
    private int nextfirst;
    private int nextlast;
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        i = 3;
        nextfirst = i - 1;
        nextlast = i + 1;
    }
    public void addFirst(T item) {
        items[nextfirst] = item;
        if (nextfirst == 0) {
            nextfirst = size - 1;
        }else {
            nextfirst = nextfirst - 1;
        }
        size = size + 1;
    }

    public void addLast(T item) {
        items[nextlast] = item;
        if (nextlast == size - 1) {
            nextlast = 0;
        }else {
            nextlast = nextlast + 1;
        }
        size = size + 1;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        for(int i = 0;i < size;i+=1){
            System.out.print(items[i] + " ");
        }
    }
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (nextfirst == size) {
            T a = items[0];
            items[0] = null;
            nextfirst = 0;
            size = size - 1;
            return a;
        }
        T a = items[nextfirst+1];
        items[nextfirst+1] = null;
        size = size - 1;
        return a;
    }
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (nextlast == 0) {
            T b = items[size-1];
            items[size-1] = null;
            nextlast = size - 1;
            size = size - 1;
            return b;
        }
        T b = items[nextlast - 1];
        items[nextlast - 1] = null;
        size = size - 1;
        return b;
    }
    public T get(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        }
        return items[index];
    }
}
