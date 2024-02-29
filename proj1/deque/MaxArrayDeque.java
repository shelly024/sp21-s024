package deque;
import java.util.Comparator;
import java.util.ArrayDeque;
public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private T[] items;
    private int size;
    private int i;
    private int nextfirst;
    private int nextlast;
    private Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c) {
        items = (T[]) new Object[8];
        size = 0;
        i = 3;
        nextfirst = i;
        nextlast = i + 1;
        comparator = c;
    }
    public T max() {
        if (isEmpty()) {
            return null;
        }
        T max = items[0];
        for (T x : this) {
            if (comparator.compare(x,max) > 0) {
                max = x;
            }
        }
        return max;
    }
    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T max = items[0];
        for (T element : this) {
            if (c.compare(element, max) > 0) {
                max = element;
            }
        }
        return max;
    }
}
