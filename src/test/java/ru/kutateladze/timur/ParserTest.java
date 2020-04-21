package ru.kutateladze.timur;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ParserTest {
    @Test
    public void testInput()
    {
        String s ="2+2*2";
        List<String> list1 = Arrays.asList("2", "2", "2", "*", "+");
        List<String> list = Parser.parse(s);
        assertTrue(list.equals(list1));
    }
    @Test
    public void testInput1()
    {
        String s ="2+2*2/4+4-2";
        List<String> list1 = Arrays.asList("2", "2", "2", "*", "4", "/", "+", "4", "+", "2", "-");
        List<String> list = Parser.parse(s);
        assertTrue(list.equals(list1));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInput2()
    {
        String s ="2+2*2/4+4-2+";
        List<String> list = Parser.parse(s);
    }


}
