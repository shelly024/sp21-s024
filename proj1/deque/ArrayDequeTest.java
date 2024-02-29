package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void gettest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        lld1.addLast(3);
        lld1.addLast(4);
        lld1.addLast(5);
        lld1.addLast(2);
        lld1.addLast(0);
        lld1.addLast(9);
        lld1.addLast(0);
        int a = lld1.get(5);
        int b = lld1.get(6);
        int c = lld1.get(0);
        assertEquals(9, a);
        assertEquals(0, b);
        assertEquals(null, lld1.get(7));
        assertEquals(3, c);
    }
    @Test
    public void gettest2() {
        ArrayDeque<Integer> lld2 = new ArrayDeque<Integer>();
        lld2.addFirst(8);
        lld2.addFirst(4);
        lld2.addFirst(5);
        lld2.addFirst(2);
        lld2.addFirst(0);
        lld2.addFirst(5);
        lld2.addFirst(3);
        int b = lld2.get(0);
        int a = lld2.get(6);
        assertEquals(3, b);
        assertEquals(8, a);
        assertEquals(null, lld2.get(7));
    }
    @Test
    public void gettest3() {
        ArrayDeque<Integer> lld3 = new ArrayDeque<Integer>();
        lld3.addFirst(3);
        lld3.addLast(6);
        lld3.addFirst(4);
        lld3.addFirst(5);
        lld3.addFirst(2);
        lld3.addFirst(0);
        lld3.addFirst(9);
        lld3.addLast(0);
        int b = lld3.get(0);
        int a = lld3.get(3);
        int c = lld3.get(2);
        int d = lld3.get(7);
        int e = lld3.get(5);
        int f = lld3.get(6);
        assertEquals(9, b);
        assertEquals(2, c);
        assertEquals(5, a);
        assertEquals(0, d);
        assertEquals(3, e);
        assertEquals(6, f);
        assertEquals(null, lld3.get(8));
        assertEquals(null, lld3.get(-1));
    }
    @Test
    public void gettest4() {
        ArrayDeque<Integer> lld4 = new ArrayDeque<Integer>();
        lld4.addFirst(0);
        lld4.addLast(1);
        lld4.addLast(2);
        lld4.addLast(3);
        lld4.addLast(4);
        int a = lld4.get(2);
        lld4.addFirst(6);
        int b = lld4.get(2);
        lld4.addLast(8);
        lld4.addLast(9);
        int c = lld4.get(4);
        lld4.addLast(13);
        lld4.addFirst(15);
        lld4.addLast(16);
        lld4.addFirst(3);
        lld4.addLast(17);
        lld4.addFirst(2);
        lld4.addFirst(1);
        lld4.addFirst(7);
        lld4.addFirst(8);
        lld4.addFirst(0);
        lld4.addFirst(9);
        lld4.addLast(17);
        lld4.addLast(17);
        lld4.addLast(17);
        lld4.addLast(17);
        lld4.addLast(17);
        lld4.addLast(1);
        lld4.addLast(1);
        lld4.addLast(1);
        lld4.addLast(1);
        lld4.addLast(1);
        lld4.removeLast();
        lld4.removeLast();
        lld4.removeLast();
        lld4.removeLast();
        lld4.removeLast();
        lld4.removeLast();
        lld4.removeLast();
        lld4.removeLast();
        lld4.removeLast();
        lld4.removeLast();
        lld4.removeLast();
        lld4.removeLast();
        lld4.removeLast();
        lld4.removeLast();
        lld4.removeLast();
        lld4.removeLast();
        lld4.removeLast();
        lld4.removeLast();
        lld4.removeLast();
        lld4.removeLast();
        lld4.removeLast();
        lld4.removeLast();
        lld4.removeLast();
        lld4.removeLast();
        int d = lld4.get(0);
    }
    @Test
    public void gettest5() {
        ArrayDeque<Integer> lld5 = new ArrayDeque<Integer>();
        lld5.addLast(0);
        lld5.removeLast();
        lld5.addFirst(2);
        lld5.removeFirst();
        lld5.addFirst(4);
        lld5.addLast(5);
        lld5.get(0);
        lld5.removeFirst();
        lld5.get(0);
        lld5.removeFirst();
        lld5.addLast(10);
        lld5.removeFirst();
        lld5.addLast(12);
        lld5.get(0);
        lld5.removeFirst();
        lld5.addLast(15);
        lld5.addLast(16);
        lld5.addFirst(17);
        lld5.removeLast();
    }
    @Test
    public void gettest6() {
        ArrayDeque<Integer> a = new ArrayDeque<Integer>();
        a.addFirst(0);
        a.addFirst(1);
        a.addLast(2);
        a.removeFirst();
        a.removeLast();
        a.addLast(5);
        a.addFirst(6);
        a.addFirst(7);
        a.removeLast();
        a.addFirst(9);
        a.addFirst(10);
        a.get(0);
        a.get(1);
        a.get(2);
        a.get(3);
        a.get(4);
        assertEquals("Should have the same value", 9, (double) a.get(1), 0.0);
    }
}