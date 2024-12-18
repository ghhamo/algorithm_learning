package job.mergeSort;

public class MergeSortMain {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] ar = new int[]{5, 4, 3, 2, 1};
        mergeSort.sort(ar, 0, ar.length - 1);
    }
}