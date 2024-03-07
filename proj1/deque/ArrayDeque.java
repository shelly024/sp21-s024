package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size;
    private int i;
    private int nextfirst;
    private int nextlast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        i = 3;
        nextfirst = i;
        nextlast = i + 1;
    }

    private void relarge(int capacity) {
        T[] x = (T[]) new Object[capacity];
        int n;
        if (nextfirst < items.length - 1) {
            for (n = 0, i = nextfirst + 1; i < items.length; n += 1, i += 1) {
                x[n] = items[i];
            }
            for (n = items.length - (nextfirst + 1), i = 0; i <= nextfirst; n += 1, i += 1) {
                x[n] = items[i];
            }
        } else if (nextfirst == items.length - 1) {
            System.arraycopy(items, 0, x, 0, size);
        }
        nextlast = size;
        nextfirst = x.length - 1;
        items = x;
    }

    private void resmall(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int f = 0;
        if (nextfirst < items.length - 1) {
            if (nextfirst < nextlast) {
                for (i = nextfirst + 1, f = 0; f < size; f += 1, i += 1) {
                    a[f] = items[i];
                }
            } else if (nextfirst > nextlast) {
                for (i = nextfirst + 1, f = 0; i < items.length; f += 1, i += 1) {
                    a[f] = items[i];
                }
                for (i = 0, f = items.length - 1 - nextfirst; i < nextlast; f += 1, i += 1) {
                    a[f] = items[i];
                }
            }
        } else if (nextfirst == items.length - 1) {
            System.arraycopy(items, 0, a, 0, size);
        }
        nextfirst = a.length - 1;
        nextlast = size;
        items = a;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            relarge(size * 2);
        }
        items[nextfirst] = item;
        if (nextfirst == 0) {
            nextfirst = items.length - 1;
        } else {
            nextfirst = nextfirst - 1;
        }
        size = size + 1;
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            relarge(size * 2);
        }
        items[nextlast] = item;
        if (nextlast == items.length - 1) {
            nextlast = 0;
        } else {
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
        for (int n = 0; n < size; n += 1) {
            System.out.print(items[n] + " ");
        }
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (size < items.length / 4 && items.length >= 8) {
            resmall(size * 2);
        }
        if (nextfirst == items.length - 1) {
            T a = items[0];
            nextfirst = 0;
            size = size - 1;
            return a;
        }
        T a = items[nextfirst + 1];
        nextfirst = nextfirst + 1;
        size = size - 1;
        return a;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (size < items.length / 4 && items.length >= 8) {
            resmall(size * 2);
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
        int m = nextfirst + 1;
        T a;

        @Override
        public boolean hasNext() {
            return in != nextlast && m != nextlast;
        }

        @Override
        public T next() {
            if (nextfirst == items.length - 1) {
                a = items[in];
                in += 1;
            } else if (nextfirst < nextlast) {
                a = items[m];
                m += 1;
            } else if (nextfirst >= nextlast) {
                if (m < items.length) {
                    a = items[m];
                    m += 1;
                } else {
                    a = items[in];
                    in += 1;
                }
            }
            return a;
        }
    }

    public boolean equals(Object o) {
        if (o instanceof Deque) {
            Deque array = (Deque) o;
            if (array.size() != this.size) {
                return false;
            }
            for (i = 0; i < size; i += 1) {
                T x = this.get(i);
                T y = (T) array.get(i);
                if (!x.equals(y)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
