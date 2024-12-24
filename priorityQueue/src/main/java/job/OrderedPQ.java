package job;

import java.util.NoSuchElementException;

public class OrderedPQ<V extends Comparable<V>> {
    private Node first;
    private Node last;
    private int n;


    public void insert(V item) {
        n++;
        Node newNode = new Node();
        newNode.item = item;
        if (first == null) {
            first = newNode;
            last = first;
            return;
        }
        if (item.compareTo(first.item) <= 0) {
            newNode.next = first;
            first = newNode;
        } else if (item.compareTo(last.item) >= 0) {
            last.next = newNode;
            last = last.next;
        } else {
            Node currentNode = first;
            while (currentNode.next != null) {
                if (item.compareTo(currentNode.next.item) < 0) {
                    newNode.next = currentNode.next;
                    currentNode.next = newNode;
                    return;

                }
                currentNode = currentNode.next;
            }
        }
    }

    public V delMin() {
        if (n == 0) throw new NoSuchElementException();
        n--;
        V out = first.item;
        first = first.next;
        if (n == 0) last = null;
        return out;
    }


    private class Node {
        private V item;
        private Node next;
    }
}
