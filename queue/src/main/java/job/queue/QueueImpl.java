package job.queue;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class QueueImpl<V> implements Queue<V> {

    private Node first;
    private Node last;

    public void enqueue(V input) {
        Node prev = last;
        last = new Node();
        last.item = input;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            prev.next = last;
        }
    }

    public V dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        V out = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        return out;
    }

    public boolean isEmpty() {
        return first == null;
    }

    private class Node {
        V item;
        Node next;
    }
}
