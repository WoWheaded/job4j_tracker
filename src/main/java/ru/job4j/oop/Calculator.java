package ru.job4j.oop;

public class Calculator {
    private static final int X = 5;

    public static int sum(int y) {
        return X + y;
    }

    public int multiply(int a) {
        return X * a;
    }

    public static int minus(int s) {
        return s - X;
    }

    public int divide(int s) {
        return s / X;
    }

    public int sumAllOperation(int s) {
        return sum(s) + multiply(s) + minus(s) + divide(s);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("Sum: " + Calculator.sum(15));
        System.out.println("Multiply: " + calculator.multiply(15));
        System.out.println("Minus: " + Calculator.minus(15));
        System.out.println("Divide: " + calculator.divide(15));
        System.out.println("Summ all operations: " + calculator.sumAllOperation(15));
    }
}
