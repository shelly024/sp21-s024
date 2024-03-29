package deque;
import java.util.Comparator;
public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c) {
        super();
        comparator = c;
    }
    public T max() {
        if (isEmpty()) {
            return null;
        }
        T max = get(0);
        for (T element : this) {
            if (comparator.compare(element, max) > 0) {
                max = element;
            }
        }
        return max;
    }
    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T max = get(0);
        for (T element : this) {
            if (c.compare(element, max) > 0) {
                max = element;
            }
        }
        return max;
    }
}
