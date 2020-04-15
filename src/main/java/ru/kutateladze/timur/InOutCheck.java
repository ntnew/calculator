package ru.kutateladze.timur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InOutCheck {
    public static String input(){
        String expression = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            expression = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Pattern pattern = Pattern.compile("[\\D&&[^-*/+. ]]");//a-zA-Zа-яА-я
        Matcher matcher = pattern.matcher(expression);
        if(matcher.find()) {
            System.out.println("Некорректное выражение");
            return null;
        }
        return expression;
    }
}
