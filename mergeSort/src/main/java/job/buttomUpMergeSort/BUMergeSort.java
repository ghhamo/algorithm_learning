package job.buttomUpMergeSort;

public class BUMergeSort {

    private int[] aux;

    private void merge(int[] original, int left, int mid, int right) {
        System.arraycopy(original, 0, aux, 0, original.length);
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                original[k] = aux[j++];
            } else if (j > right) {
                original[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                original[k] = aux[j++];
            } else {
                original[k] = aux[i++];
            }
        }
    }

    public void sort(int[] a) {
        int n = a.length;
        aux = new int[n];
        for (int sz = 1; sz < n; sz = sz + sz) {
            for (int lo = 0; lo < n - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
            }
        }
    }
}
