package job.shuffle;

import java.util.Random;

public class Shuffle<V extends Comparable<V>> {

    public V[] shuffling(V[] collection) {
        Random random = new Random();
        for (int i = 0; i < collection.length - 1; i++) {
            V left = collection[i];
            int rightIndex = random.nextInt(i + 1, collection.length);
            collection[i] = collection[rightIndex];
            collection[rightIndex] = left;

        }
        return collection;
    }
}
