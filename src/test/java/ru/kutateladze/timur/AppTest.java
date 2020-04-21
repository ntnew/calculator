package ru.kutateladze.timur;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test(expected = IllegalArgumentException.class)
    public void testInput1()
    {
        String[] args = null;
        ByteArrayInputStream in = new ByteArrayInputStream("2+2*2-".getBytes());
        System.setIn(in);
        App.main(args);
    }
}
