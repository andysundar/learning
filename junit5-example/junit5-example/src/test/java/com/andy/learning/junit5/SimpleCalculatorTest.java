package com.andy.learning.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Test simple calculator.")
class SimpleCalculatorTest {

    private SimpleCalculator simpleCalculatorToTest = new SimpleCalculator();

    @Test
    @DisplayName("Add two positive numbers.")
    void addPositiveNumbers() {
        assertEquals(2 , simpleCalculatorToTest.add(1,1));
    }

    @Test
    @DisplayName("Add two negative numbers.")
    void addNegativeNumbers() {
        assertEquals(-2 , simpleCalculatorToTest.add(-1,-1));
    }

    @Test
    @DisplayName("Add one positive and one negative numbers but positive number is greater than negative number.")
    void addGreaterOnePositiveWithOneNegativeNumber() {
        assertEquals(1 , simpleCalculatorToTest.add(2,-1));
    }

    @Test
    @DisplayName("Add one positive and one negative numbers but positive number is less than negative number.")
    void addGreaterOneNegativeWithOnePositiveNumber() {
        assertEquals(-1 , simpleCalculatorToTest.add(-2,1));
    }

    @Test
    @DisplayName("Add two Integer.MAX_VALUE to test the return data type.")
    void addHighestIntNumber() {
        assertTrue(simpleCalculatorToTest.add(Integer.MAX_VALUE,Integer.MAX_VALUE) < 0,
                ()-> "Data type overflow.");
    }

    @Test
    @DisplayName("Minus two positive numbers.")
    void minusPositiveNumbers() {
        assertEquals(1, simpleCalculatorToTest.minus(3,2));
    }

    @Test
    @DisplayName("Minus two negative numbers.")
    void minusNegativeNumbers() {
        assertEquals(0, simpleCalculatorToTest.minus(-2,-2));
    }

    @Test
    @DisplayName("Minus 1st param negative number and 2nd param positive number.")
    void minus1stParamNegativeNumberAndSecondParamPositiveNumber() {
        assertEquals(-4, simpleCalculatorToTest.minus(-2,2));
    }

    @Test
    @DisplayName("Minus 1st param positive number and 2nd param negative number.")
    void minus1stParamPositiveNumberAnd2ndParamNegativeNumber() {
        assertEquals(4, simpleCalculatorToTest.minus(2,-2));
    }

    @Test
    @DisplayName("Minus two Integer.MAX_VALUE numbers.")
    void minusMaxIntegerValue() {
        assertEquals(0, simpleCalculatorToTest.minus(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test
    @DisplayName("Multiply two positive numbers.")
    void multiplyTwoPositiveNumbers() {
        assertEquals(4, simpleCalculatorToTest.multiply(2, 2));
    }

    @Test
    @DisplayName("Multiply two negative numbers.")
    void multiplyTwoNegativeNumbers() {
        assertEquals(4, simpleCalculatorToTest.multiply(-2, -2));
    }

    @Test
    @DisplayName("Multiply one negative and positive number.")
    void multiplyPositiveAndNegative() {
        assertEquals(-2, simpleCalculatorToTest.multiply(1, -2));
    }

    @Test
    @DisplayName("Multiply any number with ZERO.")
    void multiplyWithZero() {
        assertEquals(0, simpleCalculatorToTest.multiply(Integer.MIN_VALUE, -2));
    }

    @Test
    @DisplayName("Multiply Integer.MAX_VALUE with 2.")
    void multiplyTwoLargeIntegers() {
        assertTrue(simpleCalculatorToTest.multiply(Integer.MAX_VALUE, 2) < 0 ,
                ()-> "Data type overflow");
    }

    @Test
    @DisplayName("Divide same number.")
    void divideSameNumber() {
        assertEquals(1, simpleCalculatorToTest.divide(2,2));
        assertEquals(1, simpleCalculatorToTest.divide(-2,-2));
    }

    @Test
    @DisplayName("Divide when numerator is zero.")
    void divideNumeratorIsZero() {
        assertEquals(0, simpleCalculatorToTest.divide(0,2));
        assertEquals(0, simpleCalculatorToTest.divide(0,-2));
    }

    @Test
    @DisplayName("Divide two different numbers")
    void divideDifferentNumbers() {
        assertEquals(-1, simpleCalculatorToTest.divide(-3,2));
        assertEquals(-1, simpleCalculatorToTest.divide(3,-2));
    }

    @Test
    @DisplayName("Divide two different numbers")
    void divideDenominatorIsZero() {
        assertThrows(ArithmeticException.class, () -> simpleCalculatorToTest.divide(-3,0));
    }
}