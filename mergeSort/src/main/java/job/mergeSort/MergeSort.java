package job.mergeSort;

public class MergeSort {
    private void merge(int[] arr, int left, int mid, int right) {
        int lLength = mid - left + 1;
        int rLength = right - mid;
        int[] l = new int[lLength];
        int[] r = new int[rLength];
        System.arraycopy(arr, left, l, 0, lLength);
        for (int i = 0; i < rLength; ++i) {
            r[i] = arr[mid + 1 + i];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < lLength && j < rLength) {
            if (l[i] <= r[j]) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }
        while (i < lLength) {
            arr[k++] = l[i++];
        }
        while (j < rLength) {
            arr[k++] = r[j++];
        }
    }

    void sort(int[] arr, int left, int right) {
        if (right <= left) return;
        int mid = left + (right - left) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}
