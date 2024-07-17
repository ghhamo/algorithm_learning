package job.shellSort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ShellSortTest {

    @Test
    void sortTest() {
        Random random = new Random();
        int n = random.nextInt(0, 50);
        Integer[] ints = new Integer[n];
        for (int i = 0; i < n; i++) {
            ints[i] = random.nextInt(0, 50);
        }
        ShellSort<Integer> shellSort = new ShellSort<>();
        Integer[] sorted = shellSort.sort(ints);
        Arrays.sort(ints);
        assertArrayEquals(ints, sorted);

    }
}