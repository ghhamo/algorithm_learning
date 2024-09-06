package job.hashMap;

import java.util.Objects;

public class HashMap<K, V> {
    private Node<K, V>[] table;
    private int current;
    private int capacity;
    private final float loadFactor;

    public HashMap() {
        this.table = new Node[16];
        this.current = 0;
        this.loadFactor = 0.75f;
        this.capacity = 12;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> cur = table[index];
        Node<K, V> newNod = new Node<>(key, value);
        if (cur == null) {
            table[index] = newNod;
        } else {
            while (true) {
                if (key.equals(cur.getKey())) {
                    cur.setValue(value);
                    return;
                } else if (cur.next == null) {
                    cur.next = newNod;
                    break;
                }
                cur = cur.next;
            }
        }
        current++;
        if (current == capacity) {
            increaseTable();
        }
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> cur = table[index];
        if (table[index] == null) return null;
        while (cur != null) {
            if (key.equals(cur.getKey())) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        Node<K, V> cur = table[index];
        if (cur == null) return;
        if (cur.getKey().equals(key)) {
            if (cur.next == null) {
                table[index] = null;
                return;
            }
            table[index] = table[index].next;
            return;
        }
        while (cur.next != null) {
            if (cur.next.getKey().equals(key)) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }

    public boolean contains(K key) {
        int index = getIndex(key);
        Node<K, V> node = table[index];
        while (node != null) {
            if (key.equals(node.getKey())) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    private void increaseTable() {
        Node<K, V>[] copy = table;
        table = new Node[copy.length * 2];
        capacity = (int) (loadFactor * table.length);
        current = 0;
        rehashing(copy);
    }

    private void rehashing(Node<K, V>[] nodes) {
        for (Node<K, V> node : nodes) {
            while (node != null) {
                put(node.getKey(), node.getValue());
                node = node.next;
            }
        }
    }

    private int getIndex(K key) {
        int hash = key.hashCode() % table.length;
        if (hash < -1) {
            hash = hash * -1;
        }
        return hash;
    }

    private static class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node<?, ?> node)) return false;
            return Objects.equals(key, node.key);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key);
        }
    }
}
