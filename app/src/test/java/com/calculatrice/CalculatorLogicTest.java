
package com.calculatrice;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorLogicTest {

    // Addition
    @Test
    public void testAddition() {
        assertEquals(8.0,
                CalculatorLogic.calculate(5, 3, "+"), 0.000001);
    }

    // Subtraction
    @Test
    public void testSubtraction() {
        assertEquals(6.0,
                CalculatorLogic.calculate(10, 4, "-"), 0.000001);
    }

    // Multiplication
    @Test
    public void testMultiplication() {
        assertEquals(56.0,
                CalculatorLogic.calculate(7, 8, "×"), 0.000001);
    }

    // Division
    @Test
    public void testDivision() {
        assertEquals(5.0,
                CalculatorLogic.calculate(20, 4, "÷"), 0.000001);
    }

    // Decimal numbers
    @Test
    public void testDecimalNumbers() {
        assertEquals(0.3,
                CalculatorLogic.calculate(0.1, 0.2, "+"), 0.000001);
    }

    // Percentage
    @Test
    public void testPercentage() {
        assertEquals(0.5,
                CalculatorLogic.percentage(50), 0.000001);
    }

    // Square root
    @Test
    public void testSquareRoot() {
        assertEquals(5.0,
                CalculatorLogic.squareRoot(25), 0.000001);
    }

    // Square
    @Test
    public void testSquare() {
        assertEquals(25.0,
                CalculatorLogic.square(5), 0.000001);
    }

    // Clear
    @Test
    public void testClear() {
        assertEquals("0", CalculatorLogic.clear());
    }

    // Delete last character
    @Test
    public void testDeleteLast() {
        assertEquals("12", CalculatorLogic.deleteLast("123"));
    }

    // Division by zero
    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        CalculatorLogic.calculate(10, 0, "/");
    }

    // Negative square root
    @Test(expected = ArithmeticException.class)
    public void testNegativeSquareRoot() {
        CalculatorLogic.squareRoot(-9);
    }

    // Invalid number
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNumber() {
        CalculatorLogic.convertToNumber("abc");
    }

    // Large numbers
    @Test
    public void testLargeNumbers() {
        assertEquals(1e101,
                CalculatorLogic.calculate(1e100, 10, "*"), 1e90);
    }
}
