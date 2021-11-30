package Mathe;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestEvenOdd {
    @Test
    public void testIsEven1(){
        assertTrue(EvenOdd.isEven(0));
        assertTrue(EvenOdd.isEven(2));
        assertTrue(EvenOdd.isEven(4));
        assertTrue(EvenOdd.isEven(6));
        assertTrue(EvenOdd.isEven(8));
        assertTrue(EvenOdd.isEven(10));
    }

    @Test
    public void testIsEven2(){
        assertFalse(EvenOdd.isEven(1));
        assertFalse(EvenOdd.isEven(3));
        assertFalse(EvenOdd.isEven(5));
        assertFalse(EvenOdd.isEven(7));
        assertFalse(EvenOdd.isEven(9));
        assertFalse(EvenOdd.isEven(11));
    }

    @Test
    public void testIsOdd1(){
        assertTrue(EvenOdd.isOdd(1));
        assertTrue(EvenOdd.isOdd(3));
        assertTrue(EvenOdd.isOdd(5));
        assertTrue(EvenOdd.isOdd(7));
        assertTrue(EvenOdd.isOdd(9));
        assertTrue(EvenOdd.isOdd(11));
    }

    @Test
    public void testIsOdd2(){
        assertFalse(EvenOdd.isOdd(0));
        assertFalse(EvenOdd.isOdd(2));
        assertFalse(EvenOdd.isOdd(4));
        assertFalse(EvenOdd.isOdd(6));
        assertFalse(EvenOdd.isOdd(8));
        assertFalse(EvenOdd.isOdd(10));
    }
}
