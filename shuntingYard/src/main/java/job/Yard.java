package job;

import job.arrayStack.ArrayStack;
import job.arrayStack.ArrayStackImpl;

import java.util.ArrayList;
import java.util.List;

public class Yard {
    private static final int sub = 1;
    private static final int add = 1;
    private static final int div = 2;
    private static final int mul = 2;
    private static final int par = 3;
    private final ArrayStack<String> out = new ArrayStackImpl<>(30);
    private final ArrayStack<Character> operator = new ArrayStackImpl<>(30);
    private final List<String> tokens = new ArrayList<>();

    private void tokenize(String expression) {
        expression = expression.replace(" ", "");
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < expression.length() - 1; i++) {
            char current = expression.charAt(i);
            char next = expression.charAt(i + 1);
            if (current >= '0' && current <= '9' || current == '.') {
                token.append(current);
                if (!(next >= '0' && next <= '9')) {
                    if (next != '.') {
                        tokens.add(String.valueOf(token));
                        token = new StringBuilder();
                    }
                }
            } else {
                if (current == '-') {
                    if (i == 0 || !(expression.charAt(i - 1) >= '0' && expression.charAt(i - 1) <= '9')) {
                        token.append(current);
                    } else {
                        tokens.add(String.valueOf(current));
                    }
                } else {
                    tokens.add(String.valueOf(current));
                }
            }
        }
        token.append(expression.charAt(expression.length() - 1));
        tokens.add(String.valueOf(token));
    }

    public ArrayStack<String> shuntingYard(String expression) {
        tokenize(expression);
        for (String token : tokens) {
            if (token.equals("^") || token.equals("(") ||
                    token.equals(")") || token.equals("*") ||
                    token.equals("/") || token.equals("+") || token.equals("-")) {
                pushOperator(token);
            } else {
                out.push(token);
            }
        }
        int size = operator.size();
        for (int i = 0; i < size; i++) {
            out.push(String.valueOf(operator.pop()));
        }
        return out;
    }

    private void f(int precedence) {
        for (int j = operator.size(); j > 0; j--) {
            int lastOperator = getPrecedence(operator.getLast());
            if (lastOperator != par && lastOperator >= precedence) {
                out.push(String.valueOf(operator.pop()));
            } else {
                break;
            }
        }
    }

    private int getPrecedence(char c) {
        return switch (c) {
            case '^' -> 4;
            case '(' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> throw new IllegalArgumentException();
        };
    }

    private void pushOperator(String token) {
        switch (token) {
            case ")":
                while (true) {
                    char c = operator.pop();
                    if (c != '(') {
                        out.push(String.valueOf(c));
                    } else {
                        break;
                    }
                }
                break;
            case "^":
                operator.push('^');
                break;
            case "(":
                operator.push('(');
                break;
            case "*":
                f(mul);
                operator.push('*');
                break;
            case "/":
                f(div);
                operator.push('/');
                break;
            case "+":
                f(add);
                operator.push('+');
                break;
            case "-":
                f(sub);
                operator.push('-');
                break;
        }
    }
}