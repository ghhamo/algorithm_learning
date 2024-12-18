package job;

import job.shuffle.Shuffle;

public class QuickSort<V extends Comparable<V>> {

    public V[] sort(V[] items) {
        Shuffle<V> shuffle = new Shuffle<>();
        return sort(shuffle.shuffling(items), 0, items.length - 1);
    }

    private V[] sort(V[] arr, int left, int right) {
        if (left >= right) return arr;
        int pivot = partition(arr, left, right);
        sort(arr, left, pivot - 1);
        sort(arr, pivot + 1, right);
        return arr;
    }

    private int partition(V[] arr, int left, int right) {
        int i = left, j = right + 1;
        while (true) {
            while (arr[++i].compareTo(arr[left]) < 0) {
                if (i == right) break;
            }
            while (arr[--j].compareTo(arr[left]) > 0) {
                if (j == left) break;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, left, j);
        return j;
    }

    private void swap(V[] spase, int first, int second) {
        V temp = spase[first];
        spase[first] = spase[second];
        spase[second] = temp;
    }
}
