package job.insertion;


public class InsertionSort<V extends Comparable<V>> {

    public void sort(V[] co) {
        for (int i = 0; i < co.length; i++) {
            for (int j = i; j > 0; j--) {
                if (co[j].compareTo(co[j - 1]) < 0) {
                    V temp = co[j];
                    co[j] = co[j - 1];
                    co[j - 1] = temp;
                } else break;
            }
        }
    }
}
