package ru.kutateladze.timur;

import java.util.*;
import java.lang.*;
import java.io.*;

class App {

    public static void main (String[] args) {
        String s = InOutCheck.input();
        Parser p = new Parser();
        List<String> expression = p.parse(s);
        System.out.print(Calc.calc(expression));}
}
