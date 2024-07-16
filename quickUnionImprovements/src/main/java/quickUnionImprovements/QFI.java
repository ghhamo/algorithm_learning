package quickUnionImprovements;

public class QFI {
    int[] id;
    int[] sizes;

    public QFI(int n) {
        id = new int[n];
        sizes = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sizes[i] = 1;
        }
    }

    public void union(int p, int q) {
        p = root(p);
        q = root(q);
        if (p == q) return;
        if (sizes[p] < sizes[q]) {
            id[p] = q;
            sizes[q] += sizes[p];
        } else {
            id[q] = p;
            sizes[p] += sizes[q];
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int current) {
        while (current != id[current]) {
            id[current] = id[id[current]];
            current = id[current];
        }
        return current;
    }
}