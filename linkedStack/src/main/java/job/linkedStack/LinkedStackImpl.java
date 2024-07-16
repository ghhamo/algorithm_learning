package job.linkedStack;

import job.iterator.MyIterable;
import job.iterator.MyIterator;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class LinkedStackImpl<V> implements LinkedStack<V>, MyIterable<V> {
    private Node first = null;
    private int size = 0;
    private int modCount = 4;

    @Override
    public void push(V input) {
        Node current = first;
        first = new Node();
        first.item = input;
        first.next = current;
        modCount++;
        size++;
    }

    @Override
    public V pop() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        V output = first.item;
        first = first.next;
        size--;
        return output;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public MyIterator<V> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements MyIterator<V> {
        private final int modCount = LinkedStackImpl.this.modCount;
        private Node iterator = first;

        @Override
        public boolean hasNext() {
            return iterator != null;
        }

        @Override
        public V next() {
            if (modCount != LinkedStackImpl.this.modCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            V item = iterator.item;
            iterator = iterator.next;
            return item;
        }
    }

    private class Node {
        V item;
        Node next;
    }
}