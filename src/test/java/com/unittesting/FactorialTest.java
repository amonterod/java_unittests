package com.unittesting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FactorialTest {

    @Test
    public void shouldFactorialEquals1() {
        // Given
        Factorial fib = new Factorial();

        // When
        int actual = fib.getResult(1);

        // Then
        int expected = 1;
        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldFactorialEquals2() {
        // Given
        Factorial fib = new Factorial();

        // When
        int actual = fib.getResult(2);

        // Then
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFactorialEquals6() {
        // Given
        Factorial fib = new Factorial();

        // When
        int actual = fib.getResult(3);

        // Then
        int expected = 6;
        assertEquals(expected, actual);
    }
}
