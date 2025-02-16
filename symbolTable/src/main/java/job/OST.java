package job;

public class OST<K extends Comparable<K>, V extends Comparable<V>> {
    private K[] keys;
    private V[] values;
    private int currentLength;

    public OST(int size) {
        keys = (K[]) new Comparable[size];
        values = (V[]) new Comparable[size];
    }

    private int search(K k) {
        int l = 0;
        int r = currentLength - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (k.compareTo(keys[m]) == 0) {
                return m;
            } else if (k.compareTo(keys[m]) < 0) {
                r = m - 1;
            } else if (k.compareTo(keys[m]) > 0) {
                l = m + 1;
            }
        }
        return -1;
    }

    public V scan(K k) {
        if (keys == null ||  currentLength == 0) throw new IllegalArgumentException();
        int res = search(k);
        if (res == -1) {
            return null;
        }
        return values[res];
    }

    public void insert(K key, V value) {
        if (currentLength == keys.length) {
            resize();
        }
        if (currentLength == 0) {
            keys[0] = key;
            values[0] = value;
            currentLength++;
            return;
        }
        int res = search(key);
        if (res == -1) {
            keys[currentLength] = key;
            values[currentLength++] = value;
            insertionSort();
        } else {
            values[res] = value;
        }
    }

    private void insertionSort() {
        for (int i = 0; i < currentLength; i++) {
            for (int j = i; j > 0; j--) {
                if (keys[j].compareTo(keys[j - 1]) < 0) {
                    K kTemp = keys[j];
                    keys[j] = keys[j - 1];
                    keys[j - 1] = kTemp;
                    V vTemp = values[j];
                    values[j] = values[j - 1];
                    values[j - 1] = vTemp;
                } else break;
            }
        }
    }

    private void resize() {
        V[] copV = (V[]) new Comparable[currentLength * 2];
        System.arraycopy(values, 0, copV, 0, values.length);
        K[] copK = (K[]) new Comparable[currentLength * 2];
        System.arraycopy(keys, 0, copK, 0, keys.length);
        keys = copK;
        values = copV;
    }
}