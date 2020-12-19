package com.erik.day18;

import com.erik.AdventDay;

import java.util.Stack;

public class Day18 implements AdventDay {
    private final String[] input;

    public Day18(String[] input) {
        this.input = input;
    }

    public long part1() {
        long sum = 0;
        for (String term : input) {
            sum += evaluate(term);
        }
        return sum;
    }

    private long evaluate(String term) {
        String[] splits = term.split(" ");
        Stack<Long> numbers = new Stack<>();
        Stack<String> operators = new Stack<>();

        for (String split : splits) {
            if (isOperator(split)) {
                if (operators.isEmpty() || operators.peek().equals("(")) {
                    operators.push(split);
                    continue;
                }
                long res = calculate(numbers.pop(), numbers.pop(), operators.pop());
                numbers.push(res);
                operators.push(split);
                continue;
            }
            //number
            if (split.contains("(")) {
                int countOpen = 0;
                for (int i=0; i<split.length(); i++) {
                    if (split.charAt(i) == '(') {
                        countOpen++;
                        operators.push("(");
                    }
                }
                numbers.push(Long.parseLong(split.substring(countOpen)));
                continue;
            }
            if (split.contains(")")) {
                int index = split.indexOf(")");
                long newNum = Long.parseLong(split.substring(0, index));
                numbers.push(newNum);
                int countClosed = 0;
                for (int i=0; i<split.length(); i++)
                    if (split.charAt(i) == ')')
                        countClosed++;

                for (int i=1; i<=countClosed; i++) {
                    while (!operators.peek().equals("(")) {
                        numbers.push(calculate(numbers.pop(), numbers.pop(), operators.pop()));
                    }
                    // remove the (
                    operators.pop();
                }
                continue;
            }
            numbers.push(Long.parseLong(split));
        }
        while (!operators.isEmpty()) {
            long res = calculate(numbers.pop(), numbers.pop(), operators.pop());
            numbers.push(res);
        }
        return numbers.pop();
    }

    private boolean isOperator(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }

    private long calculate(long num2, long num1, String op) {
        long result = 0;
        switch (op) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "*" -> result = num1 * num2;
            case "/" -> result = num1 / num2;
        }
        return result;
    }


    public long part2() {
        long sum = 0;
        for (String term : input) {
            sum += evaluate2(term);
        }
        return sum;
    }

    private long evaluate2(String term) {
        String[] splits = term.split(" ");
        Stack<Long> numbers = new Stack<>();
        Stack<String> operators = new Stack<>();

        for (String split : splits) {
            if (isOperator(split)) {
                if (operators.isEmpty() || operators.peek().equals("(") || hasPriority(split, operators.peek())) {
                    operators.push(split);
                    continue;
                }
                long res = calculate(numbers.pop(), numbers.pop(), operators.pop());
                numbers.push(res);
                operators.push(split);
                continue;
            }
            //number
            if (split.contains("(")) {
                int countOpen = 0;
                for (int i=0; i<split.length(); i++) {
                    if (split.charAt(i) == '(') {
                        countOpen++;
                        operators.push("(");
                    }
                }
                numbers.push(Long.parseLong(split.substring(countOpen)));
                continue;
            }
            if (split.contains(")")) {
                int index = split.indexOf(")");
                long newNum = Long.parseLong(split.substring(0, index));
                numbers.push(newNum);
                int countClosed = 0;
                for (int i=0; i<split.length(); i++)
                    if (split.charAt(i) == ')')
                        countClosed++;

                for (int i=1; i<=countClosed; i++) {
                    while (!operators.peek().equals("(")) {
                        numbers.push(calculate(numbers.pop(), numbers.pop(), operators.pop()));
                    }
                    // remove the (
                    operators.pop();
                }
                continue;
            }
            numbers.push(Long.parseLong(split));
        }
        while (!operators.isEmpty()) {
            long res = calculate(numbers.pop(), numbers.pop(), operators.pop());
            numbers.push(res);
        }
        return numbers.pop();
    }

    private boolean hasPriority(String op, String prevOp) {
        return op.equals("+") && prevOp.equals("*");
    }
}
