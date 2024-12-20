package job;

import job.shuffle.Shuffle;

public class ThreeWayQuickSort<V extends Comparable<V>> {

    public void sort(V[] el) {
        Shuffle<V> shuffle = new Shuffle<>();
        shuffle.shuffling(el);
        sort(el, 0, el.length - 1);
    }
    
    private void sort(V[] elements, int left, int right) {
        if (left >= right) return;
        int lt = left, i = lt + 1, gt = right;
        V pivot = elements[left];
        while (i <= gt) {
            int equality = elements[i].compareTo(pivot);
            if (equality < 0) {
                swap(elements, lt++, i++);
            } else if (equality > 0) {
                swap(elements, i, gt--);
            } else {
                i++;
            }
        }
        sort(elements, left, lt - 1);
        sort(elements, gt + 1, right);
    }

    private void swap(V[] spase, int first, int second) {
        V temp = spase[first];
        spase[first] = spase[second];
        spase[second] = temp;
    }
}
