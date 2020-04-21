package ru.kutateladze.timur;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertTrue;

public class CalcTest {

    @Test
    public void testAdd()
    {
        List<String> list = new ArrayList<>();
        list.add("5");
        list.add("123");
        list.add("+");
        double c = Calc.calc(list);
        assertTrue("неправильно складывает",c==128 );
    }
    @Test
    public void testDeduction()
    {
        List<String> list = new ArrayList<>();
        list.add("5");
        list.add("123");
        list.add("-");
        double c = Calc.calc(list);
        assertTrue(c==-118 );
    }
    @Test
    public void testDivision()
    {
        List<String> list = new ArrayList<>();
        list.add("15");
        list.add("3");
        list.add("/");
        double c = Calc.calc(list);
        assertTrue("неправильно делит",c==5);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDivisionNull()
    {
        List<String> list = new ArrayList<>();
        list.add("15");
        list.add("0");
        list.add("/");
        double c = Calc.calc(list);
    }
    @Test
    public void testMultiply()
    {
        List<String> list = new ArrayList<>();
        list.add("15");
        list.add("3");
        list.add("*");
        double c = Calc.calc(list);
        assertTrue("неправильно делит",c==45);
    }
    @Test(expected = NumberFormatException.class)
    public void testNullLine()
    {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("+");
        double c = Calc.calc(list);
    }
    @Test(expected = NoSuchElementException.class)
    public void testNonexistentElement()
    {
        List<String> list = new ArrayList<>();
        list.add("+");
        list.add("2");
        double c = Calc.calc(list);
    }
}
