package com.unittesting;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FactorialTest {

    @Test
    public void givenZeroWhenGetResultThenFactorialEquals1() {
        // Given
        Factorial fib = new Factorial();

        // When
        int actual = fib.getResult(0);

        // Then
        int expected = 1;
        assertEquals(expected, actual);
    }
    
    @Test
    public void whenGetResultThenFactorialEquals1() {
        // Given
        Factorial fib = new Factorial();

        // When
        int actual = fib.getResult(1);

        // Then
        int expected = 1;
        assertEquals(expected, actual);
    }
    
    @Test
    public void whenGetResultThenFactorialEquals2() {
        // Given
        Factorial fib = new Factorial();

        // When
        int actual = fib.getResult(2);

        // Then
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void whenGetResultThenFactorialEquals6() {
        // Given
        Factorial fib = new Factorial();

        // When
        int actual = fib.getResult(3);

        // Then
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void givenNegativeIntegerWhenGetResultThenFactorialFailed() {
        // Then
        exceptionRule.expect(NumberFormatException.class);
        exceptionRule.expectMessage("Non negative numbers are allowed");

        // Given
        Factorial fib = new Factorial();

        // When
        fib.getResult(-5);

    }

    
}
