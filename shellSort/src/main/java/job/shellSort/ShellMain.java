package job.shellSort;

public class ShellMain {
    public static void main(String[] args) {
        ShellSort<Integer> shellSort = new ShellSort<>();
        shellSort.sort(new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
    }
}
