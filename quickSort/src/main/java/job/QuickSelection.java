package job;

import job.shuffle.Shuffle;

public class QuickSelection<V extends Comparable<V>> {

    public V select(V[] arr, int k) {
        Shuffle<V> shuffle = new Shuffle<>();
        shuffle.shuffling(arr);
        int left = 0, right = arr.length - 1;
        while (right > left) {
            int j = partition(arr, left, right);
            if (j < k) {
                left = j + 1;
            } else if (j > k) {
                right = j - 1;
            } else {
                return arr[k];
            }
        }
        return arr[k];
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
