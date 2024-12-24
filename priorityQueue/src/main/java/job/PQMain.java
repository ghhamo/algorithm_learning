package job;

public class PQMain {
    public static void main(String[] args) {
        UnorderedPQ<Integer> integerUnorderedPQ = new UnorderedPQ<>(10);
        integerUnorderedPQ.insert(5);
        integerUnorderedPQ.insert(9);
        integerUnorderedPQ.insert(2);
        integerUnorderedPQ.insert(4);
        integerUnorderedPQ.insert(0);
        integerUnorderedPQ.insert(6);
        integerUnorderedPQ.insert(1);
        integerUnorderedPQ.insert(3);
        integerUnorderedPQ.insert(8);
        integerUnorderedPQ.insert(7);
        integerUnorderedPQ.delMax();
        integerUnorderedPQ.delMax();
        integerUnorderedPQ.delMax();
    }
}