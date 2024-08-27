package job.inplaceMergeSort;

public class IPMergeSort<V extends Comparable<V>> {

    public void sort(V[] origin, V[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(origin, aux, lo, mid);
        sort(origin, aux, mid + 1, hi);
        merge(origin, aux, lo, mid, hi);
    }

    private void merge(V[] original, V[] aux, int lo, int mid, int hi) {
        System.arraycopy(original, 0, aux, 0, original.length);
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                original[k] = aux[j++];
            } else if (j > hi) {
                original[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                original[k] = aux[j++];
            } else {
                original[k] = aux[i++];
            }
        }
    }

    private boolean less(V left, V right) {
        return left.compareTo(right) <= 0;
    }
}
