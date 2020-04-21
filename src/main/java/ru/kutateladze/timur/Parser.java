package ru.kutateladze.timur;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    private static String operators = "+-*/ ";

    private static boolean isOperator(String token) {
         for (int i = 0; i < operators.length(); i++) {
            if (token.charAt(0) == operators.charAt(i)) return true;
        }
        return false;
    }
    private static int priority(String token) {
        if (token.equals("+") || token.equals("-")) return 2;
        if (token.equals("*") || token.equals("/")) return 3;
        return 4;
    }

    public static List<String> parse(String expression) {
        List<String> list = new ArrayList<String>();
        Deque<String> stack = new ArrayDeque<String>();

        StringTokenizer tokenizer = new StringTokenizer(expression, operators, true);

        String curr = "";

        while (tokenizer.hasMoreTokens()) {
            curr = tokenizer.nextToken();
            if (!tokenizer.hasMoreTokens() && isOperator(curr)) {
                    System.out.println("Ошибка в выражении");
                    throw new IllegalArgumentException();
            }
            if (curr.equals(" ")) continue;
            else if (isOperator(curr)) {
                while (!stack.isEmpty() && (priority(curr) <= priority(stack.peek()))) {
                    list.add(stack.pop());
                }
                stack.push(curr);
            }
            else {
                list.add(curr);
            }

        }

        while (!stack.isEmpty()) {
            if (isOperator(stack.peek())) list.add(stack.pop());
            else {
                return list;
            }
        }
        System.out.println(list);
        return list;
    }
}

