package deque;

import java.util.LinkedList;

public class LinkedListDeque<T> {
    private class IntNode {
        public T item;
        public IntNode prev;
        public IntNode next;
        public IntNode(IntNode p,T i,IntNode n){
            prev = p;
            item = i;
            next = n;
        }
    }
    private IntNode sentinel;
    private int size;
    public LinkedListDeque() {
        sentinel=new IntNode(null,null,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size=0;
    }
    public LinkedListDeque(T x) {
        sentinel = new IntNode(null,null,null);
        sentinel.next = new IntNode(sentinel,x,sentinel);
        sentinel.prev = sentinel.next;
        size=1;
    }
    public void addFirst(T item) {
        sentinel.next = new IntNode(sentinel,item,sentinel.next);
        sentinel.prev = sentinel.next;
        size = size + 1;
    }
    public void addLast(T item) {
        IntNode s = sentinel.prev;
        sentinel.prev = new IntNode(sentinel.prev,item,sentinel);
        s.next = sentinel.prev;
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
        for(int i=0;i<=size-1;i+=1){
            System.out.print(get(i) + " ");
        }
    }
    public T removeFirst() {
        if (size == 0){
            return null;
        }
        IntNode x = sentinel.next;
        T a = sentinel.next.item;
        IntNode p = sentinel.next.next;
        sentinel.next = p;
        sentinel.next.prev = sentinel;
        size = size - 1;
        x.next = null;x.prev = null;
        return a;
    }
    public T removeLast() {
        if (size == 0){
            return null;
        }
        IntNode x = sentinel.prev;
        IntNode p = sentinel.prev.prev;
        T a = sentinel.prev.item;
        sentinel.prev = p;
        sentinel.prev.next = sentinel;
        size = size - 1;
        x.next = null;x.prev = null;
        return a;
    }
    public T get(int index) {
        IntNode p = sentinel;
        if (index < size){
            for(int i = 0;i <= index;i+=1){
                p = p.next;
            }
        }else {
            return null;
        }
        return p.item;
    }
}
