package job;

public class ST<K, V> {
    private MLList list;

    public V scan(K key) {
        MLList current = list;
        while (current != null) {
            if (key.equals(current.key)) {
                System.out.println("\"" + current.key + "\"" +  current.value);
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void insert(K k, V v) {
        if (list == null) {
            list = new MLList(k, v);
            return;
        }
        MLList current = list;
        while (current != null) {
            if (k.equals(current.key)) {
                current.value = v;
                return;
            }
            current = current.next;
        }
        current = list;
        list = new MLList(k, v);
        list.next = current;

    }

    private class MLList {
        private final K key;
        private V value;
        private MLList next;

        public MLList(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
