
package com.calculatrice;

public class CalculatorLogic {

    // Basic arithmetic operations
    public static double calculate(double num1, double num2, String operator) {

        switch (operator) {

            case "+":
                return num1 + num2;

            case "-":
                return num1 - num2;

            case "×":
            case "*":
                return num1 * num2;

            case "÷":
            case "/":

                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }

                return num1 / num2;

            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    // Percentage
    public static double percentage(double number) {
        return number / 100;
    }

    // Square root
    public static double squareRoot(double number) {

        if (number < 0) {
            throw new ArithmeticException("Invalid square root");
        }

        return Math.sqrt(number);
    }

    // Square (x²)
    public static double square(double number) {
        return number * number;
    }

    // Clear all
    public static String clear() {
        return "0";
    }

    // Delete last character
    public static String deleteLast(String number) {

        if (number == null || number.length() <= 1) {
            return "0";
        }

        String result = number.substring(0, number.length() - 1);

        if (result.equals("-") || result.equals("")) {
            return "0";
        }

        return result;
    }

    // Convert text into a number
    public static double convertToNumber(String number) {

        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number");
        }
    }
}

