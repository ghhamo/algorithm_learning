package job.selection;

import java.util.List;

public class SelectionSort<V extends Comparable<V>> {


    public void sort(V[] collection) {
        int length = collection.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (collection[j].compareTo(collection[min]) < 0) {
                    min = j;
                }
            }
            V temp = collection[min];
            collection[min] = collection[i];
            collection[i] = temp;
        }
    }
}
