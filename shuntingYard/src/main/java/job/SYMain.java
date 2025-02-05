package job;

import job.arrayStack.ArrayStack;

public class SYMain {
    public static void main(String[] args) {
        Yard yard = new Yard();
        ArrayStack<String> stack1 = yard.shuntingYard("(12 + 32^2/ -2 + ((25*3)/(23*-2)) +4--1)");
        String[] stack = new String[stack1.size()];
        for (int i = 0; i < stack.length; i++) {
            stack[stack.length - 1 - i] = stack1.pop();
        }
    }
}