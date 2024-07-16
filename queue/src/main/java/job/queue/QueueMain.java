package job.queue;

public class QueueMain {
    public static void main(String[] args) {
        QueueImpl<Integer> integerQueue = new QueueImpl<>();
        integerQueue.enqueue(1);
        integerQueue.enqueue(2);
        integerQueue.enqueue(3);
        integerQueue.enqueue(4);
        integerQueue.enqueue(5);
        integerQueue.enqueue(6);
        System.out.println(integerQueue.dequeue());
        System.out.println(integerQueue.dequeue());
        System.out.println(integerQueue.dequeue());
        System.out.println(integerQueue.dequeue());
        System.out.println(integerQueue.dequeue());
        System.out.println(integerQueue.dequeue());
    }
}