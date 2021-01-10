package ru.vsu.cs.samsonova;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double x = readValues("x:");
        if (x < -1 || x > 1) {
            System.out.println("The entered x value cannot be used. Enter again the x value from -1 to 1 ");
            return;
        }
        double n = readValues("n:");
        double e = readValues("e:");
        double sumElementsOfSequence = calculateSumElementsOfSequence(x, n);
        printResult("The sum n elements of sequence = ", sumElementsOfSequence);
        double sumElementsGreaterThanEpsilon = calculateSumElementsGreaterThanEpsilon(x, n, e);
        printResult("The sum of elements that are greater than epsilon in absolute value = ",
                sumElementsGreaterThanEpsilon);
        double sumElementsGreaterThanEpsilonDividedByTen = calculateSumElementsGreaterThanEpsilonDividedByTen(x, n, e / 10);
        printResult("The sum of elements that are greater than epsilon divided by ten in absolute value = ",
                sumElementsGreaterThanEpsilonDividedByTen);
        double functionValue = calculateResultFunctionValue(x);
        printResult("Value of the specified function = ", functionValue);
    }

    private static double readValues(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + name + " ");
        return scanner.nextDouble();
    }

    private static double calculateSumElementsOfSequence(double x, double n) {
        double sumNElements = 0;
        for (int i = 0; i <= n; i++) {
            sumNElements += calculateNElementOfSequence(x, n);
        }
        return sumNElements;
    }

    private static double calculateNElementOfSequence(double x, double n) {
        return Math.pow(x, n - 1);
    }

    private static double calculateSumElementsGreaterThanEpsilon(double x, double n, double e) {
        double sumElements = 0;
        for (int i = 0; i <= n; i++) {
            if (calculateNElementOfSequence(x, i) > e) {
                sumElements += calculateNElementOfSequence(x, i);
            }
        }
        return sumElements;
    }

    private static double calculateSumElementsGreaterThanEpsilonDividedByTen(double x, double n, double e) {
        double sumElements = 0;
        for (int i = 0; i <= n; i++) {
            if (calculateNElementOfSequence(x, i) > e / 10) {
                sumElements += calculateNElementOfSequence(x, i);
            }
        }
        return sumElements;
    }

    private static double calculateResultFunctionValue(double x) {
        return 1 / (1 - x);
    }

    private static void printResult(String text, double result) {
        System.out.println(text + result);
    }
}
