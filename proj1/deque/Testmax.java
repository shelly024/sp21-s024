package deque;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class Testmax {
    @Test
    public void testMaxWithComparator() {
        MaxArrayDeque<Integer> deque = new MaxArrayDeque<>((a, b) -> a - b); // Example comparator for integers
        deque.addLast(5);
        deque.addLast(10);
        deque.addLast(3);
        System.out.print(deque.max());
    }
    @Test
    public void test2() {ArrayDeque<Integer> deque1 = new ArrayDeque<>();
        ArrayDeque<Integer> deque2 = new ArrayDeque<>();

        // 添加一些元素到 deque1
        deque1.addLast(1);
        deque1.addLast(2);
        deque1.addLast(4);

        // 添加相同的元素到 deque2
        deque2.addLast(1);
        deque2.addLast(2);
        deque2.addLast(4);

        // 比较 deque1 和 deque2 是否相等
        boolean result = deque1.equals(deque2);
        System.out.println("Test equals: " + result); // 应该打印 true
    }
    @Test
    public void test3() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(2);
        arrayDeque.addLast(2);
        arrayDeque.addLast(4);
        arrayDeque.removeLast();
        arrayDeque.addFirst(7);
        arrayDeque.removeFirst();

        LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<>();
        linkedListDeque.addLast(1);
        linkedListDeque.addLast(2);
        linkedListDeque.addLast(4);
        linkedListDeque.removeLast();
        linkedListDeque.addFirst(7);
        linkedListDeque.removeFirst();

        Boolean result = linkedListDeque.equals(arrayDeque);

        if (arrayDeque.size() == linkedListDeque.size()) {
            System.out.println("equal");
        }
        System.out.println(result);
        /*for (int i = 0; i < arrayDeque.size(); i++) {
            int element1 = arrayDeque.get(i);
            int element2 = linkedListDeque.get(i);
            if (element1 != element2) {
                System.out.println("inequal");
            }
        }*/
    }
}
