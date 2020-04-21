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
                    if (b==0) {
                        System.out.println("Деление на ноль");
                        throw new IllegalArgumentException();
                    }
                    else stack.push(a / b);
                }
                else stack.push(Double.valueOf(s));
            }
            return stack.pop();
        }
      /*  catch (NumberFormatException e){
            System.out.println("Некорректное выражение2");
        }*/
        catch (NoSuchElementException e){
            System.out.println("Некорректное выражение1");
        }

        return stack.pop();
    }
}
