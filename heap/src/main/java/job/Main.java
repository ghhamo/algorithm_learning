package job;

public class Main {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(10);
        maxHeap.add(1);
        maxHeap.add(9);
        maxHeap.add(2);
        maxHeap.add(8);
        maxHeap.add(3);
        maxHeap.add(7);
        maxHeap.add(4);
        maxHeap.add(6);
        maxHeap.add(0);
        maxHeap.add(5);
        maxHeap.sort();
    }
}