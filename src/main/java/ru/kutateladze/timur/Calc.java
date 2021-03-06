package ru.kutateladze.timur;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.NoSuchElementException;

public class Calc {
    public static Double calc(List<String> list) {
        Deque<Double> stack = new ArrayDeque<Double>();
        try{
            for (String s : list) {
                if (s.equals("+")) {
                    stack.push(stack.pop() + stack.pop());
                }
                else if (s.equals("-")) {
                    Double b = stack.pop(), a = stack.pop();
                    stack.push(a - b);
                }
                else if (s.equals("*")) {
                    stack.push(stack.pop() * stack.pop());
                }
                else if (s.equals("/")) {
                    Double b = stack.pop(), a = stack.pop();
                    stack.push(a / b);
                }
                else stack.push(Double.valueOf(s));
            }
        }
        catch (NoSuchElementException e){
            System.out.println("Некорректное выражение");
            System.exit(0);
        }
        return stack.pop();
    }
}
