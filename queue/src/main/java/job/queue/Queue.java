package job.queue;

public interface Queue<V> {

     void enqueue(V input);
     V dequeue();
     boolean isEmpty();
}