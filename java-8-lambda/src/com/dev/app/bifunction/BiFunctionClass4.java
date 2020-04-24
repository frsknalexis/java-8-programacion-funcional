package com.dev.app.bifunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionClass4 {

	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> biFunctionSum = Integer::sum;
		System.out.println("Sum = " + biFunctionSum.apply(2, 3));
		
		BiFunction<Integer, Integer, Integer> biFunctionMultiply = (a, b) -> a * b;
		System.out.println("Product = " + biFunctionMultiply.apply(2, 3));
		
		BiFunction<Integer, Integer, Integer> composite1 = Integer::sum;
		Function<Integer, Integer> function1 = (i) -> i * 2;
		
		System.out.println("Composite1 = " + composite1.andThen(function1).apply(2, 3));
		
		BiFunction<Integer, Integer, Integer> composite2 = (a, b) -> a * b;
		Function<Integer, Integer> function2 = (i) -> i * 3;
		
		System.out.println("Composite2 = " + composite2.andThen(function2).apply(2, 3));
	}
}
