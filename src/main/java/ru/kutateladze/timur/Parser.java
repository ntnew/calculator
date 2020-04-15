package ru.kutateladze.timur;
import java.util.*;

class Parser {
    private static String operators = "+-*/ ";
    public static boolean flag = true;

    private static boolean isOperator(String token) {
         for (int i = 0; i < operators.length(); i++) {
            if (token.charAt(0) == operators.charAt(i)) return true;
        }
        return false;
    }

    public static List<String> parse(String expression) {
        List<String> list = new ArrayList<String>();
        Deque<String> stack = new ArrayDeque<String>();
        StringTokenizer tokenizer = new StringTokenizer(expression, operators, true);
        String curr = "";
        while (tokenizer.hasMoreTokens()) {
            curr = tokenizer.nextToken();
            if (!tokenizer.hasMoreTokens() && isOperator(curr)) {
                System.out.println("Некорректное выражение.");
                flag = false;
                return list;
            }
            if (curr.equals(" ")) continue;
            else if (isOperator(curr)) {
                stack.push(curr);
            }
            else {
                list.add(curr);
            }
        }

       while (!stack.isEmpty()) {
            if (isOperator(stack.peek())) list.add(stack.pop());
            else {
                flag = false;
                return list;
            }
        }
        return list;
    }
}

