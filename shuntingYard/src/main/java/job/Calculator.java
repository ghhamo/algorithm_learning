package job;

import job.arrayStack.ArrayStack;
import job.arrayStack.ArrayStackImpl;

public class Calculator {
    public double calculator(String[] postfix) {
        ArrayStack<Double> stack = new ArrayStackImpl<>(16);
        int size = postfix.length;
        for (int i = 0; i < size; i++) {
            if (f(postfix[i])) {
                double k = calculate(stack.pop(), stack.pop(), postfix[i]);
                stack.push(k);
            } else if (!f(postfix[i + 1])) {
                stack.push(Double.valueOf(postfix[i]));
            } else {
                double k = calculate(Double.valueOf(postfix[i]), stack.pop(), postfix[i + 1]);
                stack.push(k);
                i++;

            }
        }
        return stack.pop();
    }

    private boolean f(String s) {
        return s.equals("^") || s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-");
    }

    private double calculate(Double s1, Double s2, String operator) {
        switch (operator) {
            case "-":
                return s2 - s1;
            case "+":
                return s2 + s1;
            case "*":
                return s2 * s1;
            case "/":
                return s2 / s1;
            case "^":
                double res = s2;
                for (int i = 0; i < s1 - 1; i++) {
                    res *= s2;
                }
                return res;

            default:
                throw new RuntimeException();
        }
    }
}
