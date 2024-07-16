package job.arrayStack;

public class ArrayStackImpl<V> implements ArrayStack<V> {

    private int n;

    private V[] stack;

    public ArrayStackImpl(int size) {
        stack =  (V[]) new Object[size];
        n = 0;
    }

    @Override
    public void push(V input) {
        if (n == stack.length) resizeArray();
        stack[n++] = input;
    }

    @Override
    public V pop() {
        if (isEmpty()) return null;
        return stack[--n];
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    private void resizeArray() {
        V[] newInts = (V[]) new Object[2 * n];
        System.arraycopy(stack, 0, newInts, 0, stack.length);
        stack = newInts;
    }
}
