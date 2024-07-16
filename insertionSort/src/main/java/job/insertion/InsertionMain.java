package job.insertion;

public class InsertionMain {
    public static void main(String[] args) {
        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        insertionSort.sort(new Integer[] {7,10,5,3,8,4,2,9,6});
    }
}
