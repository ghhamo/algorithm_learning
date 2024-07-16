package job.selection;

public class SelectionMain {
    public static void main(String[] args) {
        SelectionSort<Integer> selectionSort = new SelectionSort<>();
        selectionSort.sort(new Integer[]{2, 4, 6, 3, 1, 234, 5, 34, 5, 7, 9, 13, 45, 6, 7, 76, 45, 4, 3, 21, 6, 7, 8, 76, 43, 32, 21, 10, 1});
    }
}
