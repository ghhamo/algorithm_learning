package job.inplaceMergeSort;

public class IPMergeSortMain {

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        IPMergeSort<Integer> ipMergeSort = new IPMergeSort<>();
        ipMergeSort.sort(integers, new Integer[integers.length], 0, integers.length - 1);
    }

}