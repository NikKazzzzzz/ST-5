package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SqrtTest {

    @Test
    public void testConstructorWithPositiveValue() {
        Sqrt sqrt = new Sqrt(16.0);
        assertEquals(16.0, sqrt.arg, "Constructor should correctly initialize with a positive value");
    }

    @Test
    public void testConstructorWithZero() {
        Sqrt sqrt = new Sqrt(0.0);
        assertEquals(0.0, sqrt.arg, "Constructor should correctly initialize with zero");
    }

    @Test
    public void testAverageWithDifferentValues() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(5.5, sqrt.average(3.0, 8.0), "Average of 3.0 and 8.0 should be 5.5");
    }

    @Test
    public void testGoodWithExactSquareRoot() {
        Sqrt sqrt = new Sqrt(0);
        assertTrue(sqrt.good(3.0, 9.0), "Good should return true for an exact square root guess");
    }

    @Test
    public void testGoodWithFarGuess() {
        Sqrt sqrt = new Sqrt(0);
        assertFalse(sqrt.good(1.0, 25.0), "Good should return false for a guess far from the square root");
    }

    @Test
    public void testImproveWithEdgeCase() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(2.05, sqrt.improve(2.0, 4.2), 0.00001, "Improve should handle edge cases correctly");
    }

    @Test
    public void testIterWithSmallNumber() {
        Sqrt sqrt = new Sqrt(0.0004);
        assertEquals(0.02, sqrt.iter(1.0, 0.0004), 0.00000001, "Iter should converge for very small numbers");
    }

    @Test
    public void testCalcWithPerfectSquare() {
        Sqrt sqrt = new Sqrt(49.0);
        assertEquals(7.0, sqrt.calc(), 0.00000001, "Calc should return the correct square root for perfect squares");
    }

    @Test
    public void testCalcWithNonPerfectSquare() {
        Sqrt sqrt = new Sqrt(50.0);
        assertEquals(7.07106781, sqrt.calc(), 0.00000001, "Calc should return an approximate square root for non-perfect squares");
    }

    @Test
    public void testCalcWithNegativeNumberThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Sqrt(-9.0).calc();
        });
        assertEquals("Negative argument not allowed", exception.getMessage(), "Calc should throw an exception for negative input");
    }

    @Test
    public void testCalcWithLargeNumber() {
        Sqrt sqrt = new Sqrt(1_000_000.0);
        assertEquals(1000.0, sqrt.calc(), 0.00000001, "Calc should return the correct square root for large numbers");
    }

    @Test
    public void testCalcWithVerySmallPositiveNumber() {
        Sqrt sqrt = new Sqrt(0.000001);
        assertEquals(0.001, sqrt.calc(), 0.00000001, "Calc should return the correct square root for very small positive numbers");
    }
}