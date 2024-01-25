package deque;
import java.util.Comparator;
public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private int maxi;
    public MaxArrayDeque(Comparator<T> c) {
        items = (T[]) new Object[8];
        size = 0;
        maxi = 0;
        i = 3;
        nextfirst = i;
        nextlast = i + 1;
    }
    public T max() {
        if (items == null) {return null;}
        int maxa=0;
        return items[maxi];
    }
    public T max(Comparator<T> c) {
        if (items == null) {return null;}
        int maxi=0;
        for(int i=0;i<size;i += 1) {
            int result = c.compare(items[i],items[maxi]);
            if (result > 0) {
                maxi = i;
            }
        }
        return items[maxi];
    }
}
