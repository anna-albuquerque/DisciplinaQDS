package com.example;

import com.example.service.CalculatorService;

public class App {

	public static void main(String[] args) {
		CalculatorService calculator = new CalculatorService();
		int result = calculator.add(2, 3);
		System.out.println("Result: " + result);
	}

}
