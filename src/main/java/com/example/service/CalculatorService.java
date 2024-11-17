package com.example.service;

public class CalculatorService {
    // Soma
    public int add(int a, int b) {
        return a + b;
    }

    // Subtração
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiplicação
    public int multiply(int a, int b) {
        return a * b;
    }

    // Divisão
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divisão por 0 não é permitida.");
        }
        return a / b;
    }

    // Módulo (resto da divisão)
    public int modulo(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Módulo por 0 não é permitido.");
        }
        return a % b;
    }

    // Exponenciação (a^b)
    public double power(double a, double b) {
        return Math.pow(a, b);
    }
}
