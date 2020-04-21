package ru.kutateladze.timur;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class IOTest {
    @Test
    public void testInput()
    {
        ByteArrayInputStream in = new ByteArrayInputStream("2+2*2".getBytes());
        System.setIn(in);
        String c = InOutCheck.input();
        assertTrue(c.equals("2+2*2"));
    }
    @Test (expected = IllegalArgumentException.class)
    public void testInputFail()
    {
        ByteArrayInputStream in = new ByteArrayInputStream("2++2**2".getBytes());
        System.setIn(in);
        String c = InOutCheck.input();

    }
    @Test (expected = IllegalArgumentException.class)
    public void testInputDoubleOperand()
    {
        ByteArrayInputStream in = new ByteArrayInputStream("2++2**2".getBytes());
        System.setIn(in);
        String c = InOutCheck.input();

    }
    @Test (expected = IllegalArgumentException.class)
    public void testIncorrectSym()
    {
        ByteArrayInputStream in = new ByteArrayInputStream("2&&?2**2?".getBytes());
        System.setIn(in);
        String c = InOutCheck.input();

    }
    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectSym2()
    {
        ByteArrayInputStream in = new ByteArrayInputStream("b+a".getBytes());
        System.setIn(in);
        String c = InOutCheck.input();

    }
}
