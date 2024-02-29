package deque;
import java.util.Comparator;
import java.util.ArrayDeque;
public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private int maxi;
    private Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c) {
        super();
        comparator = c;
    }
    public T max() {
        if (isEmpty()) {
            return null;
        }
        maxi = 0;
        T max = getFirst();
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
        T max = getFirst();
        for (T element : this) {
            if (c.compare(element, max) > 0) {
                max = element;
            }
        }
        return max;
    }
}
