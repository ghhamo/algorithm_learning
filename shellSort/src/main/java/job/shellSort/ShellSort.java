package job.shellSort;

public class ShellSort<V extends Comparable<V>> {

    public V[] sort(V[] collection) {
        int h = 1;
        while (h < collection.length) {
            h = h * 3 + 1;
        }
        h = (h - 1) / 3;
        while (h > 0) {
            for (int i = 0; h + i < collection.length; i++) {
                int left = i;
                int right = h + i;
                while (left > -1 && collection[right].compareTo(collection[left]) < 0) {
                    V temp = collection[left];
                    collection[left] = collection[right];
                    collection[right] = temp;
                    right = left;
                    left -= h;
                }
            }
            h = h / 3;
        }
        return collection;
    }
}
