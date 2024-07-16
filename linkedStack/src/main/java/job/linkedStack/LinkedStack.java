package job.linkedStack;

public interface LinkedStack<V> {

    public void push(V input);
    public V pop();

    public boolean isEmpty();

    int getSize();
}
