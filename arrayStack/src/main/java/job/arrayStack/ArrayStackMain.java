package job.arrayStack;

public class ArrayStackMain {
    public static void main(String[] args) {
        ArrayStackImpl<String> ed = new ArrayStackImpl<>(12);
        ed.push("df");
        String d = ed.pop();
        d = ed.pop();
    }
}