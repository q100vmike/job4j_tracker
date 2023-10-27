package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int multyply(int a) {
        return x * a;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multyply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println("sum(10) = " + result);
        System.out.println("multiply(10) = " + multyply(10));
        System.out.println("minus(5) = " + minus(5));
        Calculator calc = new Calculator();
        calc.divide(20);
        System.out.println("calc.sumAllOperation(1) = " + calc.sumAllOperation(1));
    }
}
