package job;

public class UnorderedPQ<V extends Comparable<V>> {
    private V[] table;
    private int n;

    public UnorderedPQ(int capacity) {
        table = (V[]) new Comparable[capacity];
    }

    private void resize() {
        V[] cop = (V[]) new Object[table.length * 2];
        System.arraycopy(table, 0, cop, 0, table.length);
        table = cop;
    }

    public void insert(V item) {
        if (n >= table.length) {
            resize();
        }
        table[n++] = item;
    }

    public V delMax() {
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (table[max].compareTo(table[i]) < 0) {
                max = i;
            }
        }
        V temp = table[max];
        table[max] = table[n - 1];
        table[--n] = temp;
        return temp;
    }
}
