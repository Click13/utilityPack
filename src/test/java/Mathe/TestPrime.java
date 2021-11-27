package Mathe;

import static Mathe.Prime.isPrimeNumber;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestPrime {
    @Test
    public void testIsPrimeNumber(){
        assertTrue(isPrimeNumber(2));
        assertTrue(isPrimeNumber(3));
        assertTrue(isPrimeNumber(5));
        assertFalse(isPrimeNumber(4));
    }

    @Test
    public void testIsPrimeNumber2(){
        int[] tests = new int[4];
        tests[0] = 2;
        tests[1] = 3;
        tests[2] = 4;
        tests[3] = 5;
        int[] ergebnis = new int[4];
        ergebnis[0] = 2;
        ergebnis[1] = 3;
        ergebnis[3] = 5;
        int[] rückgabe = isPrimeNumber(tests);
        assertArrayEquals(ergebnis,rückgabe);
        assertArrayEquals(rückgabe,ergebnis);
    }
}
