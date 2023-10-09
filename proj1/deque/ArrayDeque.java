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
            nextfirst = 7;
        }else {
            nextfirst = nextfirst - 1;
        }
        size = size + 1;
    }

    public void addLast(T item) {
        items[nextlast] = item;
        if (nextlast == 7) {
            nextlast = 0;
        }else {
            nextlast = nextlast + 1;
        }
        size = size + 1;
    }
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
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
        if (nextfirst == 7) {
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
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (nextlast == 0) {
            T b = items[7];
            nextlast = 7;
            size = size - 1;
            return b;
        }
        T b = items[nextlast - 1];
        nextlast = nextlast - 1;
        size = size - 1;
        return b;
    }
    public T get(int index) {
        if (index > 7 || index < 0) {
            return null;
        }
        return items[index];
    }
}
