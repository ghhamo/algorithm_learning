package job.bubbleSort;

import java.util.Arrays;

public class BubbleMain {
    public static void main(String[] args) {
        Bubble<Integer> integerBubble = new Bubble<>();
        System.out.println(Arrays.toString(integerBubble.bubbleSort(new Integer[]{1, 5, 2, 8, 4, 6, 0, 8, 3, 2, 3, 4, 6, 4,})));
    }
}
