package job;

public class MaxHeap<V extends Comparable<V>> {

    private final V[] heap;
    private int n;

    public MaxHeap(int size) {
        heap = (V[]) new Comparable[size];
    }

    public void add(V item) {
        if (n >= heap.length) throw new RuntimeException();
        heap[n] = item;
        heapifyUp();
        n++;
    }

    public void delete() {
        heap[0] = heap[--n];
        heap[n] = null;
        heapifyDown(n);
    }

    public void sort() {
        int fixN = n;
        n--;
        for (int i = n; i > 0; i--, --n) {
            swap(0, i);
            heapifyDown(n);
        }
        n = fixN;
    }

    private void heapifyUp() {
        int i = n;
        while (i > 0 && heap[i].compareTo(heap[(i - 1) / 2]) > 0) {
            swap((i - 1) / 2, i);
            i = (i - 1) / 2;
        }
    }

    private void heapifyDown(int size) {
        int parent = 0;
        while (2 * parent + 1 < size) {
            int left = 2 * parent + 1;
            int right = 2 * parent + 2;
            int largerChild = (right < size && heap[right].compareTo(heap[left]) > 0) ? right : left;
            if (heap[parent].compareTo(heap[largerChild]) >= 0) {
                break;
            }
            swap(parent, largerChild);
            parent = largerChild;
        }
    }

    private void swap(int parent, int child) {
        V temp = heap[parent];
        heap[parent] = heap[child];
        heap[child] = temp;
    }

    public V peek() {
        if (n == 0) throw new RuntimeException();
        return heap[0];
    }
}
