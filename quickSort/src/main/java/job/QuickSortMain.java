package job;

public class QuickSortMain {
    public static void main(String[] args) {
        QuickSort<Integer> quickSort = new QuickSort<>();
        Integer[] i = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        i = quickSort.sort(i);
        int r = 4;
    }
}