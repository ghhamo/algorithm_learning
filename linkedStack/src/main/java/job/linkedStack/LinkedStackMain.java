package job.linkedStack;

import job.iterator.MyIterator;

public class LinkedStackMain {
    public static void main(String[] args) {
        LinkedStackImpl<String> stack = new LinkedStackImpl<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        MyIterator<String> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}