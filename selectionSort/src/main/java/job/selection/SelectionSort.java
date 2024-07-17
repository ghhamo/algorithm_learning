package job.selection;

public class SelectionSort<V extends Comparable<V>> {


    public void sort(V[] collection) {
        for (int i = 0; i < collection.length; i++) {
            int min = i;
            for (int j = i + 1; j < collection.length; j++) {
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
