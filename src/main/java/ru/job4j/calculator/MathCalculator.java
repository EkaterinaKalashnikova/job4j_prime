package ru.job4j.calculator;

import ru.job4j.math.*;

import static ru.job4j.math.MathFunction.*;

public class MathCalculator {
    public static double sumAndMultiply(double first, double second) {
        double a = sum(first, second)
                + multiply(first, second);
        return a;
    }

    public static double difAndDivision(double three, double four) {
        double b = dif(three, four)
                + division(three, four);
        return b;
    }

    public static double sumTwoSet(double a, double b) {
        return a + b;
    }

    public static double sumCalcFourOperations(double a, double b, double c, double d) {
        return a + b + c + d;
    }

    public static void main(String[] args) {
        System.out.println("Результат расчета1 равен: " + sumAndMultiply(10, 20));
        System.out.println("Результат расчета2 равен: " + difAndDivision(50, 20));
        System.out.println("Сумма расчета1 и расчета2 равна: " + sumTwoSet(sumAndMultiply(10, 20), difAndDivision(50, 20)));
        System.out.println("Сумма сложения, умножения, разности и деления равна: "
                + sumCalcFourOperations(sum(10, 20), multiply(10, 20), dif(30, 10), division(30, 10)));
    }
}
